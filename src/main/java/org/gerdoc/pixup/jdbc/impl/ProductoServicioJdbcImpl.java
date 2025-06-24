package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.ProductoServicioJdbc;
import org.gerdoc.pixup.modelos.agregar.ProductoServicio;
import org.hibernate.Session;

import java.util.List;

public class ProductoServicioJdbcImpl implements ProductoServicioJdbc {
    private static ProductoServicioJdbcImpl productoServicioJdbcImpl;

    private ProductoServicioJdbcImpl() {
    }

    public static ProductoServicioJdbcImpl getInstance() {
        if (productoServicioJdbcImpl == null) {
            productoServicioJdbcImpl = new ProductoServicioJdbcImpl();
        }
        return productoServicioJdbcImpl;
    }

    @Override
    public List<ProductoServicio> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<ProductoServicio> productosServicios = session.createQuery("from ProductoServicio", ProductoServicio.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return productosServicios;
    }

    @Override
    public boolean save(ProductoServicio productoServicio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(productoServicio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(ProductoServicio productoServicio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(productoServicio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(ProductoServicio productoServicio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(productoServicio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public ProductoServicio findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        ProductoServicio productoServicio = session.find(ProductoServicio.class, id);
        session.getTransaction().commit();
        session.close();
        return productoServicio;
    }
}