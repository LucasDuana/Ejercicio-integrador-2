package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EstudianteCarrera", uniqueConstraints = @UniqueConstraint(columnNames = { "estudiante_id", "carrera_id" }))
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

    public EstudianteCarrera(Carrera carrera, Estudiante estudiante) {
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.id = new EstudianteCarreraId(estudiante.getId_estudiante(), carrera.getId_carrera());

    }

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
