package org.gerdoc.pixup.gui.ventana;

import org.gerdoc.pixup.negocio.Ejecutable;

public class Ventana implements Ejecutable
{
    public static Ventana ventana;

    private Ventana() {
    }

    public static Ventana getInstance( ) {
        if(ventana==null) {
            ventana = new Ventana();
        }
        return ventana;
    }

    @Override
    public void run() {
    }

    @Override
    public void setFlag(boolean flag) {
    }
}
