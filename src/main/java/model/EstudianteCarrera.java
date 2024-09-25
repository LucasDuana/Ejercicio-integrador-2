package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EstudianteCarrera", uniqueConstraints = @UniqueConstraint(columnNames = { "id_estudiante", "id_carrera" }))
public class EstudianteCarrera {

    @EmbeddedId
    private EstudianteCarreraId id;

    @ManyToOne
    @MapsId("estudianteId")
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("carreraId")
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    private Integer antiguedad;
    private Boolean graduadoEnCarrera;

    public EstudianteCarrera() {

    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
