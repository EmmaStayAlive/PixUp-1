package org.gerdoc.pixup.model;

public class Disquera extends Catalogo {
    private String Nombre;

    public Disquera() {
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
                "   DISQUERA    \n" +
                "=====================\n" +
                "Nombre:  " + Nombre + "\n" +
                "ID:      " + id + "\n" +
                "=====================";


    }
}
