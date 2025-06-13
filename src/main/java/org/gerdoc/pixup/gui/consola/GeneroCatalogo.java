package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.jdbc.GeneroJdbc;
import org.gerdoc.pixup.jdbc.impl.GeneroJdbcImpl;
import org.gerdoc.pixup.model.Artista;
import org.gerdoc.pixup.model.Genero;
import org.gerdoc.pixup.util.ReadUtil;

public class GeneroCatalogo extends Catalogos<Genero>
{
    public static GeneroCatalogo generoCatalogo;
    private static GeneroJdbc GeneroJdbc;
    public GeneroCatalogo( ) {
        super();
    }

    public static GeneroCatalogo getInstance( )
    {
        if(generoCatalogo ==null)
        {
            generoCatalogo = new GeneroCatalogo();
        }
        return generoCatalogo;
    }

    @Override
    public Genero newT()
    {
        return new Genero( );
    }

    @Override
    public boolean processNewT(Genero genero) {
        genero = newT();
        System.out.println("Ingrese el Nombre del Genero" );
        genero.setDescripcion( ReadUtil.read( ) );

        GeneroJdbc = GeneroJdbcImpl.getInstance();
        boolean exito = GeneroJdbc.save(genero);
        if (exito) {
            System.out.println("Genero Guardado");
        } else {
            System.out.println("Genero No Guardado");
        }
        return GeneroJdbc != null;
    }


    @Override
    public void processEditT(Genero genero)
    {
        System.out.println("Id del Genero " + genero.getId( ) );
        System.out.println("Genero a editar: " + genero.getDescripcion( ) );
        System.out.println("Teclee el valor nuevo del Genero" );
        genero.setDescripcion( ReadUtil.read( ) );
    }

    public boolean loadGeneroJdbc() {
        GeneroJdbc = GeneroJdbcImpl.getInstance();
        return GeneroJdbc != null;
    }

    @Override
    public void print() {
        if(GeneroJdbc == null) {
            if (!loadGeneroJdbc()) {
                System.out.println("No se pudo cargar el Genero");
                return;
            }
        }
        list = GeneroJdbc.findAll();
        super.print();
    }
}
