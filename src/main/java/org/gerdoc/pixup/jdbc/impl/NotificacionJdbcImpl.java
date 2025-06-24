package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.NotificacionJdbc;
import org.gerdoc.pixup.modelos.registro.notificacion.Notificacion;
import org.hibernate.Session;

import java.util.List;

public class NotificacionJdbcImpl implements NotificacionJdbc {
    private static NotificacionJdbcImpl notificacionJdbcImpl;

    private NotificacionJdbcImpl() {
    }

    public static NotificacionJdbcImpl getInstance() {
        if (notificacionJdbcImpl == null) {
            notificacionJdbcImpl = new NotificacionJdbcImpl();
        }
        return notificacionJdbcImpl;
    }

    @Override
    public List<Notificacion> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Notificacion> notificaciones = session.createQuery("from Notificacion", Notificacion.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return notificaciones;
    }

    @Override
    public boolean save(Notificacion notificacion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(notificacion);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Notificacion notificacion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(notificacion);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Notificacion notificacion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(notificacion);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Notificacion findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Notificacion notificacion = session.find(Notificacion.class, id);
        session.getTransaction().commit();
        session.close();
        return notificacion;
    }
}