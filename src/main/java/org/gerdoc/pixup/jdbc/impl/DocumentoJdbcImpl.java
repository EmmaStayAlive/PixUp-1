package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.DocumentoJdbc;
import org.gerdoc.pixup.modelos.agregar.Documento;
import org.hibernate.Session;

import java.util.List;

public class DocumentoJdbcImpl implements DocumentoJdbc {
    private static DocumentoJdbcImpl documentoJdbcImpl;

    private DocumentoJdbcImpl() {
    }

    public static DocumentoJdbcImpl getInstance() {
        if (documentoJdbcImpl == null) {
            documentoJdbcImpl = new DocumentoJdbcImpl();
        }
        return documentoJdbcImpl;
    }

    @Override
    public List<Documento> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Documento> documentos = session.createQuery("from Documento", Documento.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return documentos;
    }

    @Override
    public boolean save(Documento documento) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(documento);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Documento documento) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(documento);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Documento documento) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(documento);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Documento findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Documento documento = session.find(Documento.class, id);
        session.getTransaction().commit();
        session.close();
        return documento;
    }
}