package org.gerdoc.pixup.jdbc;

import org.gerdoc.pixup.model.Estado;

import java.util.List;

public interface EstadoJdbc
{
    List<Estado> findAll( );
}
