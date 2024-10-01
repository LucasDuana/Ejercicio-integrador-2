package repository;

import DTO.EstudianteDTO;
import model.Carrera;
import model.Estudiante;
import model.EstudianteCarrera;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class EstudianteRepositoryImpl extends RepositoryImpl<Estudiante,Long> implements EstudianteRepository {

    private static EstudianteRepositoryImpl  instancia;

    private EstudianteRepositoryImpl(EntityManager em) {
        super(Estudiante.class,em);
    }

    public static EstudianteRepositoryImpl getInstance(EntityManager em) {
        if (instancia == null) {
            instancia = new EstudianteRepositoryImpl(em);
        }
        return instancia;
    }

    private List<EstudianteDTO> toEstudiantesDTO(List<Estudiante> estudiantes){
        ArrayList<EstudianteDTO> conversion = new ArrayList<>();
        for(Estudiante e: estudiantes){
            EstudianteDTO estudianteDTO = new EstudianteDTO(e);
            conversion.add(estudianteDTO);
        }

        return conversion;
    }


    @Override
    public List<EstudianteDTO> obtenerEstudiantesPorCarreraYCiudad(Long idCarrera, String ciudad) {
        TypedQuery<Estudiante> q = em.createQuery(
                "SELECT e FROM Estudiante e JOIN EstudianteCarrera ec ON e.dni = ec.estudiante.id WHERE ec.carrera.id = :carreraId AND e.ciudad = :ciudad",
                Estudiante.class
        );
        q.setParameter("carreraId", idCarrera);
        q.setParameter("ciudad", ciudad);
        return this.toEstudiantesDTO(q.getResultList());
    }

    @Override
    public EstudianteDTO obtenerEstudianteLibreta(String libreta) {
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e WHERE e.lu=:libreta", Estudiante.class);
        q.setParameter("libreta", libreta);
        Estudiante buscado = q.getSingleResult();
        return new EstudianteDTO(buscado);
    }

    @Override
    public List<EstudianteDTO> obtenerEstudiantesPorGenero(String genero) {
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero=:genero", Estudiante.class);
        q.setParameter("genero", genero);
        return this.toEstudiantesDTO(q.getResultList());
    }

    @Override
    public void matricularEstudianteEnCarrera(Long id,Long dni, Long carreraId, Integer inscripcion, Integer graduacion, Integer antiguedad) {

        Estudiante estudiante = em.find(Estudiante.class, dni);

        Carrera carrera = em.find(Carrera.class, carreraId);

        try {
            em.getTransaction().begin();
            EstudianteCarrera estudianteCarrera = new EstudianteCarrera(id,carrera, estudiante, inscripcion, graduacion, antiguedad);
            em.persist(estudianteCarrera);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public List<EstudianteDTO> obtenerEstudiantesPorCarrera(Long id) {
        TypedQuery<Estudiante> q = em.createQuery("""
                SELECT e FROM Estudiante e JOIN EstudianteCarrera ec ON e.dni = ec.estudiante.id WHERE ec.carrera.id = :carreraId""", Estudiante.class);
        q.setParameter("carreraId", id);
        return this.toEstudiantesDTO(q.getResultList());
    }

    @Override
    public List<EstudianteDTO> obtenerEstudiantesOrdenados(String criterio) {
        TypedQuery<Estudiante> q;
        if (criterio.equalsIgnoreCase("apellido")) {
            q = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.apellido", Estudiante.class);
        } else if (criterio.equalsIgnoreCase("nombres")) {
            q = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.nombre", Estudiante.class);
        } else {
            // traer sin orden
            q = em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        }
        return this.toEstudiantesDTO(q.getResultList());
    }
}
