package DTO;

import model.Estudiante;

public class EstudianteDTO {

    private String nombre;

    private String apellido;

    private Integer edad;

    private String genero;

    private String ciudad;

    private String lu;


    public EstudianteDTO(Estudiante estudiante) {
        this.nombre = estudiante.getNombre();
        this.apellido = estudiante.getApellido();
        this.edad = estudiante.getEdad();
        this.genero = estudiante.getGenero();
        this.ciudad= estudiante.getCiudad();
        this.lu = estudiante.getLu();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombres(String nombres) {
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

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLu() {
        return lu;
    }

    public void setNumeroLibretaUniversitaria(String lu) {
        this.lu = lu;
    }

    @Override
    public String toString() {
        return "EstudianteDTO{" +
                "nombres='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", lu='" + lu+  +
                '}';
    }
}
