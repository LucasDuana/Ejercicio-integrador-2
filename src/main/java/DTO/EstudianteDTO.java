package DTO;

import model.Estudiante;

public class EstudianteDTO {

    private String nombres;

    private String apellido;

    private Integer edad;

    private String genero;

    private String numeroDocumento;

    private String ciudadResidencia;

    private String numeroLibretaUniversitaria;

    private Boolean graduado;

    public EstudianteDTO(Estudiante estudiante) {
        this.nombres = estudiante.getNombres();
        this.apellido = estudiante.getApellido();
        this.edad = estudiante.getEdad();
        this.genero = estudiante.getGenero();
        this.numeroDocumento = estudiante.getNumeroDocumento();
        this.ciudadResidencia = estudiante.getCiudadResidencia();
        this.numeroLibretaUniversitaria = estudiante.getNumeroLibretaUniversitaria();
        this.graduado = estudiante.getGraduado();
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
