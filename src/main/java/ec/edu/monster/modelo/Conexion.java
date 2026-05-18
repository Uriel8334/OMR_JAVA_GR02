/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author enriqueo
 */
public class Conexion {
    // URL de conexión apuntando a tu base de datos local
    private static final String URL = "jdbc:mysql://localhost:3306/GESTION_PROYECTOS_MONSTER?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "170702Enrique";
    
    public static Connection conectar() {
        Connection conn = null;
        try {
            // Registrar explícitamente el driver de MySQL (esencial en aplicaciones web antiguas/tradicionales)
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
        }
        return conn;
    }
    
}
