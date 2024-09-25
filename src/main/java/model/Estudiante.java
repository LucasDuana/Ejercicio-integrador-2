package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estudiante_id;
    @Column
    private String nombres;
    @Column
    private String apellido;
    @Column
    private Integer edad;
    @Column
    private String genero;
    @Column
    private String numeroDocumento;
    @Column
    private String ciudadResidencia;
    @Column
    private String numeroLibretaUniversitaria;
    @Column
    private Boolean graduado;

    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteCarrera> carreras;

    public Estudiante() {

    }

    public Estudiante(String nombres, String apellido, Integer edad, String genero, String numeroDocumento, String ciudadResidencia, String numeroLibretaUniversitaria, Boolean graduado) {
        this.nombres = nombres;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.numeroDocumento = numeroDocumento;
        this.ciudadResidencia = ciudadResidencia;
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
        this.graduado = graduado;
        this.carreras = new ArrayList<EstudianteCarrera>();
    }

    public Long getId_estudiante() {
        return estudiante_id;
    }


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getNumeroLibretaUniversitaria() {
        return numeroLibretaUniversitaria;
    }

    public void setNumeroLibretaUniversitaria(String numeroLibretaUniversitaria) {
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
    }

    public Boolean getGraduado() {
        return graduado;
    }

    public void setGraduado(Boolean graduado) {
        this.graduado = graduado;
    }

    public void addCareraa(EstudianteCarrera c){
        this.carreras.add(c);
    }

    public List<EstudianteCarrera> getCarreras(){
        return new ArrayList<>(carreras);
    }


}
