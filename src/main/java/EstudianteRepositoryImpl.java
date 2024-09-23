import EstudainetRepository.EstudianteRepository;
import model.Carrera;
import model.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    private EntityManager em;

    public EstudianteRepositoryImpl(EntityManager em) {
        this.em=em;
    }
    @Override
    public List<Estudiante> obtenerEstudiantes() {
        return List.of();
    }

    @Override
    public Estudiante obtenerEstudianteLibreta(String libreta) {
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e WHERE e.numeroLibretaUniversitaria=:libreta", Estudiante.class);
        q.setParameter("libreta", libreta);
        return q.getSingleResult();
    }

    @Override
    public List<Estudiante> obtenerEstudiantesPorGenero(String genero) {
        List<Estudiante> estudiantesPorGenero = new ArrayList<>();
        TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero=:genero", Estudiante.class);
        q.setParameter("genero", genero);
        for(int i =0;i<q.getMaxResults();i++)
            estudiantesPorGenero.add(q.getSingleResult());
        return estudiantesPorGenero;
    }

    @Override
    public List<Estudiante> obtenerEstudiantesPorCarrera(Carrera carrera) {
        return List.of();
    }
}
