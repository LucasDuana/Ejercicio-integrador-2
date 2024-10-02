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

        //EJECUTAR SOLO UNA VEZ
        /*cargador.leerEstudiantes();
        cargador.leerCarreras();
        cargador.leerEstudiantesCarreras();**/


        //2)


         //a) dar de alta un estudiante
        //estudianteRepo.save(new Estudiante()); //por defecto se crea uno vacio


        //b) matricular un estudiante en una carrera

        //estudianteRepo.matricularEstudianteEnCarrera ----> METODO
        // se debe ingresar como parametro dni de estudiante, id carrera, año de inscripcion, año de graduacion, antiguedad
        // Y OBVIAMENTE ADENTRO DE PARENTESIS POR QUE ES UN METODO



        //d) RECUPERAR UN ESTUDIANTE, EN BASE A SU NUMERO DE LIBRETA UNIVERSITARIA.
        //System.out.println(estudianteRepo.obtenerEstudianteLibreta("61607"));

        //e) RECUPERAR TODOS LOS ESTUDIANTES EN BASE A SU GENERO
        //System.out.println(estudianteRepo.obtenerEstudiantesPorGenero("Polygender"));

        //c) RECUPERAR TODOS LOS ESTUDIANTES , Y ESPECIFICAR ALGUN CRITERIO DE ORDENAMIENTO SIMPLE.
        //System.out.println(estudianteRepo.obtenerEstudiantesOrdenados("apellido"));

        //f) RECUPERAR LA CARRERAS CON ESTUDIANTES INSCRIPTOS, Y ORDERNAR POR CANTIDAD.
        //System.out.println(carreraRepo.obtenerCarrerasConEstudiantesInscriptos());

        //g) RECUPERAR A TODOS LOS ESTUDIANTES DE UNA DETERMINADA CARRERA, FILTRADOS POR CIUDAD DE RESIDENCIA.
        //System.out.println(estudianteRepo.obtenerEstudiantesPorCarreraYCiudad(15L,"Jiaoyuan"));

        //3) reporte inscriptos y graduados de las carreras ordenados cronologicamente por año

        /*for(ReporteDTO r: carreraRepo.generarReporteCarreras()) {
            System.out.println(r);
        }**/
    }
}
