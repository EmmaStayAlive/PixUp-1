package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.registro.ubicacion.Municipio;

public interface MunicipioJdbc {
    List<Municipio> findAll( );
    boolean save( Municipio municipio );
    boolean update( Municipio municipio );
    boolean delete( Municipio municipio );
    Municipio findById( int id );
}
