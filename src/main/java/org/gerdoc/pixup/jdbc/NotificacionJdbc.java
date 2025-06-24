package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.registro.notificacion.Notificacion;

public interface NotificacionJdbc {
    List<Notificacion> findAll( );
    boolean save( Notificacion notificacion );
    boolean update( Notificacion notificacion );
    boolean delete( Notificacion notificacion );
    Notificacion findById( int id );
}
