package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.gui.LecturaAccion;
import org.gerdoc.pixup.gui.consola.Catalogo.ArtistaCatalogo;
import org.gerdoc.pixup.gui.consola.Catalogo.CancionCatalogo;
import org.gerdoc.pixup.gui.consola.Catalogo.DiscoCatalogo;
import org.gerdoc.pixup.gui.consola.Catalogo.DocumentoCatalogo;
import org.gerdoc.pixup.gui.consola.Catalogo.GeneroCatalogo;
import org.gerdoc.pixup.gui.consola.Catalogo.ProductoServicioCatalogo;
import org.gerdoc.pixup.gui.consola.Catalogo.VideoCatalogo;
import org.gerdoc.pixup.negocio.Ejecutable;

public class Agregar extends LecturaAccion {
    public static Agregar listaCatalogos;

    private Agregar() {
    }

    public static Agregar getInstance( ) {
        if(listaCatalogos==null) {
            listaCatalogos = new Agregar();
        }
        return listaCatalogos;
    }

    @Override
    public void despliegaMenu() {
        System.out.println( "Seleccione una opcion:" );
        System.out.println( "1.-Artista");
        System.out.println( "2.-Genero");
        System.out.println( "3.-Documento");
        System.out.println( "4.-Producto/Servicio");
        System.out.println( "5.-Video");
        System.out.println( "6.-Disco");
        System.out.println( "7.-Canción");
        System.out.println( "8.-Salir");
    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 8;
    }

    @Override
    public void procesaOpcion() {
        Ejecutable ejecutable = null;
        switch (opcion) {
            case 1:
                ejecutable = ArtistaCatalogo.getInstance( );
                break;
            case 2:
                ejecutable = GeneroCatalogo.getInstance( );
                break;
            case 3:
                ejecutable = DocumentoCatalogo.getInstance( );
                break;
            case 4:
                ejecutable = ProductoServicioCatalogo.getInstance( );
                break;
            case 5:
                ejecutable = VideoCatalogo.getInstance( );
                break;
            case 6:
                ejecutable = DiscoCatalogo.getInstance( );
                break;
            case 7:
                ejecutable = CancionCatalogo.getInstance( );
                break;
        }
        ejecutable.setFlag( true );
        ejecutable.run( );
    }
}
