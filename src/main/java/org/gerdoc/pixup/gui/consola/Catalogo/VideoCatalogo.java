package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.ArtistaJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.GeneroJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.VideoJdbcImpl;
import org.gerdoc.pixup.modelos.agregar.Artista;
import org.gerdoc.pixup.modelos.agregar.Genero;
import org.gerdoc.pixup.modelos.agregar.Video;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class VideoCatalogo extends Catalogos<Video> {
    private static VideoCatalogo instancia;

    private VideoCatalogo() {}

    public static VideoCatalogo getInstance() {
        if (instancia == null) {
            instancia = new VideoCatalogo();
        }
        return instancia;
    }

    @Override
    public Video newT() {
        return new Video();
    }

    @Override
    public boolean processNewT(Video video) {
        System.out.println("Nombre del video:");
        video.setNombre(ReadUtil.read());

        System.out.println("Descripción (opcional):");
        video.setDescripcion(ReadUtil.read());

        System.out.println("Ruta del archivo:");
        video.setArchivo(ReadUtil.read());

        System.out.println("Duración en segundos:");
        video.setDuracion(ReadUtil.readInt());

        System.out.println("ID del artista:");
        Artista artista = ArtistaJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (artista == null) {
            System.out.println("Artista no encontrado.");
            return false;
        }
        video.setArtista(artista);

        System.out.println("ID del género:");
        Genero genero = GeneroJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (genero == null) {
            System.out.println("Género no encontrado.");
            return false;
        }
        video.setGenero(genero);

        return VideoJdbcImpl.getInstance().save(video);
    }

    @Override
    public void processEditT(Video video) {
        System.out.println("Editar video ID: " + video.getId());

        System.out.println("Nuevo nombre [" + video.getNombre() + "]:");
        video.setNombre(ReadUtil.read());

        System.out.println("Nueva descripción:");
        video.setDescripcion(ReadUtil.read());

        System.out.println("Nueva ruta de archivo:");
        video.setArchivo(ReadUtil.read());

        System.out.println("Nueva duración:");
        video.setDuracion(ReadUtil.readInt());

        System.out.println("Nuevo ID de artista:");
        Artista artista = ArtistaJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (artista != null) {
            video.setArtista(artista);
        }

        System.out.println("Nuevo ID de género:");
        Genero genero = GeneroJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (genero != null) {
            video.setGenero(genero);
        }

        if (VideoJdbcImpl.getInstance().update(video)) {
            System.out.println("Video actualizado exitosamente.");
        } else {
            System.out.println("Error al actualizar.");
        }
    }

    @Override
    public void print() {
        List<Video> videos = VideoJdbcImpl.getInstance().findAll();
        if (videos.isEmpty()) {
            System.out.println("No hay videos registrados.");
        } else {
            videos.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        Video video = newT();
        if (processNewT(video)) {
            System.out.println("Video guardado correctamente.");
        } else {
            System.out.println("No se pudo guardar el video.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID del video a editar:");
        Video video = VideoJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (video != null) {
            processEditT(video);
        } else {
            System.out.println("Video no encontrado.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID del video a eliminar:");
        Video video = VideoJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (video != null && VideoJdbcImpl.getInstance().delete(video)) {
            System.out.println("Video eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }
}