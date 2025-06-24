package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.modelos.registro.ubicacion.Municipio;
import org.gerdoc.pixup.modelos.registro.ubicacion.Estado;
import org.gerdoc.pixup.util.ReadUtil;

public class MunicipioCatalogo extends Catalogos<Municipio> {
    public static MunicipioCatalogo municipioCatalogo;

    private MunicipioCatalogo() {
        super();
    }

    public static MunicipioCatalogo getInstance() {
        if (municipioCatalogo == null) {
            municipioCatalogo = new MunicipioCatalogo();
        }
        return municipioCatalogo;
    }

    @Override
    public Municipio newT() {
        return new Municipio();
    }

    @Override
    public boolean processNewT(Municipio municipio) {

        System.out.println("Ingresa el nombre del Municipio:");
        municipio.setNombre(ReadUtil.read());

        System.out.println("Ingresa el Id del Estado al que pertenece el Municipio:");
        int idEstado = Integer.parseInt(ReadUtil.read());
        Estado estado = HibernateUtil.getSession().find(Estado.class, idEstado);
        municipio.setEstado(estado);

        return true;
    }

    @Override
    public void processEditT(Municipio municipio) {
        System.out.println("Id del Municipio: " + municipio.getId());
        System.out.println("Municipio a editar: " + municipio.getNombre());

        System.out.println("Teclee el nuevo nombre del Municipio:");
        municipio.setNombre(ReadUtil.read());

        System.out.println("Ingresa el Id del Estado al que pertenece el Municipio:");
        int idEstado = Integer.parseInt(ReadUtil.read());
        Estado estado = HibernateUtil.getSession().find(Estado.class, idEstado);
        municipio.setEstado(estado);
    }
}