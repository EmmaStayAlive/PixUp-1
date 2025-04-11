package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.jdbc.EstadoJdbc;
import org.gerdoc.pixup.model.Estado;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class EstadoJdbcImplTest
{
    EstadoJdbc estadoJdbc;

    @Test
    void getInstance()
    {
        estadoJdbc = EstadoJdbcImpl.getInstance();
        assertNotNull(estadoJdbc);
    }

    @Test
    void findAll()
    {
        List<Estado>list = null;
        estadoJdbc = EstadoJdbcImpl.getInstance();
        list = estadoJdbc.findAll();
        assertNotNull( list );
        assertEquals( 1, list.size( ) );
        list.forEach( System.out::println );
    }

    @Test
    void save()
    {
        Estado estado = null;
        estadoJdbc = EstadoJdbcImpl.getInstance();
        estado = new Estado( );
        estado.setNombre( "CHIAPAS");
        assertTrue( estadoJdbc.save( estado ) );
    }

    @Test
    void main() {
    }
}