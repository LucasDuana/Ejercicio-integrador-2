package CarreraRepository;

import model.Carrera;

import java.util.List;

public interface CarreraRepository {
    List<Carrera> obtenerCarrerasConEstudiantesInscriptos();
}
