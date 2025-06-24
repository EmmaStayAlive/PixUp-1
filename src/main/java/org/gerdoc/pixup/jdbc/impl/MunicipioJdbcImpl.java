package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.MunicipioJdbc;
import org.gerdoc.pixup.modelos.registro.ubicacion.Municipio;
import org.hibernate.Session;

import java.util.List;

public class MunicipioJdbcImpl implements MunicipioJdbc {
    private static MunicipioJdbcImpl municipioJdbcImpl;

    private MunicipioJdbcImpl() {
    }

    public static MunicipioJdbcImpl getInstance() {
        if (municipioJdbcImpl == null) {
            municipioJdbcImpl = new MunicipioJdbcImpl();
        }
        return municipioJdbcImpl;
    }

    @Override
    public List<Municipio> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Municipio> municipios = session.createQuery("from Municipio", Municipio.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return municipios;
    }

    @Override
    public boolean save(Municipio municipio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(municipio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Municipio municipio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(municipio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Municipio municipio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(municipio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Municipio findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Municipio municipio = session.find(Municipio.class, id);
        session.getTransaction().commit();
        session.close();
        return municipio;
    }
}