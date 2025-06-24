package org.gerdoc.pixup.jdbc.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/eufolkia";
        String user = "root";
        String password = "n0m3l0";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("¡Conexión exitosa!");
        } catch (Exception e) {
            System.out.println("Error al conectar:");
            e.printStackTrace();
        }
    }
}

