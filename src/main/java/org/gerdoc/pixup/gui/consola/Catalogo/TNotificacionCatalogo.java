package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.TNotificacionJdbcImpl;
import org.gerdoc.pixup.modelos.registro.notificacion.TNotificacion;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class TNotificacionCatalogo extends Catalogos<TNotificacion> {
    private static TNotificacionCatalogo instancia;

    private TNotificacionCatalogo() {}

    public static TNotificacionCatalogo getInstance() {
        if (instancia == null) {
            instancia = new TNotificacionCatalogo();
        }
        return instancia;
    }

    @Override
    public TNotificacion newT() {
        return new TNotificacion();
    }

    @Override
    public boolean processNewT(TNotificacion tNotificacion) {
        System.out.println("Descripción de la notificación:");
        tNotificacion.setDescripcion(ReadUtil.read());

        System.out.println("Tipo de notificación:");
        tNotificacion.setTipo(ReadUtil.read());

        return TNotificacionJdbcImpl.getInstance().save(tNotificacion);
    }

    @Override
    public void processEditT(TNotificacion tNotificacion) {
        System.out.println("Editar Tipo de Notificación ID: " + tNotificacion.getId());

        System.out.println("Descripción actual: " + tNotificacion.getDescripcion());
        System.out.println("Nueva descripción:");
        tNotificacion.setDescripcion(ReadUtil.read());

        System.out.println("Tipo actual: " + tNotificacion.getTipo());
        System.out.println("Nuevo tipo:");
        tNotificacion.setTipo(ReadUtil.read());

        if (TNotificacionJdbcImpl.getInstance().update(tNotificacion)) {
            System.out.println("Tipo de notificación actualizado.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
    }

    @Override
    public void print() {
        List<TNotificacion> lista = TNotificacionJdbcImpl.getInstance().findAll();
        if (lista.isEmpty()) {
            System.out.println("No hay tipos de notificación registrados.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        TNotificacion tNotificacion = newT();
        if (processNewT(tNotificacion)) {
            System.out.println("Tipo de notificación guardado.");
        } else {
            System.out.println("No se pudo guardar.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID del tipo de notificación a editar:");
        int id = ReadUtil.readInt();
        TNotificacion t = TNotificacionJdbcImpl.getInstance().findById(id);
        if (t != null) {
            processEditT(t);
        } else {
            System.out.println("No se encontró el ID.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID del tipo de notificación a eliminar:");
        int id = ReadUtil.readInt();
        TNotificacion t = TNotificacionJdbcImpl.getInstance().findById(id);
        if (t != null && TNotificacionJdbcImpl.getInstance().delete(t)) {
            System.out.println("Tipo de notificación eliminado.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }
}

