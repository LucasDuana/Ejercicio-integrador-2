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
                "SELECT c.nombre, ec.antiguedad, " +
                        "SUM(CASE WHEN e.graduado = TRUE THEN 1 ELSE 0 END) AS graduados, " +
                        "SUM(CASE WHEN e.graduado = FALSE THEN 1 ELSE 0 END) AS noGraduados " +
                        "FROM EstudianteCarrera ec " +
                        "JOIN ec.carrera c " +
                        "JOIN ec.estudiante e " +
                        "GROUP BY c.nombre, ec.antiguedad " +
                        "ORDER BY c.nombre ASC, ec.antiguedad ASC",
                Object[].class
        );

        List<Object[]> resultados = query.getResultList();
        List<ReporteDTO> reporte = new ArrayList<>();


        for (Object[] fila : resultados) {
            String nombreCarrera = (String) fila[0];
            int antiguedad = (int) fila[1];
            long graduados = (long) fila[2];
            long noGraduados = (long) fila[3];

            ReporteDTO dtoActual = new ReporteDTO(nombreCarrera, antiguedad, graduados, noGraduados);
            reporte.add(dtoActual);
        }

        return reporte;
    }
}



