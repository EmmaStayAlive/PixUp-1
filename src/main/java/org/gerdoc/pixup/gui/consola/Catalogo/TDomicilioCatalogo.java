package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.TDomicilioJdbcImpl;
import org.gerdoc.pixup.modelos.registro.ubicacion.TDomicilio;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class TDomicilioCatalogo extends Catalogos<TDomicilio> {
    private static TDomicilioCatalogo instancia;

    private TDomicilioCatalogo() {}

    public static TDomicilioCatalogo getInstance() {
        if (instancia == null) {
            instancia = new TDomicilioCatalogo();
        }
        return instancia;
    }

    @Override
    public TDomicilio newT() {
        return new TDomicilio();
    }

    @Override
    public boolean processNewT(TDomicilio td) {
        System.out.println("Descripción (opcional):");
        String descripcion = ReadUtil.read();
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            td.setDescripcion(descripcion.trim());
        }

        System.out.println("Ruta del domicilio (obligatorio):");
        String ruta = ReadUtil.read();
        if (ruta == null || ruta.trim().isEmpty()) {
            System.out.println("La ruta no puede estar vacía.");
            return false;
        }

        td.setRuta(ruta.trim());
        return TDomicilioJdbcImpl.getInstance().save(td);
    }

    @Override
    public void processEditT(TDomicilio td) {
        System.out.println("ID: " + td.getId());
        System.out.println("Ruta actual: " + td.getRuta());

        System.out.println("Nueva ruta:");
        String nuevaRuta = ReadUtil.read();
        if (nuevaRuta != null && !nuevaRuta.trim().isEmpty()) {
            td.setRuta(nuevaRuta.trim());
        }

        System.out.println("Descripción actual: " + td.getDescripcion());
        System.out.println("Nueva descripción (puedes dejarla vacía):");
        String nuevaDescripcion = ReadUtil.read();
        td.setDescripcion(nuevaDescripcion != null ? nuevaDescripcion.trim() : null);

        if (TDomicilioJdbcImpl.getInstance().update(td)) {
            System.out.println("Tipo de domicilio actualizado.");
        } else {
            System.out.println("Error al actualizar.");
        }
    }

    @Override
    public void print() {
        List<TDomicilio> lista = TDomicilioJdbcImpl.getInstance().findAll();
        if (lista.isEmpty()) {
            System.out.println("No hay tipos de domicilio registrados.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        TDomicilio td = newT();
        if (processNewT(td)) {
            System.out.println("Tipo de domicilio guardado correctamente.");
        } else {
            System.out.println("No se guardó el tipo de domicilio.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID a editar:");
        int id = ReadUtil.readInt();
        TDomicilio td = TDomicilioJdbcImpl.getInstance().findById(id);
        if (td != null) {
            processEditT(td);
        } else {
            System.out.println("ID no encontrado.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID a eliminar:");
        int id = ReadUtil.readInt();
        TDomicilio td = TDomicilioJdbcImpl.getInstance().findById(id);
        if (td != null && TDomicilioJdbcImpl.getInstance().delete(td)) {
            System.out.println("Eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }
}

