package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.modelos.agregar.Artista;
import org.gerdoc.pixup.modelos.agregar.Documento;
import org.gerdoc.pixup.util.ReadUtil;

public class DocumentoCatalogo extends Catalogos<Documento> {
    public static DocumentoCatalogo documentoCatalogo;

    private DocumentoCatalogo() {
        super();
    }

    public static DocumentoCatalogo getInstance() {
        if (documentoCatalogo == null) {
            documentoCatalogo = new DocumentoCatalogo();
        }
        return documentoCatalogo;
    }

    @Override
    public Documento newT() {
        return new Documento();
    }

    @Override
    public boolean processNewT(Documento documento) {

        System.out.println("Ingresa el Nombre del Documento");
        documento.setNombre(ReadUtil.read());

        System.out.println("Ingresa la Descripción del Documento");
        documento.setDescripcion(ReadUtil.read());

        System.out.println("Ingresa la URL del Archivo del Documento");
        documento.setArchivo(ReadUtil.read());

        System.out.println("Ingresa la Fecha de Creación del Documento (en formato YYYYMMDD)");
        documento.setFecha(ReadUtil.read());

        System.out.println("Ingresa el Id del Artista asociado al Documento");
        int idArtista = Integer.parseInt(ReadUtil.read());
        Artista artista = HibernateUtil.getSession().find(Artista.class, idArtista);
        documento.setArtista(artista);

        return true;
    }

    @Override
    public void processEditT(Documento documento) {
        System.out.println("ID del Documento: " + documento.getId());
        System.out.println("Nombre del Documento a editar: " + documento.getNombre());

        System.out.println("Ingresa el nuevo Nombre del Documento (presiona Enter para mantener el actual)");
        documento.setNombre(ReadUtil.read());

        System.out.println("Ingresa la nueva Descripción del Documento (presiona Enter para mantener la actual)");
        documento.setDescripcion(ReadUtil.read());

        System.out.println("Ingresa la nueva URL del Archivo del Documento (presiona Enter para mantener la actual)");
        documento.setArchivo(ReadUtil.read());

        System.out.println("Ingresa la nueva Fecha de Creación del Documento (en formato YYYYMMDD, presiona Enter para mantener la actual)");
        documento.setFecha(ReadUtil.read());

        System.out.println("Ingresa el nuevo Id del Artista asociado al Documento (presiona Enter para mantener el actual)");
        int idArtista = Integer.parseInt(ReadUtil.read());
        Artista artista = HibernateUtil.getSession().find(Artista.class, idArtista);
        documento.setArtista(artista);
    }
}
