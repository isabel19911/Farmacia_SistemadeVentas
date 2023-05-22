package conexion;
    /*
    * ********************************************
            AUTOR: ZARPAN JOEL
            MÉTODO PARA IMPORTAR 
    * ********************************************
     */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
    /*
    * ********************************************
            AUTOR: ZARPAN JOEL
            MÉTODO PARA LA CONEXION LOCAL
    * ********************************************
     */
public class Conexion {


    public static Connection conectar() {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/db_farmacia", "root", "root*");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexión local " + e);
        }
        return null;
    }
}
