package org.gerdoc.pixup.jdbc;

import org.gerdoc.pixup.model.Artista;
import java.util.List;

public interface ArtistaJdbc
{
    List<Artista> findAll( );
    boolean save( Artista artista );
}
