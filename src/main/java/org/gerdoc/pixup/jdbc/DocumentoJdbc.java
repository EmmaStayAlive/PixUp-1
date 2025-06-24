package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.agregar.Documento;

public interface DocumentoJdbc
{
    List<Documento> findAll( );
    boolean save( Documento documento );
    boolean update( Documento documento );
    boolean delete( Documento documento );
    Documento findById( int id );
}
