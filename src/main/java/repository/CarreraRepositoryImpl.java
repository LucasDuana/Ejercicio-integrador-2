package repository;

import DTO.CarreraDTO;
import DTO.ReporteDTO;
import model.Carrera;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CarreraRepositoryImpl extends RepositoryImpl<Carrera,Long> implements CarreraRepository {

    private static CarreraRepositoryImpl instancia;

    private CarreraRepositoryImpl(EntityManager em) {
        super(Carrera.class,em);

    }

    public static CarreraRepositoryImpl getInstancia(EntityManager em){
        if(instancia == null)
            return new CarreraRepositoryImpl(em);
        else
            return instancia;
    }

    private List<CarreraDTO> toCarrerasDTO(List<Carrera> carreras){
        ArrayList<CarreraDTO> conversion = new ArrayList<>();
        for(Carrera c: carreras){
            CarreraDTO carreraDTO = new CarreraDTO(c);
            conversion.add(carreraDTO);
        }

        return conversion;
    }

    @Override
    public List<CarreraDTO> obtenerCarrerasConEstudiantesInscriptos() {
        TypedQuery<Carrera> query = em.createQuery(
                "SELECT c FROM Carrera c JOIN EstudianteCarrera ec ON c.id = ec.carrera.id GROUP BY c ORDER BY COUNT(ec) DESC",
                Carrera.class
        );
        return this.toCarrerasDTO(query.getResultList());
    }

    @Override
    public int obtenerCantidadDeInscriptos() {
        TypedQuery<Integer> query = em.createQuery("SELECT COUNT(ec) FROM EstudianteCarrera ec",Integer.class );
        Integer count = query.getSingleResult();
        return count!=null ?count.intValue():0;
    }


    public List<ReporteDTO> generarReporteCarreras() {
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT c.carrera, YEAR(ec.inscripcion), " +
                        "SUM(CASE WHEN ec.graduacion IS NOT NULL THEN 1 ELSE 0 END) AS graduados, " +
                        "COUNT(ec) AS inscriptos " +
                        "FROM EstudianteCarrera ec " +
                        "JOIN ec.carrera c " +
                        "GROUP BY c.carrera, YEAR(ec.inscripcion) " +
                        "ORDER BY c.carrera ASC, YEAR(ec.inscripcion) ASC",
                Object[].class
        );

        List<Object[]> resultados = query.getResultList();
        List<ReporteDTO> reporte = new ArrayList<>();

        for (Object[] fila : resultados) {
            String nombreCarrera = (String) fila[0];
            int anio = (int) fila[1];
            long graduados = (long) fila[2];
            long inscriptos = (long) fila[3];

            ReporteDTO dtoActual = new ReporteDTO(nombreCarrera, anio, graduados, inscriptos);
            reporte.add(dtoActual);
        }

        return reporte;
    }
}



