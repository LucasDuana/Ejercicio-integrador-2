package DTO;

import model.Carrera;

public class CarreraDTO {

    private String carrera;

    private Integer duracion;

    private int cantidadInscriptos;

    public CarreraDTO(Carrera carrera) {
        this.carrera = carrera.getCarrera();
        this.duracion = carrera.getDuracion();
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String nombre) {
        this.carrera = carrera;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "CarreraDTO{" +
                "nombre='" + carrera + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
