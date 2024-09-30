package DTO;

import model.Estudiante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReporteDTO {

    private String nombreCarrera;
    private int antiguedad;
    private List<String> estudiante;
    private HashMap<Integer,>

    public ReporteDTO(String nombreCarrera, int antiguedad) {
        this.nombreCarrera = nombreCarrera;
        this.antiguedad = antiguedad;
        this.estudiante = new ArrayList<>();
    }

    public void addEstudiante(String nombre, String apellido){
        this.estudiante.add("Nombre: " + nombre + " Apellido: "+ apellido);
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public List<String> getEstudiantes() {
        return new ArrayList<>(this.estudiante);
    }


    @Override
    public String toString() {
        return "Reporte de carrera {" +
                "nombreCarrera: '" + nombreCarrera + '\'' + "Cantidad de ingresantes"+"}";
    }
}
