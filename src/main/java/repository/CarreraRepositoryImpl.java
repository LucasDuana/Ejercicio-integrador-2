package repository;

import DTO.CarreraDTO;
import DTO.CarreraDTOCant;
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
    public List<CarreraDTOCant> obtenerCarrerasConEstudiantesInscriptos() {
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT c, COUNT(ec) FROM Carrera c JOIN EstudianteCarrera ec ON c.id = ec.carrera.id " +
                        "GROUP BY c ORDER BY COUNT(ec) DESC",
                Object[].class
        );

        List<Object[]> results = query.getResultList();
        List<CarreraDTOCant> carrerasDTOCant = new ArrayList<>();

        for (Object[] result : results) {
            Carrera carrera = (Carrera) result[0];
            Long cantInscriptos = (Long) result[1];  // La cantidad de inscriptos es devuelta como Long por COUNT
            carrerasDTOCant.add(new CarreraDTOCant(carrera, cantInscriptos.intValue()));
        }

        return carrerasDTOCant;
    }


    public List<ReporteDTO> generarReporteCarreras() {
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT c.carrera, ec.inscripcion AS anio, " +
                        "SUM(CASE WHEN ec.graduacion = 0 THEN 1 ELSE 0 END) AS graduados, " + // Graduados que tienen graduacion en 0
                        "COUNT(CASE WHEN ec.graduacion > 0 THEN 1 END) AS inscriptos " + // Inscritos que no están graduados
                        "FROM EstudianteCarrera ec " +
                        "JOIN ec.carrera c " +
                        "WHERE ec.inscripcion IS NOT NULL " +
                        "GROUP BY c.carrera, ec.inscripcion " +
                        "HAVING COUNT(ec) > 0 " +
                        "ORDER BY ec.inscripcion ASC, c.carrera ASC",
                Object[].class
        );
        List<Object[]> resultados = query.getResultList();
        List<ReporteDTO> reporte = new ArrayList<>();

        for (Object[] fila : resultados) {
            String nombreCarrera = (String) fila[0];
            Integer anio = (Integer) fila[1]; // Obtener el año directamente
            long graduados = (long) fila[2];
            long inscriptos = (long) fila[3];

            ReporteDTO dtoActual = new ReporteDTO(nombreCarrera, anio, graduados, inscriptos);
            reporte.add(dtoActual);
        }

        return reporte;
    }
}



