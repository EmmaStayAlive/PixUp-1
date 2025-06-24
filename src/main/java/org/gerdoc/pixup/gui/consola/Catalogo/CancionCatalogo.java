package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.CancionJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.DiscoJdbcImpl;
import org.gerdoc.pixup.modelos.agregar.Cancion;
import org.gerdoc.pixup.modelos.agregar.Disco;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class CancionCatalogo extends Catalogos<Cancion> {
    private static CancionCatalogo instancia;

    private CancionCatalogo() {}

    public static CancionCatalogo getInstance() {
        if (instancia == null) {
            instancia = new CancionCatalogo();
        }
        return instancia;
    }

    @Override
    public Cancion newT() {
        return new Cancion();
    }

    @Override
    public boolean processNewT(Cancion cancion) {
        System.out.println("Título de la canción:");
        cancion.setTitulo(ReadUtil.read());

        System.out.println("Duración (ej. 03:25):");
        cancion.setDuracion(ReadUtil.read());

        System.out.println("ID del disco:");
        Disco disco = DiscoJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (disco == null) {
            System.out.println("Disco no encontrado.");
            return false;
        }
        cancion.setDisco(disco);

        return CancionJdbcImpl.getInstance().save(cancion);
    }

    @Override
    public void processEditT(Cancion cancion) {
        System.out.println("Editar canción ID: " + cancion.getId());

        System.out.println("Nuevo título [" + cancion.getTitulo() + "]:");
        cancion.setTitulo(ReadUtil.read());

        System.out.println("Nueva duración [" + cancion.getDuracion() + "]:");
        cancion.setDuracion(ReadUtil.read());

        System.out.println("Nuevo ID de disco:");
        Disco disco = DiscoJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (disco != null) {
            cancion.setDisco(disco);
        }

        if (CancionJdbcImpl.getInstance().update(cancion)) {
            System.out.println("Canción actualizada correctamente.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
    }

    @Override
    public void print() {
        List<Cancion> canciones = CancionJdbcImpl.getInstance().findAll();
        if (canciones.isEmpty()) {
            System.out.println("No hay canciones registradas.");
        } else {
            canciones.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        Cancion cancion = newT();
        if (processNewT(cancion)) {
            System.out.println("Canción registrada exitosamente.");
        } else {
            System.out.println("No se registró la canción.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID de la canción a editar:");
        int id = ReadUtil.readInt();
        Cancion cancion = CancionJdbcImpl.getInstance().findById(id);
        if (cancion != null) {
            processEditT(cancion);
        } else {
            System.out.println("Canción no encontrada.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID de la canción a eliminar:");
        int id = ReadUtil.readInt();
        Cancion cancion = CancionJdbcImpl.getInstance().findById(id);
        if (cancion != null && CancionJdbcImpl.getInstance().delete(cancion)) {
            System.out.println("Canción eliminada correctamente.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }
}