package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.DomicilioJdbc;
import org.gerdoc.pixup.modelos.registro.ubicacion.Domicilio;
import org.hibernate.Session;

import java.util.List;

public class DomicilioJdbcImpl implements DomicilioJdbc {
    private static DomicilioJdbcImpl domicilioJdbcImpl;

    private DomicilioJdbcImpl() {
    }

    public static DomicilioJdbcImpl getInstance() {
        if (domicilioJdbcImpl == null) {
            domicilioJdbcImpl = new DomicilioJdbcImpl();
        }
        return domicilioJdbcImpl;
    }

    @Override
    public List<Domicilio> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Domicilio> domicilios = session.createQuery("from Domicilio", Domicilio.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return domicilios;
    }

    @Override
    public boolean save(Domicilio domicilio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(domicilio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Domicilio domicilio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(domicilio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Domicilio domicilio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(domicilio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Domicilio findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Domicilio domicilio = session.find(Domicilio.class, id);
        session.getTransaction().commit();
        session.close();
        return domicilio;
    }
}