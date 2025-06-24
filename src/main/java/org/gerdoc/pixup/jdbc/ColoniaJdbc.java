package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.registro.ubicacion.Colonia;

public interface ColoniaJdbc {
    List<Colonia> findAll( );
    boolean save( Colonia colonia );
    boolean update( Colonia colonia );
    boolean delete( Colonia colonia );
    Colonia findById( int id );
}
