package model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EstudianteCarreraId implements Serializable {

    private Long estudianteId;
    private Long carreraId;

    public EstudianteCarreraId() {
    }

    public EstudianteCarreraId(Long estudianteId, Long carreraId) {
        this.estudianteId = estudianteId;
        this.carreraId = carreraId;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public Long getCarreraId() {
        return carreraId;
    }



}
