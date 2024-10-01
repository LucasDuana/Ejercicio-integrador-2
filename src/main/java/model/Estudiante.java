package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estudiante {

    @Id
    private Long dni;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Integer edad;
    @Column
    private String genero;
    @Column
    private String ciudad;
    @Column
    private String lu;

    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteCarrera> carreras;

    public Estudiante() {

    }

    public Estudiante(Long dni, String nombre, String apellido, Integer edad, String genero, String ciudad, String lu) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.lu = lu;
        this.carreras = new ArrayList<>();
    }

    public Long getId_estudiante() {
        return dni;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombres) {
        this.nombre = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }




    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudadResidencia) {
        this.ciudad = ciudadResidencia;
    }

    public String getLu() {
        return lu;
    }

    public void setLu(String numeroLibretaUniversitaria) {
        this.lu = numeroLibretaUniversitaria;
    }

    public void addCareraa(EstudianteCarrera c){
        this.carreras.add(c);
    }

    public List<EstudianteCarrera> getCarreras(){
        return new ArrayList<>(carreras);
    }


}
