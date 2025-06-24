package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.CancionJdbc;
import org.gerdoc.pixup.modelos.agregar.Cancion;
import org.hibernate.Session;

import java.util.List;

public class CancionJdbcImpl implements CancionJdbc{
    private static CancionJdbcImpl cancionJdbcImpl;

    private CancionJdbcImpl() {
    }

    public static CancionJdbcImpl getInstance( ) {
        if( cancionJdbcImpl == null ){
            cancionJdbcImpl = new CancionJdbcImpl();
        }
        return cancionJdbcImpl;
    }

    @Override
    public List<Cancion> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Cancion> cancion = session.createQuery( "from Cancion", Cancion.class ).getResultList( );
        session.getTransaction().commit();
        session.close();
        return cancion;
    }

    @Override
    public boolean save(Cancion cancion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save( cancion );
        session.getTransaction().commit();
        session.close( );
        return true;
    }

    @Override
    public boolean update(Cancion cancion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge( cancion );
        session.getTransaction().commit();
        session.close( );
        return true;
    }

    @Override
    public boolean delete(Cancion cancion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove( cancion );
        session.getTransaction().commit();
        session.close( );
        return true;
    }

    @Override
    public Cancion findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Cancion cancion = session.get( Cancion.class, id );
        session.getTransaction().commit();
        session.close( );
        return cancion;
    }
}
