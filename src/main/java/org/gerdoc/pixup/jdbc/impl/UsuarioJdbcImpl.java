package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.UsuarioJdbc;
import org.gerdoc.pixup.modelos.registro.Usuario;
import org.hibernate.Session;

import java.util.List;

public class UsuarioJdbcImpl implements UsuarioJdbc {
    private static UsuarioJdbcImpl usuarioJdbcImpl;

    private UsuarioJdbcImpl() {
    }

    public static UsuarioJdbcImpl getInstance() {
        if (usuarioJdbcImpl == null) {
            usuarioJdbcImpl = new UsuarioJdbcImpl();
        }
        return usuarioJdbcImpl;
    }

    @Override
    public List<Usuario> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Usuario> usuarios = session.createQuery("from Usuario", Usuario.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return usuarios;
    }

    @Override
    public boolean save(Usuario usuario) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Usuario usuario) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(usuario);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Usuario usuario) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(usuario);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Usuario findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Usuario usuario = session.find(Usuario.class, id);
        session.getTransaction().commit();
        session.close();
        return usuario;
    }
}