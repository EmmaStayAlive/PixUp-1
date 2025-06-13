package org.gerdoc.pixup.jdbc;
import org.gerdoc.pixup.model.Disco;
import org.gerdoc.pixup.model.Genero;

import java.util.List;

public interface GeneroJdbc
{
    List<Genero> findAll( );
    boolean save( Genero genero );
}
