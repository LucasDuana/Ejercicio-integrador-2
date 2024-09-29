package repository;



import javax.persistence.EntityManager;

public class RepositoryFactory {

    public EstudianteRepositoryImpl getEstudianteRepository(EntityManager em){
        return EstudianteRepositoryImpl.getInstance(em);
    }

    public CarreraRepositoryImpl getCarreraRepository(EntityManager em){
        return CarreraRepositoryImpl.getInstancia(em);
    }

}
