package helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerJPA {

    private static EntityManagerFactory emf;

    private EntityManagerJPA(){
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        if(emf==null){
            emf= Persistence.createEntityManagerFactory("MYSQL_persistence");
        }
        return emf;
    }

    public static EntityManager getEntityManager(){
        return getEntityManagerFactory().createEntityManager();
    }

    public static void closeEntityManagerFactory(){
        if((emf != null && emf.isOpen()))
            emf.close();
    }

}
