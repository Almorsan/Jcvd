/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.jcvd;

import java.sql.*;

public class resultado {
    //DATOS DE LA CONEXIÓN DE LA BASE DE DATOS
    //los declaramos fuera del método main
    //ya que son constantes (static)

    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd"; //dirección de nuestra base de datos
    static final String USER = "alejandro"; //nuestro usuario de la base de datos
    static final String PASS = "1234"; //nuestra contraseña
    static final String QUERY = "SELECT * FROM videojuegos"; //seleccionamos todos los videojuegos de nuestra base de datos
    static final String QUERY2 = "INSERT INTO `videojuegos` (`id`, `Nombre`, `Categoría`, `Fecha_lanzamiento`,"
            + " `Compañía`, `Precio`) VALUES (NULL, 'prueba', 'prueba', '2023-11-27', 'prueba', '2.22')";
    //insertamos valores de prueba en la base de datos
    static final String QUERY3 = "DELETE FROM videojuegos WHERE id=7"; //borramos de la base de datos
    //donde coincida el id

    public static void main(String[] args) {
        //utilizamos las clases Connection, Statement y ResultSet para
        //mandar y recibir consultas de la base de datos
        //es importante distinguir entre executeQuery (cuando queremos
        //consultar información) y executeUpdate
        //(cuando queremos actualizarla

        try ( Connection conexion = DriverManager.getConnection(DB_URL, USER, PASS);  Statement sentencia = conexion.createStatement();  ResultSet resultado = sentencia.executeQuery(QUERY);) {

            while (resultado.next()) { //mientras que se lean datos de la base de datos
                System.out.println("ID: " + resultado.getInt("id"));
                System.out.println("Nombre: " + resultado.getString("Nombre"));
                System.out.println("Categoría: " + resultado.getString("Categoría"));
                System.out.println("Fecha Lanzamiento: " + resultado.getDate("Fecha_lanzamiento"));
                System.out.println("Compañía: " + resultado.getString("Compañía"));
                System.out.println("Precio: " + resultado.getFloat("Precio"));
                System.out.println("");

            }
            int filasAfectadas = sentencia.executeUpdate(QUERY3); //ejecutamos la query para borrar información
            if (filasAfectadas > 0) {
                System.out.println("Borrada con éxito");
            } else {
                System.out.println("No se ha podido borrar");
            }

            sentencia.close(); //cerramos la conexión

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
