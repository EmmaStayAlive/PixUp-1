package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.ArtistaJdbc;
import org.gerdoc.pixup.modelos.agregar.Artista;
import org.hibernate.Session;

import java.util.List;

public class ArtistaJdbcImpl implements ArtistaJdbc{
    private static ArtistaJdbcImpl artistaJdbcImpl;

    private ArtistaJdbcImpl() {
    }

    public static ArtistaJdbcImpl getInstance( ) {
        if( artistaJdbcImpl == null ){
            artistaJdbcImpl = new ArtistaJdbcImpl();
        }
        return artistaJdbcImpl;
    }

    @Override
    public List<Artista> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Artista> artista = session.createQuery( "from Artista", Artista.class ).getResultList( );
        session.getTransaction().commit();
        session.close();
        return artista;
    }

    @Override
    public boolean save(Artista artista) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save( artista );
        session.getTransaction().commit();
        session.close( );
        return true;
    }

    @Override
    public boolean update(Artista artista) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge( artista );
        session.getTransaction().commit();
        session.close( );
        return true;
    }

    @Override
    public boolean delete(Artista artista) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove( artista );
        session.getTransaction().commit();
        session.close( );
        return true;
    }

    @Override
    public Artista findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Artista artista = session.get( Artista.class, id );
        session.getTransaction().commit();
        session.close( );
        return artista;
    }
}
