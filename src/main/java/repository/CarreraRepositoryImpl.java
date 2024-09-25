package repository;

import DTO.CarreraDTO;
import model.Carrera;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CarreraRepositoryImpl extends RepositoryImpl<Carrera,Long> implements CarreraRepository {

    public CarreraRepositoryImpl(EntityManager em) {
        super(Carrera.class,em);

    }

    private List<CarreraDTO> toCarrerasDTO(List<Carrera> carreras){
        ArrayList<CarreraDTO> conversion = new ArrayList<>();
        for(Carrera c: carreras){
            CarreraDTO carreraDTO = new CarreraDTO(c);
            conversion.add(carreraDTO);
        }

        return conversion;
    }


    @Override
    public List<CarreraDTO> obtenerCarrerasConEstudiantesInscriptos() {
        TypedQuery<Carrera> query = em.createQuery(
                "SELECT c FROM Carrera c JOIN EstudianteCarrera ec ON c.id = ec.carrera.id GROUP BY c ORDER BY COUNT(ec) DESC",
                Carrera.class
        );
        return this.toCarrerasDTO(query.getResultList());
    }

}
