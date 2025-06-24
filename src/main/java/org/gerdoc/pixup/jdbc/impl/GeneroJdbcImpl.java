package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.GeneroJdbc;
import org.gerdoc.pixup.modelos.agregar.Genero;
import org.hibernate.Session;

import java.util.List;

public class GeneroJdbcImpl implements GeneroJdbc {
    private static GeneroJdbcImpl generoJdbcImpl;

    private GeneroJdbcImpl() {
    }

    public static GeneroJdbcImpl getInstance() {
        if (generoJdbcImpl == null) {
            generoJdbcImpl = new GeneroJdbcImpl();
        }
        return generoJdbcImpl;
    }

    @Override
    public List<Genero> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Genero> generos = session.createQuery("from Genero", Genero.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return generos;
    }

    @Override
    public boolean save(Genero genero) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(genero);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Genero genero) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(genero);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Genero genero) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(genero);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Genero findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Genero genero = session.find(Genero.class, id);
        session.getTransaction().commit();
        session.close();
        return genero;
    }
}