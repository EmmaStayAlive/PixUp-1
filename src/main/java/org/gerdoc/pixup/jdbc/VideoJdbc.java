package org.gerdoc.pixup.jdbc;

import java.util.List;

import org.gerdoc.pixup.modelos.agregar.Video;

public interface VideoJdbc
{
    List<Video> findAll( );
    boolean save( Video video );
    boolean update( Video video );
    boolean delete( Video video );
    Video findById( int id );
}
