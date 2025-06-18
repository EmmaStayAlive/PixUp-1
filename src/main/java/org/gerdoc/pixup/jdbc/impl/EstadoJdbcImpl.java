package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.EstadoJdbc;
import org.gerdoc.pixup.modelos.registro.ubiacion.Estado;
import org.hibernate.Session;

import java.util.List;

public class EstadoJdbcImpl implements EstadoJdbc
{
    private static EstadoJdbcImpl estadoJdbcImpl;

    private EstadoJdbcImpl()
    {
    }

    public static EstadoJdbcImpl getInstance( )
    {
        if( estadoJdbcImpl == null )
        {
            estadoJdbcImpl = new EstadoJdbcImpl();
        }
        return estadoJdbcImpl;
    }

    @Override
    public List<Estado> findAll()
    {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Estado> estados = session.createQuery( "from Estado", Estado.class ).getResultList( );
        session.getTransaction().commit();
        session.close();
        return estados;
    }

    @Override
    public boolean save(Estado estado)
    {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save( estado );
        session.getTransaction().commit();
        session.close( );
        return true;
    }

    @Override
    public boolean update(Estado estado)
    {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge( estado );
        session.getTransaction().commit();
        session.close( );
        return true;
    }

    @Override
    public boolean delete(Estado estado)
    {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove( estado );
        session.getTransaction().commit();
        session.close( );
        return true;
    }

    @Override
    public Estado findById(int id)
    {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Estado estado = session.get( Estado.class, id );
        session.getTransaction().commit();
        session.close( );
        return estado;
    }
}
