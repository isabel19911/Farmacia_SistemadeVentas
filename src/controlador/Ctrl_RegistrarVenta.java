package controlador;
    /*
    * ********************************************
            AUTOR: ZARPAN JOEL
            MÉTODO PARA IMPORTAR 
    * ********************************************
     */
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.CabeceraVenta;
import java.sql.ResultSet;
import modelo.DetalleVenta;

public class Ctrl_RegistrarVenta {
    //ultimo id de la cabecera
    public static int idCabeceraRegistrada;
    java.math.BigDecimal iDColVar;
    /*
    * *******************************************
        AUTOR:JOEL ZARPAN
        MÉTODO PARA GUARDAR LA CABECERA DE VENTA
    * *******************************************
     */
    public boolean guardar(CabeceraVenta objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_Cabecera_venta values (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, 0); //id
            consulta.setInt(2, objeto.getIdCliente());
            consulta.setDouble(3, objeto.getValorPagar());
            consulta.setString(4, objeto.getFechaVenta());
            consulta.setInt(5, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            
            ResultSet rs = consulta.getGeneratedKeys();
            while(rs.next()){
                iDColVar= rs.getBigDecimal(1);
                idCabeceraRegistrada = iDColVar.intValue();
            }
            
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar cabecera de venta" + e);
        }
        return respuesta;
    }
    
    /*
    * ***************************************
        AUTOR:JOEL ZARPAN
        MÉTODO PARA GUARDAR DETALLE DE VENTA
    * ****************************************
     */
    public boolean guardarDetalle(DetalleVenta objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_detalle_venta values "
                    + "(?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0); //id
            consulta.setInt(2, idCabeceraRegistrada);
            consulta.setInt(3, objeto.getIdProducto());
            consulta.setInt(4, objeto.getCantidad());
            consulta.setDouble(5, objeto.getPrecioUnitario());
            consulta.setDouble(6, objeto.getSubtotal());
            consulta.setDouble(7, objeto.getDescuento());
            consulta.setDouble(8, objeto.getIgv());
            consulta.setDouble(9, objeto.getTotalPagar());
            consulta.setInt(10, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar detalle de venta" + e);
        }
        return respuesta;
    }
    
            /*
    * ********************************************
            AUTOR:JOEL ZARPAN
            MÉTODO PARA ACTUALIZAR PRODUCTO
    * ********************************************
     */
    public boolean actualizar(CabeceraVenta objeto, int idCabeceraVenta) {
        boolean respuesta = false;
        java.sql.Connection cn = Conexion.conectar();
        try {
            java.sql.PreparedStatement consulta = cn.prepareStatement(
                    "update tb_Cabecera_venta set IdCliente =?, estado = ? "
                            + "where IdCabeceraVenta= '" + idCabeceraVenta + "'");
            consulta.setInt(1, objeto.getIdCliente());
            consulta.setInt(2, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cabecera de venta" + e);
        }
        return respuesta;
    }
}
