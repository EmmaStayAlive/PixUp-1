package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.jdbc.EstadoJdbc;
import org.gerdoc.pixup.modelos.registro.ubiacion.Estado;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class EstadoJdbcImplTest
{

    @Test
    void findAll( )
    {
        EstadoJdbc estadoJdbc = EstadoJdbcImpl.getInstance( );
        List<Estado> estados = estadoJdbc.findAll( );

        assertNotNull( estados );
        assertTrue( estados.size( ) > 0 );
        estados.forEach( System.out::println );
    }

    @Test
    void save()
    {
        EstadoJdbc estadoJdbc = EstadoJdbcImpl.getInstance( );
        Estado estado = new Estado( );
        estado.setNombre( "YUCATAN" );
        boolean save = estadoJdbc.save( estado );
        assertTrue( save );
    }

    @Test
    void update()
    {
    }

    @Test
    void delete()
    {
    }

    @Test
    void findById()
    {
        EstadoJdbc estadoJdbc = EstadoJdbcImpl.getInstance( );
        Estado estado = estadoJdbc.findById( 1 );
        assertNotNull( estado );
        assertEquals( "CDMX", estado.getNombre( ) );
        System.out.println( estado );
    }
}