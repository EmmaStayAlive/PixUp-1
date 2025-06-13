package org.gerdoc.pixup.jdbc;
import org.gerdoc.pixup.model.Cancion;
import org.gerdoc.pixup.model.Disco;
import java.util.List;

public interface CancionJdbc
{
    List<Cancion> findAll( );
    boolean save( Cancion cancion );
}
