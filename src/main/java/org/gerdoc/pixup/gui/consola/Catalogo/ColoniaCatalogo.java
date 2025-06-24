package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.ColoniaJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.MunicipioJdbcImpl;
import org.gerdoc.pixup.modelos.registro.ubicacion.Municipio;
import org.gerdoc.pixup.modelos.registro.ubicacion.Colonia;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class ColoniaCatalogo extends Catalogos<Colonia> {
    private static ColoniaCatalogo coloniaCatalogo;

    private ColoniaCatalogo() {
        super();
    }

    public static ColoniaCatalogo getInstance() {
        if (coloniaCatalogo == null) {
            coloniaCatalogo = new ColoniaCatalogo();
        }
        return coloniaCatalogo;
    }

    @Override
    public Colonia newT() {
        return new Colonia();
    }

    @Override
    public boolean processNewT(Colonia colonia) {
        System.out.println("Nombre de la Colonia:");
        String nombre = ReadUtil.read();
        if (nombre == null || nombre.trim().isEmpty()) return false;
        colonia.setNombre(nombre.trim());

        System.out.println("Ingresa el Código Postal:");
        String codigo = ReadUtil.read();
        if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("Código postal inválido.");
            return false;
        }
        colonia.setCodigoPostal(codigo.trim());

        System.out.println("ID del Municipio:");
        int idMunicipio = ReadUtil.readInt();
        Municipio municipio = MunicipioJdbcImpl.getInstance().findById(idMunicipio);
        if (municipio == null) {
            System.out.println("Municipio no encontrado.");
            return false;
        }
        colonia.setMunicipio(municipio);
        return ColoniaJdbcImpl.getInstance().save(colonia);
    }

    @Override
    public void processEditT(Colonia colonia) {
        System.out.println("Colonia actual: " + colonia.getNombre());
        System.out.println("Nuevo nombre:");
        String nuevoNombre = ReadUtil.read();
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            colonia.setNombre(nuevoNombre.trim());
        }

        System.out.println("Nuevo ID de Municipio:");
        int idMunicipio = ReadUtil.readInt();
        Municipio municipio = MunicipioJdbcImpl.getInstance().findById(idMunicipio);
        if (municipio != null) {
            colonia.setMunicipio(municipio);
        }

        ColoniaJdbcImpl.getInstance().update(colonia);
        System.out.println("Colonia actualizada.");
    }

    @Override
    public void print() {
        List<Colonia> colonias = ColoniaJdbcImpl.getInstance().findAll();
        if (colonias.isEmpty()) {
            System.out.println("No hay colonias registradas.");
        } else {
            colonias.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        Colonia colonia = newT();
        if (processNewT(colonia)) {
            System.out.println("Colonia guardada correctamente.");
        } else {
            System.out.println("No se guardó la colonia.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID de la Colonia a editar:");
        int id = ReadUtil.readInt();
        Colonia colonia = ColoniaJdbcImpl.getInstance().findById(id);
        if (colonia != null) {
            processEditT(colonia);
        } else {
            System.out.println("Colonia no encontrada.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID de la Colonia a eliminar:");
        int id = ReadUtil.readInt();
        Colonia colonia = ColoniaJdbcImpl.getInstance().findById(id);
        if (colonia != null && ColoniaJdbcImpl.getInstance().delete(colonia)) {
            System.out.println("Colonia eliminada.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }
}