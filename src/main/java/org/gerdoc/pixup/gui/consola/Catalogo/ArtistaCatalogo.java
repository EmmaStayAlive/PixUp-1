package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.modelos.agregar.Artista;
import org.gerdoc.pixup.util.ReadUtil;

public class ArtistaCatalogo extends Catalogos<Artista> {
    public static ArtistaCatalogo artistaCatalogo;

    private ArtistaCatalogo() {
        super();
    }

    public static ArtistaCatalogo getInstance() {
        if (artistaCatalogo == null) {
            artistaCatalogo = new ArtistaCatalogo();
        }
        return artistaCatalogo;
    }

    @Override
    public Artista newT() {
        return new Artista();
    }

    @Override
    public boolean processNewT(Artista artista) {
        System.out.println("Ingresa el Nombre del Artista");
        artista.setNombre(ReadUtil.read());

        System.out.println("Ingresa la Biografía del Artista");
        artista.setBiografia(ReadUtil.read());

        System.out.println("Ingresa la URL del Logo del Artista");
        artista.setLogo(ReadUtil.read());

        return true;
    }

    @Override
    public void processEditT(Artista artista) {
        System.out.println("ID del Artista: " + artista.getId());
        System.out.println("Nombre del Artista a editar: " + artista.getNombre());

        System.out.println("Teclee el nuevo nombre del Artista:");
        artista.setNombre(ReadUtil.read());

        System.out.println("Teclee la nueva biografía del Artista:");
        artista.setBiografia(ReadUtil.read());

        System.out.println("Teclee la nueva URL del Logo del Artista:");
        artista.setLogo(ReadUtil.read());
    }
}