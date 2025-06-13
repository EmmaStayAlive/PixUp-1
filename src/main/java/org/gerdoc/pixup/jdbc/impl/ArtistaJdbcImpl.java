package org.gerdoc.pixup.jdbc.impl;

import org.gerdoc.pixup.jdbc.Conexion;
import org.gerdoc.pixup.jdbc.ArtistaJdbc;
import org.gerdoc.pixup.model.Artista;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistaJdbcImpl extends Conexion<Artista> implements ArtistaJdbc
{
    private static ArtistaJdbc artistaJdbc;

    private ArtistaJdbcImpl( )
    {
        super( );
    }

    public static ArtistaJdbc getInstance( )
    {
        if( artistaJdbc == null ) {
            artistaJdbc = new ArtistaJdbcImpl();
        }
        return artistaJdbc;
    }

    public List<Artista> findAll() {
        List<Artista> list = new ArrayList<>();
        String sql = "SELECT * FROM TAB_ARTISTA";

        try {
            if (!openConnection()) {
                return list;
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Artista artista = new Artista();
                artista.setId(resultSet.getInt("ID"));
                artista.setNombre(resultSet.getString("NOMBRE"));
                list.add(artista);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Artista artista) {
        String sql = "INSERT INTO tab_artista (NOMBRE) VALUES (?)";
        int res = 0;

        try {
            if (!openConnection()) {
                return false;
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, artista.getNombre());
                res = preparedStatement.executeUpdate();
            }

            closeConnection(); // Cierra la conexión después de la ejecución
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        List<Artista> list = artistaJdbc.findAll();
        for(Artista artista:list)
        {
            System.out.println(artista.getId()+" "+artista.getNombre());
        }
    }
}