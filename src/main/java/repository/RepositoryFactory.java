package repository;



import javax.persistence.EntityManager;

public class RepositoryFactory {

    public EstudianteRepositoryImpl getEstudianteRepository(EntityManager em){
        return new EstudianteRepositoryImpl(em);
    }

    public CarreraRepositoryImpl getCarreraRepository(EntityManager em){
        return new CarreraRepositoryImpl(em);
    }

}
