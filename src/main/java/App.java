import helper.EntityManagerJPA;
import model.Carrera;
import model.Estudiante;
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

        //Estudiante e1 = new Estudiante("Lucas", "Duana", 24, "Hombre", "42630319", "Rauch","Numero de libreta del Duana", false);
        //Carrera c1 = new Carrera("Tudai", 2);

        //estudianteRepo.save(e1);
        //carreraRepo.save(c1);
        estudianteRepo.matricularEstudianteEnCarrera(1L,1L);




    }
}
