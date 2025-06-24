package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.agregar.Disco;

public interface DiscoJdbc
{
    List<Disco> findAll( );
    boolean save( Disco disco );
    boolean update( Disco disco );
    boolean delete( Disco disco );
    Disco findById( int id );
}
