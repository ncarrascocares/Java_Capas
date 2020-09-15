
package datos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    //Declaracion de constantes para nuestra conexion
    //nombre de la base de datos
    private final String BASE = "empresa";
    //nombre del usuario de la base de datos
    private final String USER = "root";
    //password para el ingreso a la base de datos
    private final String PASSWORD = "admin";
    //ruta para la base de datos
    private final String URL = "jdbc:mysql://localhost:3306/" + BASE;
    //Variable para obtener la conexion y la guardara para luego retornarla 
    private Connection con = null;
    
    //metodo de tipo publico, de tipo connection y no recibira ningun datos
    public Connection getConexion(){
        
        //Creacion de nuestra conexion
        try {
            //ruta del driver, este es el controlador para realizar la conexión
            Class.forName("com.mysql.jdbc.Driver");
            //En esta linea igualamos la variable con la conexion
            con = (Connection) DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
            
        } catch (SQLException e) {
            
            System.err.println(e);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}
