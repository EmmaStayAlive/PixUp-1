package org.gerdoc.pixup.gui;

import org.gerdoc.pixup.gui.consola.Consola;
import org.gerdoc.pixup.gui.ventana.Ventana;
import org.gerdoc.pixup.negocio.Ejecutable;

public class ConsolaVentana  extends LecturaAccion {
    public static ConsolaVentana consolaVentana;

    private ConsolaVentana() {
    }

    public static ConsolaVentana getInstance( ) {
        if(consolaVentana==null) {
            consolaVentana = new ConsolaVentana();
        }
        return consolaVentana;
    }

    @Override
    public void despliegaMenu() {
        System.out.println("Seleccione una opcion:");
        System.out.println("1.-Consola");
        System.out.println("2.-Ventana (No disponible)");
        System.out.println("3.-Salir");
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
        if(opcion==1) {
            ejecutable = Consola.getInstance( );
        }
        if(opcion==2) {
            ejecutable = Ventana.getInstance( );
        }
        ejecutable.setFlag( true );
        ejecutable.run( );
    }
}
