package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.gui.LecturaAccion;
import org.gerdoc.pixup.negocio.Ejecutable;

public class Consola extends LecturaAccion
{
    private static Consola consola;

    private Consola()
    {
    }

    public static Consola getInstance( )
    {
        if(consola==null)
        {
            consola = new Consola();
        }
        return consola;
    }

    @Override
    public void despliegaMenu()
    {
        System.out.println("Seleccione una opcion:");
        System.out.println("1.-Discos");
        System.out.println("2.-Salir");
    }

    @Override
    public int valorMinMenu()
    {
        return 1;
    }

    @Override
    public int valorMaxMenu()
    {
        return 2;
    }

    @Override
    public void procesaOpcion()
    {
        Ejecutable ejecutable = null;
        System.out.println("Opcion: " + opcion);
        if(opcion==1)
        {
            ejecutable = ListaCatalogos.getInstance( );
        }
        ejecutable.setFlag( true );
        ejecutable.run( );
    }

}
