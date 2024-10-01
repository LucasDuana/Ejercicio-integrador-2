import DTO.ReporteDTO;
import helper.EntityManagerJPA;
import model.Carrera;
import model.Estudiante;
import repository.CarreraRepositoryImpl;
import repository.EstudianteRepositoryImpl;
import repository.RepositoryFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        EntityManager em = EntityManagerJPA.getEntityManager();

        RepositoryFactory rf = new RepositoryFactory();
        EstudianteRepositoryImpl estudianteRepo= rf.getEstudianteRepository(em);
        CarreraRepositoryImpl carreraRepo= rf.getCarreraRepository(em);

        Estudiante e1 = new Estudiante("Lucas", "Duana", 24, "Hombre", "42630319", "Rauch","Numero de libreta del Duana", false);
        Estudiante e2 = new Estudiante ("Agustin", "Carretto", 24, "Hombre","41235632","Gesell", "254136", false);
        Estudiante e3 = new Estudiante("María", "Fernández", 22, "Mujer", "47856321", "Buenos Aires", "Libreta 7890", true);
        Estudiante e4 = new Estudiante("Pedro", "Gómez", 25, "Hombre", "23456789", "Córdoba", "Libreta 1234", false);
        Estudiante e5 = new Estudiante("Sofía", "López", 23, "Mujer", "34567890", "Mendoza", "Libreta 4567", true);
        Carrera c1 = new Carrera("Tudai", 2);
        Carrera c2 = new Carrera("Profesor de filosofia", 4);

        //estudianteRepo.save(e1);
        //carreraRepo.save(c1);
        //estudianteRepo.matricularEstudianteEnCarrera(1L,1L);

        //estudianteRepo.save(e2);
        //carreraRepo.save(c2);
        estudianteRepo.save(e3);
        estudianteRepo.save(e4);
        estudianteRepo.save(e5);


        //System.out.println(estudianteRepo.obtenerEstudiantesPorGenero("Mujer"));
        //System.out.println(estudianteRepo.obtenerEstudianteLibreta("254136"));
        estudianteRepo.matricularEstudianteEnCarrera(2L,3L);
        estudianteRepo.matricularEstudianteEnCarrera(6L,3L);
        estudianteRepo.matricularEstudianteEnCarrera(3L,1L);
        estudianteRepo.matricularEstudianteEnCarrera(4L,1L);
        estudianteRepo.matricularEstudianteEnCarrera(5L,3L);
        System.out.println(estudianteRepo.obtenerEstudiantesPorCarrera(3L));
        System.out.println(estudianteRepo.obtenerEstudiantesPorCarreraYCiudad(3L,"Tandil"));
        System.out.println(carreraRepo.obtenerCarrerasConEstudiantesInscriptos());



        List<ReporteDTO> reporte = carreraRepo.generarReporteCarreras();

        System.out.println("------------------EGRESADOS Y GRADUADOS POR AÑO------------------------");

        for (ReporteDTO dto : reporte) {
            System.out.println(dto.toString());
        }





    }
}
