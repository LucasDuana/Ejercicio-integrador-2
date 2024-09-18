package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String apellido;
    private Integer edad;
    private String genero;
    private String numeroDocumento;
    private String ciudadResidencia;
    private String numeroLibretaUniversitaria;
    private Boolean graduado;

    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteCarrera> carreras;

    public Estudiante() {

    }

    public Estudiante(Long id, String nombres, String apellido, Integer edad, String genero, String numeroDocumento, String ciudadResidencia, String numeroLibretaUniversitaria, Boolean graduado, List<EstudianteCarrera> carreras) {
        this.id = id;
        this.nombres = nombres;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.numeroDocumento = numeroDocumento;
        this.ciudadResidencia = ciudadResidencia;
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
        this.graduado = graduado;
        this.carreras = carreras;
    }

    public Long getId() {
        return id;
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
}
