package EstudainetRepository;

import model.Carrera;
import model.Estudiante;

import java.util.List;

public interface EstudianteRepository {
    List<Estudiante> obtenerEstudiantes();
    Estudiante obtenerEstudianteLibreta(String libreta);
    List<Estudiante> obtenerEstudiantesPorGenero(String genero);
    List<Estudiante> obtenerEstudiantesPorCarrera(Carrera carrera);
}
