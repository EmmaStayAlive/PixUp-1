package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.agregar.Cancion;

public interface CancionJdbc
{
    List<Cancion> findAll( );
    boolean save( Cancion cancion );
    boolean update( Cancion cancion );
    boolean delete( Cancion cancion );
    Cancion findById( int id );
}
