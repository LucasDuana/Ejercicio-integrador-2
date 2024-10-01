import DTO.ReporteDTO;
import helper.EntityManagerJPA;
import model.Carrera;
import model.Estudiante;
import repository.CarreraRepositoryImpl;
import repository.EstudianteRepositoryImpl;
import repository.RepositoryFactory;
import util.LoadCsv;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws Exception {
        EntityManager em = EntityManagerJPA.getEntityManager();

        RepositoryFactory rf = new RepositoryFactory();
        EstudianteRepositoryImpl estudianteRepo= rf.getEstudianteRepository(em);
        CarreraRepositoryImpl carreraRepo= rf.getCarreraRepository(em);
        LoadCsv cargador = new LoadCsv(rf);
        /*cargador.leerEstudiantes();
        cargador.leerCarreras();
        cargador.leerEstudiantesCarreras();*/

        /*
        * a) dar de alta un estudiante
b) matricular un estudiante en una carrera





        * */

        //d) recuperar un estudiante, en base a su número de libreta universitaria.
        //System.out.println(estudianteRepo.obtenerEstudianteLibreta("61607"));

        //e) recuperar todos los estudiantes, en base a su género.
        //System.out.println(estudianteRepo.obtenerEstudiantesPorGenero("Polygender"));

        //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
        //System.out.println(estudianteRepo.obtenerEstudiantesOrdenados("apellido"));

        //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        //System.out.println(carreraRepo.obtenerCarrerasConEstudiantesInscriptos());

        //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
        System.out.println(estudianteRepo.obtenerEstudiantesPorCarreraYCiudad(15L,"Jiaoyuan"));



    }
}
