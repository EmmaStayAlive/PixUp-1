package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.DiscoJdbc;
import org.gerdoc.pixup.modelos.agregar.Disco;
import org.hibernate.Session;

import java.util.List;

public class DiscoJdbcImpl implements DiscoJdbc {
    private static DiscoJdbcImpl discoJdbcImpl;

    private DiscoJdbcImpl() {
    }

    public static DiscoJdbcImpl getInstance() {
        if (discoJdbcImpl == null) {
            discoJdbcImpl = new DiscoJdbcImpl();
        }
        return discoJdbcImpl;
    }

    @Override
    public List<Disco> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Disco> discos = session.createQuery("from Disco", Disco.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return discos;
    }

    @Override
    public boolean save(Disco disco) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(disco);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Disco disco) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(disco);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Disco disco) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(disco);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Disco findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Disco disco = session.find(Disco.class, id);
        session.getTransaction().commit();
        session.close();
        return disco;
    }
}
