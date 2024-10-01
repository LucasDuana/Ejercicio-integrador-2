package util;

import helper.EntityManagerJPA;
import model.Carrera;
import model.Estudiante;
import model.EstudianteCarrera;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import repository.*;

import java.io.FileReader;

public class LoadCsv {


    private RepositoryFactory factoria;
    private String fileEstudiantes = "src/main/java/util/CSVs/estudiantes.csv";
    private String fileCarreras = "src/main/java/util/CSVs/carreras.csv";
    private String fileEstudiantesCarreras = "src/main/java/util/CSVs/estudianteCarrera.csv";

    public LoadCsv(RepositoryFactory repositorioFactory){
       this.factoria=repositorioFactory;
    }

    public void leerEstudiantes() throws Exception{
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileEstudiantes));
        EstudianteRepositoryImpl estudianteRepo= factoria.getEstudianteRepository(EntityManagerJPA.getEntityManager());

        for(CSVRecord row: parser){
            Estudiante estudiante= new Estudiante(Long.parseLong(row.get("DNI")),row.get("nombre"),row.get("apellido"),Integer.parseInt(row.get("edad")),row.get("genero"),row.get("ciudad"),row.get("LU"));
            estudianteRepo.save(estudiante);
        }

    }

    public void leerCarreras()throws Exception{
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileCarreras));
        CarreraRepositoryImpl carreraRepo = factoria.getCarreraRepository(EntityManagerJPA.getEntityManager());

        for(CSVRecord row: parser){
            Carrera carrera = new Carrera(row.get("carrera"),Integer.parseInt(row.get("duracion")));
            carreraRepo.save(carrera);
        }
    }

    public void leerEstudiantesCarreras() throws Exception{
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileEstudiantesCarreras));
        EstudianteRepositoryImpl estudianteRepo = factoria.getEstudianteRepository(EntityManagerJPA.getEntityManager());
        for(CSVRecord row: parser){
            estudianteRepo.matricularEstudianteEnCarrera(Long.parseLong(row.get("id")),Long.parseLong(row.get("id_estudiante")),Long.parseLong(row.get("id_carrera")),Integer.parseInt(row.get("inscripcion")),Integer.parseInt(row.get("graduacion")),Integer.parseInt(row.get("antiguedad")));
        }
    }



}
