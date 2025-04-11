package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.jdbc.Conexion;
import org.gerdoc.pixup.jdbc.EstadoJdbc;
import org.gerdoc.pixup.model.Estado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EstadoJdbcImpl extends Conexion<Estado> implements EstadoJdbc
{
    private static EstadoJdbcImpl estadoJdbc;

    private EstadoJdbcImpl( )
    {
        super( );
    }


    public static EstadoJdbcImpl getInstance( )
    {
        if( estadoJdbc == null )
        {
            estadoJdbc = new EstadoJdbcImpl();
        }
        return estadoJdbc;
    }

    @Override
    public List<Estado> findAll()
    {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Estado> list = null;
        Estado estado = null;
        String sql ="Select * from TBL_ESTADO";


        try
        {
            if( !openConnection() )
            {
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery( sql );
            if( resultSet == null )
            {
                return null;
            }
            list =  new java.util.ArrayList<Estado>( );
            while( resultSet.next( ) )
            {
                estado = new Estado();
                estado.setId( resultSet.getInt( "ID" ) );
                estado.setNombre( resultSet.getString( "ESTADO" ) );
                list.add( estado );
            }
            resultSet.close( );
            closeConnection( );
            return list;
        }
        catch (SQLException e)
        {
            return null;
        }
    }

    @Override
    public boolean save(Estado estado)
    {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO TBL_ESTADO (ESTADO) VALUES (?)";
        int res = 0;
        try
        {
            if( !openConnection( ) )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement( sql );
            preparedStatement.setString( 1, estado.getNombre( ) );
            res = preparedStatement.executeUpdate( );
            preparedStatement.close( );
            closeConnection( );
            return res == 1;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        EstadoJdbcImpl estadoJdbc = EstadoJdbcImpl.getInstance();
        List<Estado> list = estadoJdbc.findAll();
        for(Estado estado:list)
        {
            System.out.println(estado.getId()+" "+estado.getNombre());
        }
    }

}
