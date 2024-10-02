package DTO;

import model.Carrera;

public class CarreraDTOCant extends CarreraDTO {

    int cantInscriptos;
    public CarreraDTOCant(Carrera carrera, int cantInscriptos) {
        super(carrera);
        this.cantInscriptos = cantInscriptos;
    }

    @Override
    public String toString() {
        return "Carrera{" + super.toString()+ " " +
                "cantInscriptos=" + cantInscriptos +
                '}';
    }
}
