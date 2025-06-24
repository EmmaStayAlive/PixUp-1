package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.ColoniaJdbc;
import org.gerdoc.pixup.modelos.registro.ubicacion.Colonia;
import org.hibernate.Session;

import java.util.List;

public class ColoniaJdbcImpl implements ColoniaJdbc {
    private static ColoniaJdbcImpl coloniaJdbcImpl;

    private ColoniaJdbcImpl() {
    }

    public static ColoniaJdbcImpl getInstance() {
        if (coloniaJdbcImpl == null) {
            coloniaJdbcImpl = new ColoniaJdbcImpl();
        }
        return coloniaJdbcImpl;
    }

    @Override
    public List<Colonia> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Colonia> colonias = session.createQuery("from Colonia", Colonia.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return colonias;
    }

    @Override
    public boolean save(Colonia colonia) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(colonia);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Colonia colonia) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(colonia);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Colonia colonia) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(colonia);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Colonia findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Colonia colonia = session.find(Colonia.class, id);
        session.getTransaction().commit();
        session.close();
        return colonia;
    }
}
