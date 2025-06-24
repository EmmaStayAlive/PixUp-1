package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.agregar.Artista;

public interface ArtistaJdbc
{
    List<Artista> findAll( );
    boolean save( Artista artista );
    boolean update( Artista artista );
    boolean delete( Artista artista );
    Artista findById( int id );
}
