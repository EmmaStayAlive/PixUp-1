package org.gerdoc.pixup.jdbc;
import org.gerdoc.pixup.model.Disco;
import org.gerdoc.pixup.model.Disquera;
import java.util.List;

public interface DisqueraJdbc
{
    List<Disquera> findAll( );
    boolean save( Disquera disquera );
}
