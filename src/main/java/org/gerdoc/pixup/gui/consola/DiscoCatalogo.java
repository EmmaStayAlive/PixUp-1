package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.jdbc.DiscoJdbc;
import org.gerdoc.pixup.jdbc.impl.DiscoJdbcImpl;
import org.gerdoc.pixup.model.Disco;
import org.gerdoc.pixup.util.ReadUtil;

public class DiscoCatalogo extends Catalogos<Disco>
{
    public static DiscoCatalogo discoCatalogo;
    private static DiscoJdbc DiscoJdbc;
    public DiscoCatalogo( ) {
        super();
    }

    public static DiscoCatalogo getInstance( )
    {
        if(discoCatalogo ==null)
        {
            discoCatalogo = new DiscoCatalogo();
        }
        return discoCatalogo;
    }

    @Override
    public Disco newT()
    {
        return new Disco( );
    }

    @Override
    public boolean processNewT(Disco disco) {
        disco = newT();
        System.out.println("Ingrese el Nombre del Disco" );
        disco.setNombre( ReadUtil.read( ) );

        DiscoJdbc = DiscoJdbcImpl.getInstance();
        boolean exito = DiscoJdbc.save(disco);
        if (exito) {
            System.out.println("Disco Guardado");
        } else {
            System.out.println("Disco No Guardado");
        }
        return DiscoJdbc != null;
    }


    @Override
    public void processEditT(Disco disco)
    {
        System.out.println("Id del Disco " + disco.getId( ) );
        System.out.println("Disco a editar: " + disco.getNombre( ) );
        System.out.println("Teclee el valor nuevo del Disco" );
        disco.setNombre( ReadUtil.read( ) );
    }

    public boolean loadDiscoJdbc() {
        DiscoJdbc = DiscoJdbcImpl.getInstance();
        return DiscoJdbc != null;
    }

    @Override
    public void print() {
        if(DiscoJdbc == null) {
            if (!loadDiscoJdbc()) {
                System.out.println("No se pudo cargar el Disco");
                return;
            }
        }
        list = DiscoJdbc.findAll();
        super.print();
    }
}
