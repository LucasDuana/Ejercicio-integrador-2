package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EstudianteCarrera", uniqueConstraints = @UniqueConstraint(columnNames = { "id_estudiante", "id_carrera" }))
public class EstudianteCarrera {
    public EstudianteCarrera() {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    private Integer antiguedad;
    private Boolean graduadoEnCarrera;

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
