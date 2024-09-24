import CarreraRepository.CarreraRepository;
import model.Carrera;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarreraRepositoryImpl implements CarreraRepository {
    @Override
    public List<Carrera> obtenerCarrerasConEstudiantesInscriptos() {
        EntityManager em = null;
        TypedQuery<Carrera> query = em.createQuery(
                "SELECT c FROM Carrera c JOIN EstudianteCarrera ec ON c.id = ec.carrera.id GROUP BY c.id",
                Carrera.class
        );
        return query.getResultList();
    }

}
