package EstudainetRepository;

import model.Carrera;
import model.Estudiante;

import java.util.List;

public interface EstudianteRepository {
    void matricularEstudianteEnCarrera(Estudiante estudiante, Carrera carrera);
    List<Estudiante> obtenerEstudiantes();
    void darDeAltaEstudiante(Estudiante estudiante);
    List<Carrera> obtenerCarrerasConEstudiantesInscriptos();
    List<Estudiante> obtenerEstudiantesPorCarreraYCiudad(Carrera carrera, String ciudad);
    Estudiante obtenerEstudianteLibreta(String libreta);
    List<Estudiante> obtenerEstudiantesPorGenero(String genero);
    List<Estudiante> obtenerEstudiantesOrdenados(String criterio);
    List<Estudiante> obtenerEstudiantesPorCarrera(Carrera carrera);
}
