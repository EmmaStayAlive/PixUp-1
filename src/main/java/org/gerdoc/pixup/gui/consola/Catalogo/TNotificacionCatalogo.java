package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.modelos.registro.notificacion.TNotificacion;
import org.gerdoc.pixup.util.ReadUtil;

public class TNotificacionCatalogo extends Catalogos<TNotificacion> {
    public static TNotificacionCatalogo tNotificacionCatalogo;

    private TNotificacionCatalogo() {
        super();
    }

    public static TNotificacionCatalogo getInstance() {
        if (tNotificacionCatalogo == null) {
            tNotificacionCatalogo = new TNotificacionCatalogo();
        }
        return tNotificacionCatalogo;
    }

    @Override
    public TNotificacion newT() {
        return new TNotificacion();
    }

    @Override
    public boolean processNewT(TNotificacion tNotificacion) {
        System.out.println("Ingresa la Descripcion del Tipo de Notificación:");
        tNotificacion.setDescripcion(ReadUtil.read());

        System.out.println("Ingresa el Tipo de Notificación:");
        tNotificacion.setTipo(ReadUtil.read());

        return true;
    }

    @Override
    public void processEditT(TNotificacion tNotificacion) {
        System.out.println("Id del Tipo de Notificación: " + tNotificacion.getId());
        System.out.println("Tipo de Notificación a editar: " + tNotificacion.getDescripcion());

        System.out.println("Teclee el nuevo valor de la descripcion:");
        tNotificacion.setDescripcion(ReadUtil.read());

        System.out.println("Teclee el nuevo tipo de Notificación:");
        tNotificacion.setTipo(ReadUtil.read());
    }
}