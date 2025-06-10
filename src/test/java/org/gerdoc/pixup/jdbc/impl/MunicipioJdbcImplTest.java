package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.jdbc.MunicipioJdbc;
import org.gerdoc.pixup.model.Municipio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class MunicipioJdbcImplTest
{

    @Test
    void getInstance( )
    {
        Assertions.assertNotNull(MunicipioJdbcImpl.getInstance());
        //Assertions.assertNull(MunicipioJdbcImpl.getInstance());
    }


    @Test
    void findAll()
    {
        System.out.println("findAll");
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance( );
        List<Municipio> list = municipioJdbc.findAll( );
        Assertions.assertNotNull( list );
        list.stream().forEach( System.out::println );
    }

    @Test
    void findById()
    {
        System.out.println("findById");
    }
}