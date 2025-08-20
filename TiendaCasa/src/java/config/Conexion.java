/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {
    Connection conexion;

    public Connection Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/DBTiendaCasa?useSSL=false&allowPublicKeyRetrieval=true";
            String user = "root";
            String password = "admin";
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a DBTiendaCasa a las " + new java.util.Date());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver no encontrado - " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }
}
