package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.jdbc.Conexion;
import org.gerdoc.pixup.jdbc.MunicipioJdbc;
import org.gerdoc.pixup.model.Estado;
import org.gerdoc.pixup.model.Municipio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MunicipioJdbcImpl extends Conexion<Municipio> implements MunicipioJdbc
{
    private static MunicipioJdbc municipioJdbc;

    private MunicipioJdbcImpl()
    {
    }

    public static MunicipioJdbc getInstance( )
    {
        if( municipioJdbc == null)
        {
            municipioJdbc = new MunicipioJdbcImpl( );
        }
        return municipioJdbc;
    }

    @Override
    public List<Municipio> findAll()
    {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Municipio> list = null;
        Municipio municipio = null;
        String sql ="Select M.ID M_ID,M.MUNICIPIO MUNICIPIO, E.ID E_ID, E.ESTADO ESTADO  from TBL_Municipio M INNER JOIN TBL_ESTADO E ON E.ID = M.TBL_ESTADO_ID";
        try
        {
            if( !openConnection() ) {
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery( sql );
            if( resultSet == null )
            {
                return null;
            }
            list =  new java.util.ArrayList<Municipio>( );
            while( resultSet.next( ) )
            {
                municipio = new Municipio( );
                municipio.setId( resultSet.getInt( 1) );
                municipio.setNombre( resultSet.getString( 2 ) );
                municipio.setEstado( new Estado( ) );
                municipio.getEstado().setId( resultSet.getInt( 3 ) );
                municipio.getEstado().setNombre( resultSet.getString( 4 ) );
                list.add( municipio );
            }
            resultSet.close( );
            closeConnection( );
            return list;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Municipio municipio) {
        return false;
    }
}
