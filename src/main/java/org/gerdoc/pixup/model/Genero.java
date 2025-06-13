package org.gerdoc.pixup.model;

public class Genero extends Catalogo{
    private String Descripcion;

    public Genero() {
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "=====================\n" +
                "   Genero   \n" +
                "=====================\n" +
                "Nombre:  " + Descripcion + "\n" +
                "ID:      " + id + "\n" +
                "=====================";


    }
}
