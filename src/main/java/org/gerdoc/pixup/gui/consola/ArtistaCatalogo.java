package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.jdbc.ArtistaJdbc;
import org.gerdoc.pixup.jdbc.impl.ArtistaJdbcImpl;
import org.gerdoc.pixup.model.Artista;
import org.gerdoc.pixup.util.ReadUtil;

public class ArtistaCatalogo extends Catalogos<Artista>
{
    public static ArtistaCatalogo artistaCatalogo;
    private static ArtistaJdbc artistaJdbc;
    public ArtistaCatalogo( ) {
        super();
    }

    public static ArtistaCatalogo getInstance( )
    {
        if(artistaCatalogo ==null)
        {
            artistaCatalogo = new ArtistaCatalogo();
        }
        return artistaCatalogo;
    }

    @Override
    public Artista newT()
    {
        return new Artista( );
    }

    @Override
    public boolean processNewT(Artista artista) {
        artista = newT();
        System.out.println("Ingrese el Nombre del Artista" );
        artista.setNombre( ReadUtil.read( ) );

        artistaJdbc = ArtistaJdbcImpl.getInstance();
        boolean exito = artistaJdbc.save(artista);
        if (exito) {
            System.out.println("Artista Guardado");
        } else {
            System.out.println("Artista No Guardado");
        }
        return artistaJdbc != null;
    }


    @Override
    public void processEditT(Artista artista)
    {
        System.out.println("Id del Artista " + artista.getId( ) );
        System.out.println("Artista a editar: " + artista.getNombre( ) );
        System.out.println("Teclee el valor nuevo del Artista" );
        artista.setNombre( ReadUtil.read( ) );
    }

    public boolean loadArtistaJdbc() {
        artistaJdbc = ArtistaJdbcImpl.getInstance();
        return artistaJdbc != null;
    }

    @Override
    public void print() {
        if(artistaJdbc == null) {
            if (!loadArtistaJdbc()) {
                System.out.println("No se pudo cargar el Artista");
                return;
            }
        }
        list = artistaJdbc.findAll();
        super.print();
    }
}
