package org.gerdoc.pixup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexion<T> {

    // Datos de conexión
    private static final String USER = "root";
    private static final String PASSWORD = "n0m3l0";
    private static final String DB = "pixup";
    private static final String SERVER = "127.0.0.1";
    private static final String URL = "jdbc:mysql://" + SERVER + ":3306/" + DB;

    protected Connection connection;

    public Conexion() {
    }

    // Abre la conexión
    public boolean openConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida correctamente.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al abrir la conexión: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Cierra la conexión
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Obtiene la conexión actual
    public Connection getConnection() {
        return connection;
    }
}