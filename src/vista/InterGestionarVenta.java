package vista;
    /*
    * ********************************************
            AUTOR:JOEL ZARPAN
            MÉTODO PARA IMPORTAR 
    * ********************************************
     */
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import controlador.Ctrl_RegistrarVenta;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.CabeceraVenta;
import modelo.Producto;

public class InterGestionarVenta extends javax.swing.JInternalFrame {

    private int idCliente = 0;
    private int idVenta;

    public InterGestionarVenta() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Ventas");

        this.CargarComboCliente();
        this.CargarTablaVentas();

    /*
    * ********************************************
            AUTOR:JOEL ZARPAN
            MÉTODO PARA INSERTAR IMAGEN EN JLABEL
    * ********************************************
     */
        ImageIcon wallpaper = new ImageIcon("src/img/fondo2.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ventas = new javax.swing.JTable();
        jButton_actualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_total_pagar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        jComboBox_cliente = new javax.swing.JComboBox<>();
        jComboBox_estado = new javax.swing.JComboBox<>();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Administrar Ventas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_ventas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jButton_actualizar.setBackground(new java.awt.Color(204, 255, 255));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, 110, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Total Pagar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 90, -1));

        txt_total_pagar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_total_pagar.setEnabled(false);
        txt_total_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_pagarActionPerformed(evt);
            }
        });
        getContentPane().add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cliente:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Estado");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 90, -1));

        txt_fecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_fecha.setEnabled(false);
        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 170, -1));

        jComboBox_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 170, -1));

        jComboBox_estado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jComboBox_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_estadoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 170, -1));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /* ********************************************
            AUTOR:JOEL ZARPAN
            MÉTODO PARA ACTUALIZAR DATOS DE LAS VENTAS
    * ********************************************
     */
    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        
        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        Ctrl_RegistrarVenta controlRegistrarVenta = new Ctrl_RegistrarVenta();
        String cliente, estado;
        cliente = jComboBox_cliente.getSelectedItem().toString().trim();
        estado = jComboBox_estado.getSelectedItem().toString().trim();
        //obtener cliente
        try {
           Connection cn = (Connection) Conexion.conectar();
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(
                    "select IdCliente, concat(nombre,' ', apellido) as cliente from tb_cliente "
                            + "where concat(nombre,' ', apellido) = '"+ cliente + "'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                idCliente = rs.getInt("IdCliente");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar id del cliente "+ e);
        }
       

        if(!cliente.equalsIgnoreCase("Seleccione cliente:")){
            cabeceraVenta.setIdCliente(idCliente);
            if(estado.equalsIgnoreCase("Activo")){
                cabeceraVenta.setEstado(1);
            }else{
                cabeceraVenta.setEstado(0);
            }
            if(controlRegistrarVenta.actualizar(cabeceraVenta, idVenta)){
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                this.CargarTablaVentas();
                this.Limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione registro para actualiza datos");
        }

    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void txt_total_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_pagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_pagarActionPerformed

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaActionPerformed

    private void jComboBox_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_clienteActionPerformed

    private void jComboBox_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_estadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JComboBox<String> jComboBox_cliente;
    private javax.swing.JComboBox<String> jComboBox_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_ventas;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables

    /*
    * ***********************************************************
         AUTOR:JOEL ZARPAN
    *    METODO PARA LIMPIAR
    * ***********************************************************
     */
    private void Limpiar() {
        this.txt_total_pagar.setText("");
        this.txt_fecha.setText("");
        this.jComboBox_cliente.setSelectedItem("Seleccione cliente:");
        this.jComboBox_estado.setSelectedItem("Activo");
        idCliente = 0;

    }

    /*
    * ***********************************************************
         AUTOR:JOEL ZARPAN
    *    METODO PARA MOSTRAR LAS VENTAS REGISTRADAS
    * ***********************************************************
     */
    private void CargarTablaVentas() {
        Connection con = (Connection) Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select cv.IdCabeceraVenta as id, concat(c.nombre, '', c.apellido) as cliente, "
                + "cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado from tb_Cabecera_venta as "
                + "cv, tb_cliente as c where cv.IdCliente = c.IdCliente";
        Statement st;

        try {
            st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarVenta.jTable_ventas = new JTable(model);
            InterGestionarVenta.jScrollPane1.setViewportView(InterGestionarVenta.jTable_ventas);

            model.addColumn("N°"); //ID
            model.addColumn("Cliente");
            model.addColumn("Total Pagar");
            model.addColumn("Fecha Venta");
            model.addColumn("estado");

            while (rs.next()) {
                Object fila[] = new Object[5];
                for (int i = 0; i < 5; i++) {
                    if (i == 4) {
                        String estado = String.valueOf(rs.getObject(i + 1));
                        if (estado.equalsIgnoreCase("1")) {
                            fila[i] = "Activo";
                        } else {
                            fila[i] = "Inactivo";
                        }
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }

                }
                model.addRow(fila);
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de ventas:" + e);
        }

        jTable_ventas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_ventas.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idVenta = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosVentaSeleccionada(idVenta); //metodo
                }
            }
        });

    }
   /*
    * ********************************************
            AUTOR:JOEL ZARPAN
            MÉTODO PARA ENVIAR DATOS DE LA VENTA SELECCIONA
    * ********************************************
     */
    private void EnviarDatosVentaSeleccionada(int idVenta) {
        try {
            Connection con = (Connection) Conexion.conectar();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(
                    "select cv.IdCabeceraVenta, cv.IdCliente, concat(c.nombre,' ', c.apellido) as cliente, "
                    + "cv.valorPagar, cv.fechaVenta, cv.estado from tb_Cabecera_venta as cv, tb_cliente as c "
                    + "where cv.IdCabeceraVenta = '" + idVenta + "' and cv.IdCliente = c.IdCliente;");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jComboBox_cliente.setSelectedItem(rs.getString("cliente"));
                txt_total_pagar.setText(rs.getString("valorPagar"));
                txt_fecha.setText(rs.getString("fechaVenta"));
                int estado = rs.getInt("estado");
                if (estado == 1) {
                    jComboBox_estado.setSelectedItem("Activo");
                } else {
                    jComboBox_estado.setSelectedItem("Inactivo");
                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar venta: " + e);
        }
    }
            /*
    * ********************************************
            AUTOR:JOEL ZARPAN
            MÉTODO PARA CARGAR CLIENTE
    * ********************************************
     */

    private void CargarComboCliente() {
        Connection cn = (Connection) Conexion.conectar();
        String sql = "select * from tb_cliente";
        Statement st;

        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_cliente.removeAllItems();
            jComboBox_cliente.addItem("Seleccione cliente:");
            while (rs.next()) {
                jComboBox_cliente.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("!Error al cargar clientes, !" + e);
        }
    }

}
