/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.jcvd;

import java.sql.*;

public class Jcvd {
    //DATOS DE LA CONEXIÓN DE LA BASE DE DATOS

    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
    static final String USER = "alejandro";
    static final String PASS = "1234";
    static final String QUERY = "SELECT * FROM videojuegos";
    static final String QUERY2 = "INSERT INTO `videojuegos` (`id`, `Nombre`, `Categoría`, `Fecha_lanzamiento`, `Compañía`, `Precio`) VALUES (NULL, 'prueba', 'prueba', '2023-11-27', 'prueba', '2.22')";
    static final String QUERY3 = "DELETE FROM videojuegos WHERE id=7";

    public static void main(String[] args) {
        /*
        
     final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
     final String USER = "alejandro";
     final String PASS = "1234";
     final String QUERY = "SELECT * FROM videojuegos";
     final String QUERY2 = "INSERT INTO `videojuegos` (`id`, `Nombre`, `Categoría`, `Fecha_lanzamiento`, `Compañía`, `Precio`) VALUES (NULL, 'prueba', 'prueba', '2023-11-27', 'prueba', '2.22')";
     final String QUERY3="DELETE FROM videojuegos WHERE id=7";

         */

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(QUERY);) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Categoría: " + rs.getString("Categoría"));
                System.out.println("Fecha Lanzamiento: " + rs.getDate("Fecha_lanzamiento"));
                System.out.println("Compañía: " + rs.getString("Compañía"));
                System.out.println("Precio: " + rs.getFloat("Precio"));
                System.out.println("");

            }
            int rowsAffected = stmt.executeUpdate(QUERY3);
            if (rowsAffected > 0) {
                System.out.println("Borrada con éxtio");
            } else {
                System.out.println("No se ha podido borrar");
            }

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
