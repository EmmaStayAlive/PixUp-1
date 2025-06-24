package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.modelos.registro.ubicacion.TDomicilio;
import org.gerdoc.pixup.util.ReadUtil;

public class TDomicilioCatalogo extends Catalogos<TDomicilio> {
    public static TDomicilioCatalogo tDomicilioCatalogo;

    private TDomicilioCatalogo() {
        super();
    }

    public static TDomicilioCatalogo getInstance() {
        if (tDomicilioCatalogo == null) {
            tDomicilioCatalogo = new TDomicilioCatalogo();
        }
        return tDomicilioCatalogo;
    }

    @Override
    public TDomicilio newT() {
        return new TDomicilio();
    }

    @Override
    public boolean processNewT(TDomicilio tDomicilio) {
        System.out.println("Ingresa la Descripcion del Tipo de Domicilio:");
        tDomicilio.setDescripcion(ReadUtil.read());

        System.out.println("Ingresa la Ruta del Tipo de Domicilio:");
        tDomicilio.setRuta(ReadUtil.read());

        return true;
    }

    @Override
    public void processEditT(TDomicilio tDomicilio) {
        System.out.println("Id del Tipo de Domicilio: " + tDomicilio.getId());
        System.out.println("Tipo de Domicilio a editar: " + tDomicilio.getDescripcion());

        System.out.println("Teclee el nuevo valor de la descripcion:");
        tDomicilio.setDescripcion(ReadUtil.read());

        System.out.println("Teclee la nueva ruta del Tipo de Domicilio:");
        tDomicilio.setRuta(ReadUtil.read());
    }
}