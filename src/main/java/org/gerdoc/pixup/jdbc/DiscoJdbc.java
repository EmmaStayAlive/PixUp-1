package org.gerdoc.pixup.jdbc;
import org.gerdoc.pixup.model.Disco;
import java.util.List;

public interface DiscoJdbc
{
    List<Disco> findAll( );
    boolean save( Disco disco );
}
