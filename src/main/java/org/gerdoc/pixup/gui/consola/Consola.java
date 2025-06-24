package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.gui.LecturaAccion;
import org.gerdoc.pixup.gui.consola.Catalogo.UsuarioCatalogo;
import org.gerdoc.pixup.negocio.Ejecutable;

public class Consola extends LecturaAccion {
    private static Consola consola;

    private Consola() {
    }

    public static Consola getInstance( ) {
        if(consola==null) {
            consola = new Consola();
        }
        return consola;
    }

    @Override
    public void despliegaMenu() {
        System.out.println("Seleccione una opcion:");
        System.out.println("1.-Ubicaciones");
        System.out.println("2.-Agregar");
        System.out.println("3.-Usuario");
        System.out.println("4.-Notificaciones");
        System.out.println("5.-Salir");
    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 5;
    }

    @Override
    public void procesaOpcion() {

        Ejecutable ejecutable = null;
        if(opcion==1) {
            ejecutable = Ubicacion.getInstance( );
        } else if(opcion==2) {
            ejecutable = Agregar.getInstance( );
        } else if(opcion==3) {
            ejecutable = UsuarioCatalogo.getInstance( );
        } else if(opcion==4) {
            ejecutable = Notificaciones.getInstance( );
        }
        ejecutable.setFlag( true );
        ejecutable.run( );
    }
}
