package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * AR-001
 * @Author Andrés Alvarado Matamoros
 * Se administra la conexion de oracle para la base de datos.
 * Esta clase provee un metodo para establecer la conexion de oracle usando
 * JDBC Driver,URL, username y password.
 */
public class ConnectionDA {
    private Connection con;
    private final String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //  URL of full connection.
    private final String user = "ARTAVIARACING"; // User of connection.
    private final String password = "12345"; //Contraseña of connection.
   /**
    * AR-001
    * @Author Andrés Alvarado Matamoros
     * Establishes a connection to the Oracle Database.
     * @return Connection object if connection is successful, otherwise null.
     */
    public Connection Get() {
        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Establish the connection using DriverManager
            con = DriverManager.getConnection(url, user, password);
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
        return con;
    }
}
