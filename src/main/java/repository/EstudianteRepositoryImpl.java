package repository;

import model.Carrera;
import model.Estudiante;
import model.EstudianteCarrera;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EstudianteRepositoryImpl extends RepositoryImpl<Estudiante,Long> implements EstudianteRepository {

    public EstudianteRepositoryImpl(EntityManager em) {
        super(Estudiante.class,em);
    }
/*
    @Override
    public List<Estudiante> obtenerEstudiantes() {
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return q.getResultList();
    }

    @Override
    public void darDeAltaEstudiante(Estudiante estudiante) {
        try {
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }*/

    @Override
    public List<Carrera> obtenerCarrerasConEstudiantesInscriptos() {
        TypedQuery<Carrera> query = em.createQuery(
                "SELECT c FROM Carrera c JOIN EstudianteCarrera ec ON c.id = ec.carrera.id GROUP BY c ORDER BY COUNT(ec) DESC",
                Carrera.class
        );
        return query.getResultList();
    }

    @Override
    public List<Estudiante> obtenerEstudiantesPorCarreraYCiudad(Carrera carrera, String ciudad) {
        TypedQuery<Estudiante> q = em.createQuery(
                "SELECT e FROM Estudiante e JOIN EstudianteCarrera ec ON e.estudiante_id = ec.estudiante.id WHERE ec.carrera.id = :carreraId AND e.ciudadResidencia = :ciudad",
                Estudiante.class
        );
        q.setParameter("carreraId", carrera.getId_carrera());
        q.setParameter("ciudad", ciudad);
        return q.getResultList();
    }

    @Override
    public Estudiante obtenerEstudianteLibreta(String libreta) {
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e WHERE e.numeroLibretaUniversitaria=:libreta", Estudiante.class);
        q.setParameter("libreta", libreta);
        return q.getSingleResult();
    }

    @Override
    public List<Estudiante> obtenerEstudiantesPorGenero(String genero) {
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero=:genero", Estudiante.class);
        q.setParameter("genero", genero);
        return q.getResultList();
    }

    @Override
    public void matricularEstudianteEnCarrera(Long estudianteId, Long carreraId) {

        Estudiante estudiante = em.find(Estudiante.class, estudianteId);
        if (estudiante == null) {
            throw new IllegalArgumentException("Estudiante no encontrado con ID: " + estudianteId);
        }

        Carrera carrera = em.find(Carrera.class, carreraId);
        if (carrera == null) {
            throw new IllegalArgumentException("Carrera no encontrada con ID: " + carreraId);
        }

        try {
            em.getTransaction().begin();
            EstudianteCarrera estudianteCarrera = new EstudianteCarrera(carrera, estudiante);
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
    public List<Estudiante> obtenerEstudiantesPorCarrera(Carrera carrera) {
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e JOIN EstudianteCarrera ec ON e.estudiante_id = ec.estudiante.id WHERE ec.carrera.id = :carreraId", Estudiante.class);
        q.setParameter("carreraId", carrera.getId_carrera());
        return q.getResultList();
    }

    @Override
    public List<Estudiante> obtenerEstudiantesOrdenados(String criterio) {
        TypedQuery<Estudiante> q;
        if (criterio.equalsIgnoreCase("apellido")) {
            q = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.apellido", Estudiante.class);
        } else if (criterio.equalsIgnoreCase("nombres")) {
            q = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.nombres", Estudiante.class);
        } else {
            // traer sin orden
            q = em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        }
        return q.getResultList();
    }
}
