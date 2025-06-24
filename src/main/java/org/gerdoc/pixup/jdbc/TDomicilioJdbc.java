package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.registro.ubicacion.TDomicilio;

public interface TDomicilioJdbc {
    List<TDomicilio> findAll( );
    boolean save( TDomicilio tDomicilio );
    boolean update( TDomicilio tDomicilio );
    boolean delete( TDomicilio tDomicilio );
    TDomicilio findById( int id );
}
