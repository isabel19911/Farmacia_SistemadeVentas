package controlador;
    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA IMPORTAR 
    * ********************************************
     */
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cliente;
import modelo.Producto;
public class Ctrl_Cliente {

    /*
    * ************************************s
        AUTOR: ISABEL HUAMAN
        MÉTODO PARA GUARDAR NUEVO CLIENTE
    * ************************************
     */
    public boolean guardar(Cliente objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_cliente values (?,?,?,?,?,?,?)");
            consulta.setInt(1, 0); //id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getDni());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar cliente" + e);
        }
        return respuesta;
    }

    /*
    * ************************************************************
        AUTOR: ISABEL HUAMAN
        MÉTODO PARA CONSULTAR SI EL PRODUCTO YA EXISTE EN LA BD
    * ************************************************************
     */
    public boolean existeCliente(String dni) {
        boolean respuesta = false;
        String sql = "select DNI from tb_cliente where DNI = '" + dni + "';";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar cliente" + e);
        }
        return respuesta;
    }

    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA ACTUALIZAR CLIENTE
    * ********************************************
     */
    public boolean actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "update tb_cliente set nombre =?, apellido=?, DNI=?, telefono =?, direccion=?, estado= ? where IdCliente= '" + idCliente + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getDni());
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setInt(6, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente" + e);
        }
        return respuesta;
    }

    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA ELIMINAR CLIENTE
    * ********************************************
     */
    public boolean eliminar(int idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_cliente where IdCliente ='" + idCliente + "'");
            consulta.executeUpdate();
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente" + e);
        }
        return respuesta;
    }

}
