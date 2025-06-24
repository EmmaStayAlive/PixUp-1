package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.registro.ubicacion.Domicilio;

public interface DomicilioJdbc {
    List<Domicilio> findAll( );
    boolean save( Domicilio domicilio );
    boolean update( Domicilio domicilio );
    boolean delete( Domicilio domicilio );
    Domicilio findById( int id );
}
