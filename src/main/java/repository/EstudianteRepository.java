package repository;

import DTO.EstudianteDTO;
import model.Carrera;
import model.Estudiante;

import java.util.List;

public interface EstudianteRepository extends Repository<Estudiante,Long> {
    void matricularEstudianteEnCarrera(Long id,Long dni, Long carreraId, Integer inscripcion, Integer graduacion, Integer antiguedad);
    List<EstudianteDTO> obtenerEstudiantesPorCarreraYCiudad(Long idCarrera, String ciudad);
    EstudianteDTO obtenerEstudianteLibreta(String libreta);
    List<EstudianteDTO> obtenerEstudiantesPorGenero(String genero);
    List<EstudianteDTO> obtenerEstudiantesOrdenados(String criterio);
    List<EstudianteDTO> obtenerEstudiantesPorCarrera(Long id);
}
