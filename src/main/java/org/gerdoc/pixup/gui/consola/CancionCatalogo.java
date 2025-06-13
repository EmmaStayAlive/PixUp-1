package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.jdbc.CancionJdbc;
import org.gerdoc.pixup.jdbc.impl.CancionJdbcImpl;
import org.gerdoc.pixup.model.Artista;
import org.gerdoc.pixup.model.Cancion;
import org.gerdoc.pixup.util.ReadUtil;

public class CancionCatalogo extends Catalogos<Cancion>
{
    public static CancionCatalogo cancionCatalogo;
    private static CancionJdbc CancionJdbc;
    public CancionCatalogo( ) {
        super();
    }

    public static CancionCatalogo getInstance( )
    {
        if(cancionCatalogo ==null)
        {
            cancionCatalogo = new CancionCatalogo();
        }
        return cancionCatalogo;
    }

    @Override
    public Cancion newT()
    {
        return new Cancion( );
    }

    @Override
    public boolean processNewT(Cancion cancion) {
        cancion = newT();
        System.out.println("Ingrese el Nombre del Cancion" );
        cancion.setTitulo( ReadUtil.read( ) );

        CancionJdbc = CancionJdbcImpl.getInstance();
        boolean exito = CancionJdbc.save(cancion);
        if (exito) {
            System.out.println("Cancion Guardado");
        } else {
            System.out.println("Cancion No Guardado");
        }
        return CancionJdbc != null;
    }


    @Override
    public void processEditT(Cancion cancion)
    {
        System.out.println("Id del Cancion " + cancion.getId( ) );
        System.out.println("Cancion a editar: " + cancion.getTitulo( ) );
        System.out.println("Teclee el valor nuevo del Cancion" );
        cancion.setTitulo( ReadUtil.read( ) );
    }

    public boolean loadCancionJdbc() {
        CancionJdbc = CancionJdbcImpl.getInstance();
        return CancionJdbc != null;
    }

    @Override
    public void print() {
        if(CancionJdbc == null) {
            if (!loadCancionJdbc()) {
                System.out.println("No se pudo cargar el Cancion");
                return;
            }
        }
        list = CancionJdbc.findAll();
        super.print();
    }
}
