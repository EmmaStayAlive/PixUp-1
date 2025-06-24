package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.gui.LecturaAccion;
import org.gerdoc.pixup.gui.consola.Catalogo.NotificacionCatalogo;
import org.gerdoc.pixup.gui.consola.Catalogo.TNotificacionCatalogo;
import org.gerdoc.pixup.negocio.Ejecutable;

public class Notificaciones extends LecturaAccion {
    public static Notificaciones listaCatalogos;

    private Notificaciones() {
    }

    public static Notificaciones getInstance( ) {
        if(listaCatalogos==null) {
            listaCatalogos = new Notificaciones();
        }
        return listaCatalogos;
    }

    @Override
    public void despliegaMenu() {
        System.out.println( "Seleccione una opcion:" );
        System.out.println( "1.-Tipo de Notificación");
        System.out.println( "2.-Notificación");
        System.out.println( "3.-Salir");
    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 3;
    }

    @Override
    public void procesaOpcion() {
        Ejecutable ejecutable = null;
        switch (opcion) {
            case 1:
                ejecutable = TNotificacionCatalogo.getInstance( );
                break;
            case 2:
                ejecutable = NotificacionCatalogo.getInstance( );
                break;
        }
        ejecutable.setFlag( true );
        ejecutable.run( );
    }
}
