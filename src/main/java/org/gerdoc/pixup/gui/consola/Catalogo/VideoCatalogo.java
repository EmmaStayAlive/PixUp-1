package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.modelos.agregar.Genero;
import org.gerdoc.pixup.modelos.agregar.Video;
import org.gerdoc.pixup.modelos.agregar.Artista;
import org.gerdoc.pixup.util.ReadUtil;

public class VideoCatalogo extends Catalogos<Video> {
    public static VideoCatalogo videoCatalogo;

    private VideoCatalogo() {
        super();
    }

    public static VideoCatalogo getInstance() {
        if (videoCatalogo == null) {
            videoCatalogo = new VideoCatalogo();
        }
        return videoCatalogo;
    }

    @Override
    public Video newT() {
        return new Video();
    }

    @Override
    public boolean processNewT(Video video) {

        System.out.println("Ingresa el Nombre del Video");
        video.setNombre(ReadUtil.read());

        System.out.println("Ingresa la Descripcion del Video");
        video.setDescripcion(ReadUtil.read());

        System.out.println("Ingresa el Archivo del Video");
        video.setArchivo(ReadUtil.read());

        System.out.println("Ingresa la Duracion del Video (en segundos)");
        video.setDuracion(Integer.parseInt(ReadUtil.read()));

        System.out.println("Ingresa el Id del Artista del Video");
        int idArtista = Integer.parseInt(ReadUtil.read());
        Artista artista = HibernateUtil.getSession().find(Artista.class, idArtista);
        video.setArtista(artista);

        System.out.println("Ingresa el Id del Genero del Video");
        int idGenero = Integer.parseInt(ReadUtil.read());
        Genero genero = HibernateUtil.getSession().find(Genero.class, idGenero);
        video.setGenero(genero);

        return true;
    }

    @Override
    public void processEditT(Video video) {
        System.out.println("ID del Video: " + video.getId());
        System.out.println("Nombre del Video a editar: " + video.getNombre());

        System.out.println("Teclee el nuevo nombre del Video:");
        video.setNombre(ReadUtil.read());

        System.out.println("Teclee la nueva descripción del Video:");
        video.setDescripcion(ReadUtil.read());

        System.out.println("Teclee el nuevo archivo del Video:");
        video.setArchivo(ReadUtil.read());

        System.out.println("Teclee la nueva duración del Video (en minutos):");
        video.setDuracion(Integer.parseInt(ReadUtil.read()));

        System.out.println("Ingresa el Id del nuevo Artista del Video");
        int idArtista = Integer.parseInt(ReadUtil.read());
        Artista artista = HibernateUtil.getSession().find(Artista.class, idArtista);
        video.setArtista(artista);

        System.out.println("Ingresa el Id del nuevo Genero del Video");
        int idGenero = Integer.parseInt(ReadUtil.read());
        Genero genero = HibernateUtil.getSession().find(Genero.class, idGenero);
        video.setGenero(genero);
    }
}