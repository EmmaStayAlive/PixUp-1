package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.modelos.agregar.Genero;
import org.gerdoc.pixup.modelos.agregar.Disco;
import org.gerdoc.pixup.modelos.agregar.Artista;
import org.gerdoc.pixup.util.ReadUtil;

public class DiscoCatalogo extends Catalogos<Disco> {
    public static DiscoCatalogo discoCatalogo;

    private DiscoCatalogo() {
        super();
    }

    public static DiscoCatalogo getInstance() {
        if (discoCatalogo == null) {
            discoCatalogo = new DiscoCatalogo();
        }
        return discoCatalogo;
    }

    @Override
    public Disco newT() {
        return new Disco();
    }

    @Override
    public boolean processNewT(Disco disco) {

        System.out.println("Ingresa el Nombre del Disco");
        disco.setNombre(ReadUtil.read());

        System.out.println("Ingresa la Descripción del Disco (opcional)");
        disco.setDescripcion(ReadUtil.read());

        System.out.println("Ingresa la URL de la Portada del Disco (opcional)");
        disco.setPortada(ReadUtil.read());

        System.out.println("Ingresa el Año de Publicación del Disco (YYYY)");
        disco.setFecha(ReadUtil.read());

        System.out.println("Ingresa la Duración del Disco en minutos");
        disco.setDuracion(ReadUtil.read());

        System.out.println("Ingresa el Id del Artista asociado al Disco");
        int idArtista = Integer.parseInt(ReadUtil.read());
        Artista artista = HibernateUtil.getSession().find(Artista.class, idArtista);
        disco.setArtista(artista);

        System.out.println("Ingresa el Id del Género del Disco");
        int idGenero = Integer.parseInt(ReadUtil.read());
        Genero genero = HibernateUtil.getSession().find(Genero.class, idGenero);
        disco.setGenero(genero);

        return true;
    }

    @Override
    public void processEditT(Disco disco) {

        System.out.println("ID del Disco: " + disco.getId());
        System.out.println("Nombre del Disco a editar: " + disco.getNombre());

        System.out.println("Ingresa el nuevo Nombre del Disco (presiona Enter para mantener el actual)");
        disco.setNombre(ReadUtil.read());

        System.out.println("Ingresa la nueva Descripción del Disco (presiona Enter para mantener la actual)");
        disco.setDescripcion(ReadUtil.read());

        System.out.println("Ingresa la nueva URL de la Portada del Disco (presiona Enter para mantener la actual)");
        disco.setPortada(ReadUtil.read());

        System.out.println("Ingresa el nuevo Año de Publicación del Disco (YYYY, presiona Enter para mantener el actual)");
        disco.setFecha(ReadUtil.read());

        System.out.println("Ingresa la nueva Duración del Disco en minutos (presiona Enter para mantener la actual)");
        disco.setDuracion(ReadUtil.read());

        System.out.println("Ingresa el nuevo Id del Artista asociado al Disco (presiona Enter para mantener el actual)");
        int idArtista = Integer.parseInt(ReadUtil.read());
        Artista artista = HibernateUtil.getSession().find(Artista.class, idArtista);
        disco.setArtista(artista);

        System.out.println("Ingresa el nuevo Id del Género del Disco (presiona Enter para mantener el actual)");
        int idGenero = Integer.parseInt(ReadUtil.read());
        Genero genero = HibernateUtil.getSession().find(Genero.class, idGenero);
        disco.setGenero(genero);
    }
}