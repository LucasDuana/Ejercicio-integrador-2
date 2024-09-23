import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MYSQL_persistence");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();


        entityManagerFactory.close();
    }
}
