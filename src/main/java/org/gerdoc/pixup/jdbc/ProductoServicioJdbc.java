package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.agregar.ProductoServicio;

public interface ProductoServicioJdbc {
    List<ProductoServicio> findAll( );
    boolean save( ProductoServicio productoServicio );
    boolean update( ProductoServicio productoServicio );
    boolean delete( ProductoServicio productoServicio );
    ProductoServicio findById( int id );
}

