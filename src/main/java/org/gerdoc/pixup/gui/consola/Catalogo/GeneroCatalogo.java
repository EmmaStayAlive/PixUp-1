package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.GeneroJdbcImpl;
import org.gerdoc.pixup.modelos.agregar.Genero;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class GeneroCatalogo extends Catalogos<Genero> {
    private static GeneroCatalogo instancia;

    private GeneroCatalogo() {}

    public static GeneroCatalogo getInstance() {
        if (instancia == null) {
            instancia = new GeneroCatalogo();
        }
        return instancia;
    }

    @Override
    public Genero newT() {
        return new Genero();
    }

    @Override
    public boolean processNewT(Genero genero) {
        System.out.println("Descripción del género:");
        String descripcion = ReadUtil.read();
        if (descripcion == null || descripcion.trim().isEmpty()) {
            System.out.println("Descripción no válida.");
            return false;
        }
        genero.setDescripcion(descripcion.trim());
        return GeneroJdbcImpl.getInstance().save(genero);
    }

    @Override
    public void processEditT(Genero genero) {
        System.out.println("ID: " + genero.getId());
        System.out.println("Descripción actual: " + genero.getDescripcion());
        System.out.println("Nueva descripción:");
        String nueva = ReadUtil.read();
        if (nueva != null && !nueva.trim().isEmpty()) {
            genero.setDescripcion(nueva.trim());
        }

        if (GeneroJdbcImpl.getInstance().update(genero)) {
            System.out.println("Género actualizado correctamente.");
        } else {
            System.out.println("Error al actualizar el género.");
        }
    }

    @Override
    public void print() {
        List<Genero> generos = GeneroJdbcImpl.getInstance().findAll();
        if (generos.isEmpty()) {
            System.out.println("No hay géneros registrados.");
        } else {
            generos.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        Genero genero = newT();
        if (processNewT(genero)) {
            System.out.println("Género registrado exitosamente.");
        } else {
            System.out.println("No se guardó el género.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID del género a editar:");
        int id = ReadUtil.readInt();
        Genero genero = GeneroJdbcImpl.getInstance().findById(id);
        if (genero != null) {
            processEditT(genero);
        } else {
            System.out.println("Género no encontrado.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID del género a eliminar:");
        int id = ReadUtil.readInt();
        Genero genero = GeneroJdbcImpl.getInstance().findById(id);
        if (genero != null && GeneroJdbcImpl.getInstance().delete(genero)) {
            System.out.println("Género eliminado.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }
}