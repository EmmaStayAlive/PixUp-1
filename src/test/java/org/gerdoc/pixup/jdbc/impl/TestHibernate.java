package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.modelos.registro.ubicacion.Estado;
import org.hibernate.Session;

public class TestHibernate {
    public static void main(String[] args) {
        Estado estado = new Estado();
        estado.setNombre("TEST");

        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.save(estado);
            session.getTransaction().commit();
            System.out.println("Estado guardado con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

