package DTO;

import java.util.ArrayList;
import java.util.List;

public class ReporteDTO {

    private String nombreCarrera;
    private int antiguedad;
    private long graduados;
    private long noGraduados;

    public ReporteDTO(String nombreCarrera, int antiguedad, long graduados, long noGraduados) {
        this.nombreCarrera = nombreCarrera;
        this.antiguedad = antiguedad;
        this.graduados = graduados;
        this.noGraduados = noGraduados;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public long getGraduados() {
        return graduados;
    }

    public long getNoGraduados() {
        return noGraduados;
    }

    @Override
    public String toString() {
        return "Reporte de carrera {" +
                "nombreCarrera: '" + nombreCarrera + '\'' +
                ", antiguedad: " + antiguedad +
                ", graduados: " + graduados +
                ", noGraduados: " + noGraduados +
                '}';
    }
}
