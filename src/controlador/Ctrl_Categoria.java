package controlador;
    /*
    * ********************************************
            AUTOR: ROY MIRANDA
            MÉTODO PARA IMPORTAR 
    * ********************************************
     */
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import java.sql.Connection;
import modelo.Categoria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Ctrl_Categoria {
        /*
    * ************************************s
        AUTOR: ROY MIRANDA
        MÉTODO PARA GUARDAR NUEVO CLIENTE
    * ************************************
     */

    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria values (?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar categoría" + e);
        }
        return respuesta;
    }
    /*
    * ************************************************************
        AUTOR: ROY MIRANDA
        MÉTODO PARA CONSULTAR SI EL PRODUCTO YA EXISTE EN LA BD
    * ************************************************************
     */
    public boolean existeCategoria(String categoria) {
        boolean respuesta = false;
        String sql = "select descripcion from tb_categoria where descripcion = '" + categoria + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar categoría" + e);
        }
        return respuesta;
    }
        /*
    * ********************************************
            AUTOR: ROY MIRANDA
            MÉTODO PARA ACTUALIZAR CLIENTE
    * ********************************************
     */
    public boolean actualizar(Categoria objeto, int idCategoria) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_categoria set descripcion=? where idCategoria= '"+idCategoria+"'");
            consulta.setString(1, objeto.getDescripcion());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar categoría" + e);
        }
        return respuesta;
    }
        /*
    * ********************************************
            AUTOR: ROY MIRANDA
            MÉTODO PARA ELIMINAR CLIENTE
    * ********************************************
     */
    public boolean eliminar(int idCategoria) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_categoria where idCategoria ='" + idCategoria + "'");
            consulta.executeUpdate();
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar categoría" + e);
        }
        return respuesta;
    }
}
