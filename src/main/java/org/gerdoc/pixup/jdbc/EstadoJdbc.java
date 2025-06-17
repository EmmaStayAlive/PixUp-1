package org.gerdoc.pixup.jdbc;

import org.gerdoc.pixup.model.Estado;
import org.gerdoc.pixup.model.Municipio;

import java.util.List;

public interface EstadoJdbc
{
    List<Estado> findAll( );
    boolean save( Estado estado );
    boolean update( Estado estado );
    boolean delete( Estado estado );
    Estado findById( int id );
}
