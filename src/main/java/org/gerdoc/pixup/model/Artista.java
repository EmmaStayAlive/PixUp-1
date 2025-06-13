package org.gerdoc.pixup.model;

public class Artista extends Catalogo{
    private String Nombre;

    public Artista() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return "=====================\n" +
                "   ARTISTA   \n" +
                "=====================\n" +
                "Nombre:  " + Nombre + "\n" +
                "ID:      " + id + "\n" +
                "=====================";


    }
}
