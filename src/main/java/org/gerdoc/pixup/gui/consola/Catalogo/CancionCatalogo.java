package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.modelos.agregar.Disco;
import org.gerdoc.pixup.modelos.agregar.Cancion;
import org.gerdoc.pixup.util.ReadUtil;

public class CancionCatalogo extends Catalogos<Cancion> {
    public static CancionCatalogo cancionCatalogo;

    private CancionCatalogo() {
        super();
    }

    public static CancionCatalogo getInstance() {
        if (cancionCatalogo == null) {
            cancionCatalogo = new CancionCatalogo();
        }
        return cancionCatalogo;
    }

    @Override
    public Cancion newT() {
        return new Cancion();
    }

    @Override
    public boolean processNewT(Cancion cancion) {

        System.out.println("Ingresa el Título de la Canción");
        cancion.setTitulo(ReadUtil.read());

        System.out.println("Ingresa la Duración de la Canción (en minutos)");
        cancion.setDuracion(ReadUtil.read());

        System.out.println("Ingresa el Id del Disco asociado a la Canción");
        int idDisco = Integer.parseInt(ReadUtil.read());
        Disco disco = HibernateUtil.getSession().find(Disco.class, idDisco);
        cancion.setDisco(disco);

        return true;
    }

    @Override
    public void processEditT(Cancion cancion) {
        System.out.println("ID de la Canción: " + cancion.getId());
        System.out.println("Título de la Canción a editar: " + cancion.getTitulo());

        System.out.println("Ingresa el nuevo Título de la Canción (presiona Enter para mantener el actual)");
        cancion.setTitulo(ReadUtil.read());

        System.out.println("Ingresa la nueva Duración de la Canción (presiona Enter para mantener la actual)");
        cancion.setDuracion(ReadUtil.read());

        System.out.println("Ingresa el nuevo Id del Disco asociado a la Canción (presiona Enter para mantener el actual)");
        int idDisco = Integer.parseInt(ReadUtil.read());
        Disco disco = HibernateUtil.getSession().find(Disco.class, idDisco);
        cancion.setDisco(disco);
    }
}