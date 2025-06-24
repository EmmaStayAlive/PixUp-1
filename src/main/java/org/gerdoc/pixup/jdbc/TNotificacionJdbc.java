package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.registro.notificacion.TNotificacion;

public interface TNotificacionJdbc {
    List<TNotificacion> findAll( );
    boolean save( TNotificacion tNotificacion );
    boolean update( TNotificacion tNotificacion );
    boolean delete( TNotificacion tNotificacion );
    TNotificacion findById( int id );
}
