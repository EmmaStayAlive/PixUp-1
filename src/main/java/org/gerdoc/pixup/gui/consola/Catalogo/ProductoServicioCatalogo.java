package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.jdbc.impl.ArtistaJdbcImpl;
import org.gerdoc.pixup.jdbc.impl.ProductoServicioJdbcImpl;
import org.gerdoc.pixup.modelos.agregar.Artista;
import org.gerdoc.pixup.modelos.agregar.ProductoServicio;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class ProductoServicioCatalogo extends Catalogos<ProductoServicio> {
    private static ProductoServicioCatalogo instancia;

    private ProductoServicioCatalogo() {}

    public static ProductoServicioCatalogo getInstance() {
        if (instancia == null) {
            instancia = new ProductoServicioCatalogo();
        }
        return instancia;
    }

    @Override
    public ProductoServicio newT() {
        return new ProductoServicio();
    }

    @Override
    public boolean processNewT(ProductoServicio ps) {
        System.out.println("Nombre del producto o servicio:");
        ps.setNombre(ReadUtil.read());

        System.out.println("Descripción (opcional):");
        ps.setDescripcion(ReadUtil.read());

        System.out.println("Precio:");
        ps.setPrecio(ReadUtil.readDouble());

        System.out.println("Cantidad disponible:");
        ps.setCantidad(ReadUtil.readInt());

        System.out.println("Ruta de la imagen (opcional):");
        ps.setImagen(ReadUtil.read());

        System.out.println("ID del artista:");
        Artista artista = ArtistaJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (artista == null) {
            System.out.println("Artista no encontrado.");
            return false;
        }
        ps.setArtista(artista);

        return ProductoServicioJdbcImpl.getInstance().save(ps);
    }

    @Override
    public void processEditT(ProductoServicio ps) {
        System.out.println("ID: " + ps.getId());

        System.out.println("Nuevo nombre [" + ps.getNombre() + "]:");
        ps.setNombre(ReadUtil.read());

        System.out.println("Nueva descripción:");
        ps.setDescripcion(ReadUtil.read());

        System.out.println("Nuevo precio:");
        ps.setPrecio(ReadUtil.readDouble());

        System.out.println("Nueva cantidad:");
        ps.setCantidad(ReadUtil.readInt());

        System.out.println("Nueva imagen:");
        ps.setImagen(ReadUtil.read());

        System.out.println("Nuevo ID de artista:");
        Artista artista = ArtistaJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (artista != null) {
            ps.setArtista(artista);
        }

        if (ProductoServicioJdbcImpl.getInstance().update(ps)) {
            System.out.println("Producto/Servicio actualizado.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
    }

    @Override
    public void print() {
        List<ProductoServicio> lista = ProductoServicioJdbcImpl.getInstance().findAll();
        if (lista.isEmpty()) {
            System.out.println("No hay productos o servicios registrados.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    @Override
    public void add() {
        ProductoServicio ps = newT();
        if (processNewT(ps)) {
            System.out.println("Producto o servicio guardado correctamente.");
        } else {
            System.out.println("No se pudo guardar.");
        }
    }

    @Override
    public void edit() {
        print();
        System.out.println("ID del producto o servicio a editar:");
        ProductoServicio ps = ProductoServicioJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (ps != null) {
            processEditT(ps);
        } else {
            System.out.println("No se encontró el registro.");
        }
    }

    @Override
    public void remove() {
        print();
        System.out.println("ID del producto o servicio a eliminar:");
        ProductoServicio ps = ProductoServicioJdbcImpl.getInstance().findById(ReadUtil.readInt());
        if (ps != null && ProductoServicioJdbcImpl.getInstance().delete(ps)) {
            System.out.println("Eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }
}