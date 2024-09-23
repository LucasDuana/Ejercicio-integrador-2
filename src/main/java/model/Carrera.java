package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrera;
    @Column
    private String nombre;
    @Column
    private Integer duracion;

    @OneToMany(mappedBy = "carrera")
    private List<EstudianteCarrera> estudiantes;

    public Carrera(Long id_carrera, String nombre, Integer duracion) {
        this.id_carrera = id_carrera;
        this.nombre = nombre;
        this.duracion = duracion;
        this.estudiantes = new ArrayList<>();
    }

    public Carrera() {

    }

    public Long getId_carrera() {
        return id_carrera;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public List<EstudianteCarrera> getEstudiantes() {
        return new ArrayList<>(estudiantes);
    }

    public void addEstudiante(EstudianteCarrera e){
        this.estudiantes.add(e);
    }
}
