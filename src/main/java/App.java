import helper.EntityManagerJPA;
import repository.CarreraRepositoryImpl;
import repository.EstudianteRepositoryImpl;
import repository.RepositoryFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
        EntityManager em = EntityManagerJPA.getEntityManager();

        RepositoryFactory rf = new RepositoryFactory();
        EstudianteRepositoryImpl estudianteRepo= rf.getEstudianteRepository(em);
        CarreraRepositoryImpl carreraRepo= rf.getCarreraRepository(em);




    }
}
