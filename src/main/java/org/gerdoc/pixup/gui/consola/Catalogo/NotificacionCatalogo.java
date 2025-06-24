package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.modelos.registro.notificacion.Notificacion;
import org.gerdoc.pixup.modelos.registro.notificacion.TNotificacion;
import org.gerdoc.pixup.modelos.registro.Usuario;
import org.gerdoc.pixup.util.ReadUtil;

public class NotificacionCatalogo extends Catalogos<Notificacion> {
    public static NotificacionCatalogo notificacionCatalogo;

    private NotificacionCatalogo() {
        super();
    }

    public static NotificacionCatalogo getInstance() {
        if (notificacionCatalogo == null) {
            notificacionCatalogo = new NotificacionCatalogo();
        }
        return notificacionCatalogo;
    }

    @Override
    public Notificacion newT() {
        return new Notificacion();
    }

    @Override
    public boolean processNewT(Notificacion notificacion) {

        System.out.println("Ingresa el Titulo de la Notificación");
        notificacion.setTitulo(ReadUtil.read());

        System.out.println("Ingresa la Fecha de la Notificación");
        notificacion.setFecha(ReadUtil.read());

        System.out.println("Ingresa el Id del Usuario de la Notificación");
        int idUsuario = Integer.parseInt(ReadUtil.read());
        Usuario usuario = HibernateUtil.getSession().find(Usuario.class, idUsuario);
        notificacion.setUsuario(usuario);

        System.out.println("Ingresa el Id del Tipo de Notificación");
        int idTNotificacion = Integer.parseInt(ReadUtil.read());
        TNotificacion tNotificacion = HibernateUtil.getSession().find(TNotificacion.class, idTNotificacion);
        notificacion.setTNotificacion(tNotificacion);

        return true;
    }

    @Override
    public void processEditT(Notificacion t) {
        System.out.println("Id de la Notificación: " + t.getId());
        System.out.println("Título de la Notificación: " + t.getTitulo());

        System.out.println("Teclee el nuevo título de la Notificación:");
        t.setTitulo(ReadUtil.read());

        System.out.println("Teclee la nueva fecha de la Notificación:");
        t.setFecha(ReadUtil.read());

        System.out.println("Ingresa el Id del Usuario de la Notificación");
        int idUsuario = Integer.parseInt(ReadUtil.read());
        Usuario usuario = HibernateUtil.getSession().find(Usuario.class, idUsuario);
        t.setUsuario(usuario);

        System.out.println("Ingresa el Id del Tipo de Notificación");
        int idTNotificacion = Integer.parseInt(ReadUtil.read());
        TNotificacion tNotificacion = HibernateUtil.getSession().find(TNotificacion.class, idTNotificacion);
        t.setTNotificacion(tNotificacion);
    }
}