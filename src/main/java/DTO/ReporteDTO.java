package DTO;

public class ReporteDTO {

    private String nombreCarrera;
    private int anio;
    private long graduados;
    private long inscriptos;

    public ReporteDTO(String nombreCarrera, int anio, long graduados, long inscriptos) {
        this.nombreCarrera = nombreCarrera;
        this.anio = anio;
        this.graduados = graduados;
        this.inscriptos = inscriptos;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public int getAnio() {
        return anio;
    }

    public long getGraduados() {
        return graduados;
    }

    public long getInscriptos() {
        return inscriptos;
    }

    @Override
    public String toString() {
        return "Reporte de carrera {" +
                "nombreCarrera: '" + nombreCarrera + '\'' +
                ", año: " + anio +
                ", graduados: " + graduados +
                ", inscriptos: " + inscriptos +
                '}';
    }
}