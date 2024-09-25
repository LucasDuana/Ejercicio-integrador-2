package repository;

import DTO.EstudianteDTO;
import model.Carrera;
import model.Estudiante;

import java.util.List;

public interface EstudianteRepository extends Repository<Estudiante,Long> {
    void matricularEstudianteEnCarrera(Long estudianteId, Long carreraId);
    //List<Estudiante> obtenerEstudiantes();
    //void darDeAltaEstudiante(Estudiante estudiante);
    List<EstudianteDTO> obtenerEstudiantesPorCarreraYCiudad(Long idCarrera, String ciudad);
    EstudianteDTO obtenerEstudianteLibreta(String libreta);
    List<EstudianteDTO> obtenerEstudiantesPorGenero(String genero);
    List<EstudianteDTO> obtenerEstudiantesOrdenados(String criterio);
    List<EstudianteDTO> obtenerEstudiantesPorCarrera(Long id);
}
