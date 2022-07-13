
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //1. Crear instancia de la clase Connection
    Connection connection;
    //Atirbutos
    String driver = "com.mysql.cj.jdbc.Driver";
    String cadenaConexion = "jdbc:mysql://localhost:3306/reto1_g53_db";
    String usuario = "root";
    String contraseña = "";
//2. Añadir el contructor sin args de la clase

    public Conexion() {
        //3. Intentar conectar con la base de datos
        try{
        Class.forName(driver);
        connection = DriverManager.getConnection(cadenaConexion,usuario, contraseña);
        //4. Verificar si la conexion devuelve algo
        if(connection != null){
            System.out.println("Conexion exitosa con la base de datos");
        }
        
    } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se puedo establecer conexion con la base de datos");
    }  
    }
        //5.Crear una funcion que retorne la clase Connection
       public Connection getConnection(){
        return connection;
    }
}
    