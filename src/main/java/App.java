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
        Carrera c1 = new Carrera("Tudai", 2);
        Carrera c2 = new Carrera("Profesor de filosofia", 4);

        /**estudianteRepo.save(e1);
        carreraRepo.save(c1);
        estudianteRepo.matricularEstudianteEnCarrera(1L,1L);*/

        //estudianteRepo.save(e2);
        //carreraRepo.save(c2);

        System.out.println(estudianteRepo.obtenerEstudiantesPorGenero("Mujer"));
        System.out.println(estudianteRepo.obtenerEstudianteLibreta("254136"));
        //estudianteRepo.matricularEstudianteEnCarrera(2L,2L);
        //estudianteRepo.matricularEstudianteEnCarrera(6L,2L);
        System.out.println(estudianteRepo.obtenerEstudiantesPorCarrera(1L));
        System.out.println(estudianteRepo.obtenerEstudiantesPorCarreraYCiudad(2L,"Tandil"));
        System.out.println(carreraRepo.obtenerCarrerasConEstudiantesInscriptos());



        List<ReporteDTO> reporte = carreraRepo.generarReporteCarreras();

        System.out.println("------------------EGRESADOS Y GRADUADOS POR AÑO------------------------");

        for (ReporteDTO dto : reporte) {
            System.out.println(dto.toString());
        }





    }
}
