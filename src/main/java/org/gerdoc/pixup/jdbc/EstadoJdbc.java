package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.registro.ubiacion.Estado;
import org.gerdoc.pixup.modelos.registro.ubiacion.Municipio;

public interface EstadoJdbc
{
    List<Estado> findAll( );
    boolean save( Estado estado );
    boolean update( Estado estado );
    boolean delete( Estado estado );
    Estado findById( int id );
}
