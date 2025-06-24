package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.registro.Usuario;

public interface UsuarioJdbc {
    List<Usuario> findAll( );
    boolean save( Usuario Usuario );
    boolean update( Usuario Usuario );
    boolean delete( Usuario Usuario );
    Usuario findById( int id );
}
