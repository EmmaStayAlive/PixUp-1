package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.jdbc.Conexion;
import org.gerdoc.pixup.jdbc.GeneroJdbc;
import org.gerdoc.pixup.model.Artista;
import org.gerdoc.pixup.model.Genero;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GeneroJdbcImpl extends Conexion<Genero> implements GeneroJdbc
{
    private static GeneroJdbc GeneroJdbc;

    private GeneroJdbcImpl( )
    {
        super( );
    }

    public static GeneroJdbc getInstance( )
    {
        if( GeneroJdbc == null ) {
            GeneroJdbc = new GeneroJdbcImpl();
        }
        return GeneroJdbc;
    }

    public List<Genero> findAll() {
        List<Genero> list = new ArrayList<>();
        String sql = "SELECT * FROM TAB_GENERO";

        try {
            if (!openConnection()) {
                return list;
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Genero genero = new Genero();
                genero.setId(resultSet.getInt("ID"));
                genero.setDescripcion(resultSet.getString("DESCRIPCION"));
                list.add(genero);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Genero genero) {
        String sql = "INSERT INTO tab_genero (DESCRIPCION) VALUES (?)";
        int res = 0;

        try {
            if (!openConnection()) {
                return false;
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, genero.getDescripcion());
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
        GeneroJdbc GeneroJdbc = GeneroJdbcImpl.getInstance();
        List<Genero> list = GeneroJdbc.findAll();
        for(Genero genero:list)
        {
            System.out.println(genero.getId()+" "+genero.getDescripcion());
        }
    }
}