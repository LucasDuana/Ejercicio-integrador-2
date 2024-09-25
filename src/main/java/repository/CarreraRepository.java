package repository;

import DTO.CarreraDTO;
import model.Carrera;

import java.util.List;

public interface CarreraRepository {
    List<CarreraDTO> obtenerCarrerasConEstudiantesInscriptos();
}
