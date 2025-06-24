package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.ArtistaJdbcImpl;
import org.gerdoc.pixup.modelos.agregar.Artista;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class ArtistaCatalogo extends Catalogos<Artista> {
    private static ArtistaCatalogo instancia;

    private ArtistaCatalogo() {
        super();
    }

    public static ArtistaCatalogo getInstance() {
        if (instancia == null) {
            instancia = new ArtistaCatalogo();
        }
        return instancia;
    }

    @Override
    public Artista newT() {
        return new Artista();
    }

    @Override
    public boolean processNewT(Artista artista) {
        System.out.println("Nombre del artista:");
        artista.setNombre(ReadUtil.read());

        System.out.println("Biografía (opcional):");
        artista.setBiografia(ReadUtil.read());

        System.out.println("Ruta del logo (opcional):");
        artista.setLogo(ReadUtil.read());

        return ArtistaJdbcImpl.getInstance().save(artista);
    }

    @Override
    public void processEditT(Artista artista) {
        System.out.println("ID: " + artista.getId());

        System.out.println("Nuevo nombre [" + artista.getNombre() + "]:");
        artista.setNombre(ReadUtil.read());

        System.out.println("Nueva biografía:");
        artista.setBiografia(ReadUtil.read());

        System.out.println("Nueva ruta del logo:");
        artista.setLogo(ReadUtil.read());

        if (ArtistaJdbcImpl.getInstance().update(artista)) {
            System.out.println("Artista actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
    }

    @Override
    public void print() {
        List<Artista> artistas = ArtistaJdbcImpl.getInstance().findAll();
        if (artistas.isEmpty()) {
            System.out.println("No hay artistas registrados.");
        } else {
            artistas.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        Artista artista = newT();
        if (processNewT(artista)) {
            System.out.println("Artista guardado exitosamente.");
        } else {
            System.out.println("No se guardó el artista.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID del artista a editar:");
        int id = ReadUtil.readInt();
        Artista artista = ArtistaJdbcImpl.getInstance().findById(id);
        if (artista != null) {
            processEditT(artista);
        } else {
            System.out.println("Artista no encontrado.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID del artista a eliminar:");
        int id = ReadUtil.readInt();
        Artista artista = ArtistaJdbcImpl.getInstance().findById(id);
        if (artista != null && ArtistaJdbcImpl.getInstance().delete(artista)) {
            System.out.println("Artista eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el artista.");
        }
    }
}