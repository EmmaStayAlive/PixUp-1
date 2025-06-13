package org.gerdoc.pixup.model;

public class Disco extends Catalogo {
    private String nombre;
    private Double precio;
    private Integer existencia;
    private Double descuento;
    private String fecha_lanzamiento;
    private String imagen;
    private Disquera disquera;
    private Artista artista;
    private Genero genero;

    public Disco()
    {
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Disquera getDisquera() {
        return disquera;
    }

    public void setDisquera(Disquera disquera) {
        this.disquera = disquera;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(String fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  "=====================================\n" +
                "         INFORMACIÓN DEL DISCO       \n" +
                "=====================================\n" +
                "Nombre:          " + nombre + "\n" +
                "         " + artista + "\n" +
                "          " + genero + "\n" +
                "       " + disquera + "\n" +
                "-------------------------------------\n" +
                "Precio:          $" + precio + "\n" +
                "Existencias:     " + existencia + "\n" +
                "Descuento:       " + descuento + "%\n" +
                "Fecha Lanzamiento: " + fecha_lanzamiento + "\n" +
                "-------------------------------------\n" +
                "Imagen:          " + imagen + "\n" +
                "=====================================";


    }
}
