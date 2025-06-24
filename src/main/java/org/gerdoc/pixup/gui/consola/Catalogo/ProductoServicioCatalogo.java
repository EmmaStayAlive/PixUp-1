package org.gerdoc.pixup.gui.consola.Catalogo;

import org.gerdoc.pixup.gui.consola.Catalogos;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.modelos.agregar.ProductoServicio;
import org.gerdoc.pixup.modelos.agregar.Artista;
import org.gerdoc.pixup.util.ReadUtil;

public class ProductoServicioCatalogo extends Catalogos<ProductoServicio> {
    public static ProductoServicioCatalogo productoServicioCatalogo;

    private ProductoServicioCatalogo() {
        super();
    }

    public static ProductoServicioCatalogo getInstance() {
        if (productoServicioCatalogo == null) {
            productoServicioCatalogo = new ProductoServicioCatalogo();
        }
        return productoServicioCatalogo;
    }

    @Override
    public ProductoServicio newT() {
        return new ProductoServicio();
    }

    @Override
    public boolean processNewT(ProductoServicio productoServicio) {

        System.out.println("Ingresa el Nombre del Producto/Servicio");
        productoServicio.setNombre(ReadUtil.read());

        System.out.println("Ingresa la Descripción del Producto/Servicio");
        productoServicio.setDescripcion(ReadUtil.read());

        System.out.println("Ingresa el Precio del Producto/Servicio");
        productoServicio.setPrecio(Double.parseDouble(ReadUtil.read()));

        System.out.println("Ingresa la Cantidad del Producto/Servicio disponible");
        productoServicio.setCantidad(Integer.parseInt(ReadUtil.read()));
        
        System.out.println("Ingresa la URL de la Imagen del Producto/Servicio (opcional, presiona Enter para omitir)");
        productoServicio.setImagen(ReadUtil.read());

        System.out.println("Ingresa el Id del Artista asociado al Producto/Servicio");
        int idArtista = Integer.parseInt(ReadUtil.read());
        Artista artista = HibernateUtil.getSession().find(Artista.class, idArtista);
        productoServicio.setArtista(artista);

        return true;
    }

    @Override
    public void processEditT(ProductoServicio productoServicio) {
        System.out.println("ID del Producto/Servicio: " + productoServicio.getId());
        System.out.println("Nombre del Producto/Servicio a editar: " + productoServicio.getNombre());

        System.out.println("Ingresa el nuevo Nombre del Producto/Servicio (presiona Enter para mantener el actual)");
        productoServicio.setNombre(ReadUtil.read());

        System.out.println("Ingresa la nueva Descripción del Producto/Servicio (presiona Enter para mantener la actual)");
        productoServicio.setDescripcion(ReadUtil.read());

        System.out.println("Ingresa el nuevo Precio del Producto/Servicio (presiona Enter para mantener el actual)");
        productoServicio.setPrecio(ReadUtil.readDouble());

        System.out.println("Ingresa la nueva Cantidad del Producto/Servicio disponible (presiona Enter para mantener la actual)");
        productoServicio.setCantidad(ReadUtil.readInt());

        System.out.println("Ingresa la nueva URL de la Imagen del Producto/Servicio (presiona Enter para mantener la actual)");
        productoServicio.setImagen(ReadUtil.read());

        System.out.println("Ingresa el Id del nuevo Propietario del Producto/Servicio (Artista)");
        int idArtista = Integer.parseInt(ReadUtil.read());
        Artista artista = HibernateUtil.getSession().find(Artista.class, idArtista);
        productoServicio.setArtista(artista);
    }
}