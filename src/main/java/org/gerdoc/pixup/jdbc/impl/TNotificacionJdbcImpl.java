package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.TNotificacionJdbc;
import org.gerdoc.pixup.modelos.registro.notificacion.TNotificacion;
import org.hibernate.Session;

import java.util.List;

public class TNotificacionJdbcImpl implements TNotificacionJdbc {
    private static TNotificacionJdbcImpl tNotificacionJdbcImpl;

    private TNotificacionJdbcImpl() {
    }

    public static TNotificacionJdbcImpl getInstance() {
        if (tNotificacionJdbcImpl == null) {
            tNotificacionJdbcImpl = new TNotificacionJdbcImpl();
        }
        return tNotificacionJdbcImpl;
    }

    @Override
    public List<TNotificacion> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<TNotificacion> tNotificaciones = session.createQuery("from TNotificacion", TNotificacion.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return tNotificaciones;
    }

    @Override
    public boolean save(TNotificacion tNotificacion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(tNotificacion);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(TNotificacion tNotificacion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(tNotificacion);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(TNotificacion tNotificacion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(tNotificacion);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public TNotificacion findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        TNotificacion tNotificacion = session.find(TNotificacion.class, id);
        session.getTransaction().commit();
        session.close();
        return tNotificacion;
    }
}