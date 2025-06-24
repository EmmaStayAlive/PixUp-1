package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.jdbc.VideoJdbc;
import org.gerdoc.pixup.modelos.agregar.Video;
import org.hibernate.Session;

import java.util.List;

public class VideoJdbcImpl implements VideoJdbc {
    private static VideoJdbcImpl videoJdbcImpl;

    private VideoJdbcImpl() {
    }

    public static VideoJdbcImpl getInstance() {
        if (videoJdbcImpl == null) {
            videoJdbcImpl = new VideoJdbcImpl();
        }
        return videoJdbcImpl;
    }

    @Override
    public List<Video> findAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Video> videos = session.createQuery("from Video", Video.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return videos;
    }

    @Override
    public boolean save(Video video) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(video);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Video video) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(video);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Video video) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(video);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Video findById(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Video video = session.find(Video.class, id);
        session.getTransaction().commit();
        session.close();
        return video;
    }
}