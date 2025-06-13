package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.model.Disco;
import org.gerdoc.pixup.util.ReadUtil;

public class DiscoCatalogo extends Catalogos<Disco>
{
    public static DiscoCatalogo discoCatalogo;
    private DiscoCatalogo( )
    {
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
    public boolean processNewT(Disco disco)
    {
        System.out.println("Teclee un estado" );
        disco.setNombre( ReadUtil.read( ) );
        return true;
    }

    @Override
    public void processEditT(Disco disco)
    {
        System.out.println("Id del Estado " + disco.getId( ) );
        System.out.println("Estado a editar: " + disco.getNombre( ) );
        System.out.println("Teclee el valor nuevo del estado" );
        disco.setNombre( ReadUtil.read( ) );
    }

}
