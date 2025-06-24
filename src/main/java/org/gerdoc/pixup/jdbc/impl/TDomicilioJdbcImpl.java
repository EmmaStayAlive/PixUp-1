package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.TDomicilioJdbc;
import org.gerdoc.pixup.modelos.registro.ubicacion.TDomicilio;
import org.hibernate.Session;

import java.util.List;

public class TDomicilioJdbcImpl implements TDomicilioJdbc {
    private static TDomicilioJdbcImpl tDomicilioJdbcImpl;

    private TDomicilioJdbcImpl() {
    }

    public static TDomicilioJdbcImpl getInstance() {
        if (tDomicilioJdbcImpl == null) {
            tDomicilioJdbcImpl = new TDomicilioJdbcImpl();
        }
        return tDomicilioJdbcImpl;
    }

    @Override
    public List<TDomicilio> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<TDomicilio> tDomicilios = session.createQuery("from TDomicilio", TDomicilio.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return tDomicilios;
    }

    @Override
    public boolean save(TDomicilio tDomicilio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(tDomicilio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(TDomicilio tDomicilio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(tDomicilio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(TDomicilio tDomicilio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(tDomicilio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public TDomicilio findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        TDomicilio tDomicilio = session.find(TDomicilio.class, id);
        session.getTransaction().commit();
        session.close();
        return tDomicilio;
    }
}