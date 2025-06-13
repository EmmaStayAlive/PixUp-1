package org.gerdoc.pixup.model;

import java.sql.Time;

public class Cancion extends Catalogo {
    private String Titulo;
    private Time Duracion;
    private Disco disco;

    public Cancion() {
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public Time getDuracion() {
        return Duracion;
    }

    public void setDuracion(Time duracion) {
        Duracion = duracion;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    @Override
    public String toString() {
        return "=============================\n" +
                "       INFORMACIÓN DE LA CANCIÓN      \n" +
                "=============================\n" +
                "Título:        " + Titulo + "\n" +
                "Duración:      " + Duracion + " min\n" +
                "Disco:         " + disco + "\n" +
                "ID:            " + id + "\n" +
                "=============================";


    }
}
