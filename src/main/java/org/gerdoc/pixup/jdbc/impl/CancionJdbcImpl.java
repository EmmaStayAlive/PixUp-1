package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.jdbc.Conexion;
import org.gerdoc.pixup.jdbc.CancionJdbc;
import org.gerdoc.pixup.model.Cancion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CancionJdbcImpl extends Conexion<Cancion> implements CancionJdbc
{
    private static CancionJdbc cancionJdbc;

    private CancionJdbcImpl( )
    {
        super( );
    }

    public static CancionJdbc getInstance( )
    {
        if( cancionJdbc == null ) {
            cancionJdbc = new CancionJdbcImpl();
        }
        return cancionJdbc;
    }

    public List<Cancion> findAll() {
        List<Cancion> list = new ArrayList<>();
        String sql = "SELECT * FROM TAB_CANCION";

        try {
            if (!openConnection()) {
                return list;
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Cancion cancion = new Cancion();
                cancion.setId(resultSet.getInt("ID"));
                cancion.setTitulo(resultSet.getString("NOMBRE"));
                cancion.setDuracion(resultSet.getString("DURACION"));
                list.add(cancion);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Cancion cancion) {
        String sql = "INSERT INTO tab_cancion (NOMBRE, DURACION) VALUES (?, ?)";
        int res = 0;

        try {
            if (!openConnection()) {
                return false;
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, cancion.getTitulo());
                res = preparedStatement.executeUpdate();
            }

            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        CancionJdbc cancionJdbc = CancionJdbcImpl.getInstance();
        List<Cancion> list = cancionJdbc.findAll();
        for(Cancion cancion :list)
        {
            System.out.println(cancion.getId()+" "+ cancion.getTitulo());
        }
    }
}