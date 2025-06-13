package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.jdbc.Conexion;
import org.gerdoc.pixup.jdbc.DisqueraJdbc;
import org.gerdoc.pixup.model.Disquera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DisqueraJdbcImpl extends Conexion<Disquera> implements DisqueraJdbc
{
    private static DisqueraJdbc DisqueraJdbc;

    private DisqueraJdbcImpl( )
    {
        super( );
    }

    public static DisqueraJdbc getInstance( )
    {
        if( DisqueraJdbc == null ) {
            DisqueraJdbc = new DisqueraJdbcImpl();
        }
        return DisqueraJdbc;
    }

    public List<Disquera> findAll() {
        List<Disquera> list = new ArrayList<>();
        String sql = "SELECT * FROM TAB_DISQUERA";

        try {
            if (!openConnection()) {
                return list;
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Disquera disquera = new Disquera();
                disquera.setId(resultSet.getInt("ID"));
                disquera.setNombre(resultSet.getString("NOMBRE"));
                list.add(disquera);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Disquera disquera) {
        String sql = "INSERT INTO tab_disquera (NOMBRE) VALUES (?)";
        int res = 0;

        try {
            if (!openConnection()) {
                return false;
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, disquera.getNombre());
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
        DisqueraJdbc DisqueraJdbc = DisqueraJdbcImpl.getInstance();
        List<Disquera> list = DisqueraJdbc.findAll();
        for(Disquera disquera :list)
        {
            System.out.println(disquera.getId()+" "+ disquera.getNombre());
        }
    }
}