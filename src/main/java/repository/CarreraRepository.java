package repository;


import DTO.CarreraDTOCant;


import java.util.List;

public interface CarreraRepository {
    List<CarreraDTOCant> obtenerCarrerasConEstudiantesInscriptos();

}
