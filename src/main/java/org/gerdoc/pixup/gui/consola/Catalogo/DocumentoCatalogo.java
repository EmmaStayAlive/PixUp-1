package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.ArtistaJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.DocumentoJdbcImpl;
import org.gerdoc.pixup.modelos.agregar.Artista;
import org.gerdoc.pixup.modelos.agregar.Documento;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class DocumentoCatalogo extends Catalogos<Documento> {
    private static DocumentoCatalogo instancia;

    private DocumentoCatalogo() {}

    public static DocumentoCatalogo getInstance() {
        if (instancia == null) {
            instancia = new DocumentoCatalogo();
        }
        return instancia;
    }

    @Override
    public Documento newT() {
        return new Documento();
    }

    @Override
    public boolean processNewT(Documento documento) {
        System.out.println("Nombre del documento:");
        documento.setNombre(ReadUtil.read());

        System.out.println("Descripción (opcional):");
        documento.setDescripcion(ReadUtil.read());

        System.out.println("Ruta del archivo:");
        documento.setArchivo(ReadUtil.read());

        System.out.println("Fecha (ej. 2025-06-24):");
        documento.setFecha(ReadUtil.read());

        System.out.println("ID del artista:");
        Artista artista = ArtistaJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (artista == null) {
            System.out.println("Artista no encontrado.");
            return false;
        }
        documento.setArtista(artista);

        return DocumentoJdbcImpl.getInstance().save(documento);
    }

    @Override
    public void processEditT(Documento documento) {
        System.out.println("Editar Documento ID: " + documento.getId());

        System.out.println("Nuevo nombre [" + documento.getNombre() + "]:");
        documento.setNombre(ReadUtil.read());

        System.out.println("Nueva descripción:");
        documento.setDescripcion(ReadUtil.read());

        System.out.println("Nueva ruta del archivo:");
        documento.setArchivo(ReadUtil.read());

        System.out.println("Nueva fecha:");
        documento.setFecha(ReadUtil.read());

        System.out.println("Nuevo ID de artista:");
        Artista artista = ArtistaJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (artista != null) {
            documento.setArtista(artista);
        }

        if (DocumentoJdbcImpl.getInstance().update(documento)) {
            System.out.println("Documento actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
    }

    @Override
    public void print() {
        List<Documento> documentos = DocumentoJdbcImpl.getInstance().findAll();
        if (documentos.isEmpty()) {
            System.out.println("No hay documentos registrados.");
        } else {
            documentos.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        Documento documento = newT();
        if (processNewT(documento)) {
            System.out.println("Documento guardado correctamente.");
        } else {
            System.out.println("No se pudo guardar el documento.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID del documento a editar:");
        Documento documento = DocumentoJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (documento != null) {
            processEditT(documento);
        } else {
            System.out.println("Documento no encontrado.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID del documento a eliminar:");
        Documento documento = DocumentoJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (documento != null && DocumentoJdbcImpl.getInstance().delete(documento)) {
            System.out.println("Documento eliminado.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }
}