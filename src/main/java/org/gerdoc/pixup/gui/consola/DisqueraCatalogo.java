package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.jdbc.DisqueraJdbc;
import org.gerdoc.pixup.jdbc.impl.DisqueraJdbcImpl;
import org.gerdoc.pixup.model.Disquera;
import org.gerdoc.pixup.util.ReadUtil;

public class DisqueraCatalogo extends Catalogos<Disquera>
{
    public static DisqueraCatalogo disqueraCatalogo;
    private static DisqueraJdbc DisqueraJdbc;
    public DisqueraCatalogo( ) {
        super();
    }

    public static DisqueraCatalogo getInstance( )
    {
        if(disqueraCatalogo ==null)
        {
            disqueraCatalogo = new DisqueraCatalogo();
        }
        return disqueraCatalogo;
    }

    @Override
    public Disquera newT()
    {
        return new Disquera( );
    }

    @Override
    public boolean processNewT(Disquera disquera) {
        disquera = newT();
        System.out.println("Ingrese el Nombre del Disquera" );
        disquera.setNombre( ReadUtil.read( ) );

        DisqueraJdbc = DisqueraJdbcImpl.getInstance();
        boolean exito = DisqueraJdbc.save(disquera);
        if (exito) {
            System.out.println("Disquera Guardado");
        } else {
            System.out.println("Disquera No Guardado");
        }
        return DisqueraJdbc != null;
    }


    @Override
    public void processEditT(Disquera disquera)
    {
        System.out.println("Id del Disquera " + disquera.getId( ) );
        System.out.println("Disquera a editar: " + disquera.getNombre( ) );
        System.out.println("Teclee el valor nuevo del Disquera" );
        disquera.setNombre( ReadUtil.read( ) );
    }

    public boolean loadDisqueraJdbc() {
        DisqueraJdbc = DisqueraJdbcImpl.getInstance();
        return DisqueraJdbc != null;
    }

    @Override
    public void print() {
        if(DisqueraJdbc == null) {
            if (!loadDisqueraJdbc()) {
                System.out.println("No se pudo cargar el Disquera");
                return;
            }
        }
        list = DisqueraJdbc.findAll();
        super.print();
    }
}
