package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.NotificacionJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.TNotificacionJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.UsuarioJdbcImpl;
import org.gerdoc.pixup.modelos.registro.Usuario;
import org.gerdoc.pixup.modelos.registro.notificacion.Notificacion;
import org.gerdoc.pixup.modelos.registro.notificacion.TNotificacion;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class NotificacionCatalogo extends Catalogos<Notificacion> {
    private static NotificacionCatalogo instancia;

    private NotificacionCatalogo() {}

    public static NotificacionCatalogo getInstance() {
        if (instancia == null) {
            instancia = new NotificacionCatalogo();
        }
        return instancia;
    }

    @Override
    public Notificacion newT() {
        return new Notificacion();
    }

    @Override
    public boolean processNewT(Notificacion notificacion) {
        System.out.println("Título de la notificación:");
        notificacion.setTitulo(ReadUtil.read());

        System.out.println("Fecha (ej. 2025-06-24):");
        notificacion.setFecha(ReadUtil.read());

        System.out.println("ID del usuario que recibirá la notificación:");
        int idUsuario = ReadUtil.readInt();
        Usuario usuario = UsuarioJdbcImpl.getInstance().findById(idUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return false;
        }
        notificacion.setUsuario(usuario);

        System.out.println("ID del tipo de notificación:");
        int idTipo = ReadUtil.readInt();
        TNotificacion tipo = TNotificacionJdbcImpl.getInstance().findById(idTipo);
        if (tipo == null) {
            System.out.println("Tipo de notificación no encontrado.");
            return false;
        }
        notificacion.setTNotificacion(tipo);

        return NotificacionJdbcImpl.getInstance().save(notificacion);
    }

    @Override
    public void processEditT(Notificacion notificacion) {
        System.out.println("ID: " + notificacion.getId());
        System.out.println("Título actual: " + notificacion.getTitulo());
        System.out.println("Nuevo título:");
        notificacion.setTitulo(ReadUtil.read());

        System.out.println("Fecha actual: " + notificacion.getFecha());
        System.out.println("Nueva fecha:");
        notificacion.setFecha(ReadUtil.read());

        System.out.println("Nuevo ID de usuario:");
        Usuario usuario = UsuarioJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (usuario != null) {
            notificacion.setUsuario(usuario);
        }

        System.out.println("Nuevo ID del tipo de notificación:");
        TNotificacion tipo = TNotificacionJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (tipo != null) {
            notificacion.setTNotificacion(tipo);
        }

        if (NotificacionJdbcImpl.getInstance().update(notificacion)) {
            System.out.println("Notificación actualizada.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
    }

    @Override
    public void print() {
        List<Notificacion> lista = NotificacionJdbcImpl.getInstance().findAll();
        if (lista.isEmpty()) {
            System.out.println("No hay notificaciones registradas.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        Notificacion notificacion = newT();
        if (processNewT(notificacion)) {
            System.out.println("Notificación registrada correctamente.");
        } else {
            System.out.println("No se pudo registrar.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID de la notificación a editar:");
        Notificacion notificacion = NotificacionJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (notificacion != null) {
            processEditT(notificacion);
        } else {
            System.out.println("Notificación no encontrada.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID de la notificación a eliminar:");
        Notificacion notificacion = NotificacionJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (notificacion != null && NotificacionJdbcImpl.getInstance().delete(notificacion)) {
            System.out.println("Notificación eliminada.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }
}