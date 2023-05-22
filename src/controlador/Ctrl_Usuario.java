package controlador;
    /*
    * ********************************************
            AUTOR: ZARPAN JOEL
            MÉTODO PARA IMPORTAR 
    * ********************************************
     */
import java.sql.Connection;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Usuario;
import java.sql.ResultSet;
import modelo.Cliente;

public class Ctrl_Usuario {
    /*
    * **************************************
         AUTOR: ZARPAN JOEL
        MÉTODO PARA GUARDAR NUEVO USUARIO
    * **************************************
     */
    public boolean guardar(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_usuario values (?,?,?,?,?,?,?)");
            consulta.setInt(1, 0); //id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getUsuario());
            consulta.setString(5, objeto.getPassword());
            consulta.setString(6, objeto.getTelefono());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario" + e);
        }
        return respuesta;
    }

    /*
    * ************************************************************
         AUTOR: ZARPAN JOEL
        MÉTODO PARA CONSULTAR SI EL PRODUCTO YA EXISTE EN LA BD
    * ************************************************************
     */
    public boolean existeUsuario(String usuario) {
        boolean respuesta = false;
        String sql = "select usuario from tb_usuario where usuario = '" + usuario + "';";
        com.mysql.jdbc.Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = (com.mysql.jdbc.Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario" + e);
        }
        return respuesta;
    }
    /*
    * ********************************************
            AUTOR: ZARPAN JOEL
            MÉTODO PARA INICIAR SESION 
    * ********************************************
     */
    public boolean loginUser(Usuario objeto) {

        boolean respuesta = false;

        Connection cn = Conexion.conectar();
        String sql = "select usuario, password from tb_usuario where usuario = '" + objeto.getUsuario() + "' and password= '" + objeto.getPassword() + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesion");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
        }
        return respuesta;
    }
    
    /*
    * ********************************************
            AUTOR: ZARPAN JOEL
            MÉTODO PARA ACTUALIZAR USUARIO
    * ********************************************
     */
    public boolean actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "update tb_usuario set nombre =?, apellido=?, usuario=?, password =?, telefono=?, estado= ? where IdUsuario= '" + idUsuario + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getUsuario());
            consulta.setString(4, objeto.getPassword());
            consulta.setString(5, objeto.getTelefono());
            consulta.setInt(6, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario" + e);
        }
        return respuesta;
    }

    /*
    * ********************************************
             AUTOR: ZARPAN JOEL
            MÉTODO PARA ELIMINAR USUARIO
    * ********************************************
     */
    public boolean eliminar(int idUsario) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_usuario where IdUsuario ='" + idUsario + "'");
            consulta.executeUpdate();
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario" + e);
        }
        return respuesta;
    }


}
