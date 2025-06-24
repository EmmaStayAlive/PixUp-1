package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.agregar.Genero;

public interface GeneroJdbc
{
    List<Genero> findAll( );
    boolean save( Genero genero );
    boolean update( Genero genero );
    boolean delete( Genero genero );
    Genero findById( int id );
}
