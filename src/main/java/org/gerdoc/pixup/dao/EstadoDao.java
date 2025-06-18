package org.gerdoc.pixup.dao;

import java.util.List;

import org.gerdoc.pixup.modelos.registro.ubiacion.Estado;

public interface EstadoDao
{
    List<Estado> findAll( );
    boolean save( Estado estado );
    boolean update( Estado estado );
    boolean delete( Estado estado );
    Estado findById( int id );
}
