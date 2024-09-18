package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EstudianteCarrera", uniqueConstraints = @UniqueConstraint(columnNames = { "id", "id" }))
public class EstudianteCarrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id")
    private Carrera carrera;

    private Integer antiguedad;
    private Boolean graduadoEnCarrera;
}
