package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.model.Estado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstadoCatalogoTest {

    @Test
    void getInstance()
    {
        EstadoCatalogo estadoCatalogo = EstadoCatalogo.getInstance();
        assertNotNull( estadoCatalogo );
    }

    @Test
    void newT()
    {
        EstadoCatalogo estadoCatalogo = EstadoCatalogo.getInstance();
        Estado estado = estadoCatalogo.newT( );
        assertNotNull( estado );
    }

    @Test
    void processNewT()
    {

    }

    @Test
    void processEditT() {
    }

    @Test
    void loadEstadoJdbc()
    {
        EstadoCatalogo estadoCatalogo = EstadoCatalogo.getInstance();
        boolean res = estadoCatalogo.loadEstadoJdbc();
        assertTrue( res );
    }

    @Test
    void print()
    {
        EstadoCatalogo estadoCatalogo = EstadoCatalogo.getInstance();
        estadoCatalogo.print( );
    }
}