package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.ArtistaJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.DiscoJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.GeneroJdbcImpl;
import org.gerdoc.pixup.modelos.agregar.Artista;
import org.gerdoc.pixup.modelos.agregar.Disco;
import org.gerdoc.pixup.modelos.agregar.Genero;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class DiscoCatalogo extends Catalogos<Disco> {
    private static DiscoCatalogo instancia;

    private DiscoCatalogo() {}

    public static DiscoCatalogo getInstance() {
        if (instancia == null) {
            instancia = new DiscoCatalogo();
        }
        return instancia;
    }

    @Override
    public Disco newT() {
        return new Disco();
    }

    @Override
    public boolean processNewT(Disco disco) {
        System.out.println("Nombre del disco:");
        disco.setNombre(ReadUtil.read());

        System.out.println("Descripción (opcional):");
        disco.setDescripcion(ReadUtil.read());

        System.out.println("Ruta de la portada (opcional):");
        disco.setPortada(ReadUtil.read());

        System.out.println("Fecha de lanzamiento (ej. 2025-06-24):");
        disco.setFecha(ReadUtil.read());

        System.out.println("Duración total del disco (ej. 42:15):");
        disco.setDuracion(ReadUtil.read());

        System.out.println("ID del artista:");
        Artista artista = ArtistaJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (artista == null) {
            System.out.println("Artista no encontrado.");
            return false;
        }
        disco.setArtista(artista);

        System.out.println("ID del género:");
        Genero genero = GeneroJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (genero == null) {
            System.out.println("Género no encontrado.");
            return false;
        }
        disco.setGenero(genero);

        return DiscoJdbcImpl.getInstance().save(disco);
    }

    @Override
    public void processEditT(Disco disco) {
        System.out.println("Editar disco ID: " + disco.getId());

        System.out.println("Nuevo nombre [" + disco.getNombre() + "]:");
        disco.setNombre(ReadUtil.read());

        System.out.println("Nueva descripción:");
        disco.setDescripcion(ReadUtil.read());

        System.out.println("Nueva ruta de portada:");
        disco.setPortada(ReadUtil.read());

        System.out.println("Nueva fecha:");
        disco.setFecha(ReadUtil.read());

        System.out.println("Nueva duración:");
        disco.setDuracion(ReadUtil.read());

        System.out.println("Nuevo ID de artista:");
        Artista artista = ArtistaJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (artista != null) {
            disco.setArtista(artista);
        }

        System.out.println("Nuevo ID de género:");
        Genero genero = GeneroJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (genero != null) {
            disco.setGenero(genero);
        }

        if (DiscoJdbcImpl.getInstance().update(disco)) {
            System.out.println("Disco actualizado.");
        } else {
            System.out.println("Error al actualizar.");
        }
    }

    @Override
    public void print() {
        List<Disco> discos = DiscoJdbcImpl.getInstance().findAll();
        if (discos.isEmpty()) {
            System.out.println("No hay discos registrados.");
        } else {
            discos.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        Disco disco = newT();
        if (processNewT(disco)) {
            System.out.println("Disco guardado exitosamente.");
        } else {
            System.out.println("No se guardó el disco.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID del disco a editar:");
        int id = ReadUtil.readInt();
        Disco disco = DiscoJdbcImpl.getInstance().findById(id);
        if (disco != null) {
            processEditT(disco);
        } else {
            System.out.println("Disco no encontrado.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID del disco a eliminar:");
        int id = ReadUtil.readInt();
        Disco disco = DiscoJdbcImpl.getInstance().findById(id);
        if (disco != null && DiscoJdbcImpl.getInstance().delete(disco)) {
            System.out.println("Disco eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }
}