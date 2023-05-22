package vista;
    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA IMPORTAR 
    * ********************************************
     */
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.util.ArrayList;
import conexion.Conexion;
import controlador.Ctrl_RegistrarVenta;
import controlador.VentaPDF;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;
    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
          
    * ********************************************
     */
public class InterFacturacion extends javax.swing.JInternalFrame {

    //modelo de datos
    private DefaultTableModel modeloDatosProductos;
    //lista para detalle de venta del producto
    ArrayList<DetalleVenta> listaProductos = new ArrayList<>();
    private DetalleVenta producto;

    private int idCliente = 0; //id del cliente

    private int idProducto = 0;
    private String nombre = "";
    private int cantidadProductoBBDD = 0;
    private double precioUnitario = 0.0;
    private int porcentajeIgv = 0;

    private int cantidad = 0; //cantidad de productos a comprar
    private double subtotal = 0.0; //cantidad por precio
    private double descuento = 0.0;
    private double IGV = 0.0;
    private double totalPagar = 0.0;

    //variables para calculo global
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double IgvGeneral = 0.0;
    private double totalPagarGeneral = 0.0;
    //fin variables

    private int auxIdDetalle = 1; //ID
    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
        
    * ********************************************
     */
    public InterFacturacion() {
        initComponents();
        this.setSize(new Dimension(800, 600));
        this.setTitle("Facturación");

        //cargar clientes - cargar productos
        this.CargarComboCliente();
        this.CargarComboProductos();

        this.inicializarTablaProductos();

        txt_efectivo.setEnabled(false);
        jButton_calcular_cambio.setEnabled(false);

        txt_subtotal.setText("0.0");
        txt_iGV.setText("0.0");
        txt_descuento.setText("0.0");
        txt_total_pagar.setText("0");

        ImageIcon wallpaper = new ImageIcon("src/img/fondo2.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 600, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();
    }

    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA EL ENCABEZADO DE LA TABLA
    * ********************************************
     */
    private void inicializarTablaProductos() {
        modeloDatosProductos = new DefaultTableModel();
        //añadir columnas
        modeloDatosProductos.addColumn("N°");
        modeloDatosProductos.addColumn("nombre");
        modeloDatosProductos.addColumn("cantidad");
        modeloDatosProductos.addColumn("P. Unitario");
        modeloDatosProductos.addColumn("Subtotal");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("IGV");
        modeloDatosProductos.addColumn("Total a pagar");
        modeloDatosProductos.addColumn("Accion");
        //pegar dato del modelo tabla
        this.jTable_productos.setModel(modeloDatosProductos);
    }
    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA PRESENTAR LA INFORMACION DE LAS TABLAS 
    * ********************************************
     */
    private void listaTablaProductos() {
        this.modeloDatosProductos.setRowCount(listaProductos.size());
        for (int i = 0; i < listaProductos.size(); i++) {
            this.modeloDatosProductos.setValueAt(i + 1, i, 0);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getNombre(), i, 1);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getCantidad(), i, 2);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getPrecioUnitario(), i, 3);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getSubtotal(), i, 4);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getDescuento(), i, 5);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getIgv(), i, 6);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getTotalPagar(), i, 7);
            this.modeloDatosProductos.setValueAt("Eliminar", i, 8); //poner luego boton de eliminar
        }
        //añadir
        jTable_productos.setModel(modeloDatosProductos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_cliente = new javax.swing.JComboBox<>();
        jComboBox_producto = new javax.swing.JComboBox<>();
        txt_cliente_buscar = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jButton_busca_cliente = new javax.swing.JButton();
        jButton_añadir_producto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_iGV = new javax.swing.JTextField();
        txt_total_pagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        jButton_calcular_cambio = new javax.swing.JButton();
        jButton_RegistrarVenta = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FACTURACIÓN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 80, -1));

        jComboBox_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 170, -1));

        jComboBox_producto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, -1));

        txt_cliente_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cliente_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 150, -1));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 60, -1));

        jButton_busca_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_busca_cliente.setText("Buscar");
        jButton_busca_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_busca_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_busca_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 80, -1));

        jButton_añadir_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_añadir_producto.setText("Agregar producto");
        jButton_añadir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_añadir_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_añadir_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 150, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 760, 210));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Subtotal:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("IGV:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Total a pagar:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Cambio:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_subtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_subtotal.setEnabled(false);
        jPanel2.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 120, -1));

        txt_descuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_descuento.setEnabled(false);
        jPanel2.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 120, -1));

        txt_iGV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_iGV.setEnabled(false);
        jPanel2.add(txt_iGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 120, -1));

        txt_total_pagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total_pagar.setEnabled(false);
        jPanel2.add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 120, -1));

        txt_efectivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 120, -1));

        txt_cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_cambio.setEnabled(false);
        jPanel2.add(txt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 120, -1));

        jButton_calcular_cambio.setBackground(new java.awt.Color(204, 204, 255));
        jButton_calcular_cambio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_calcular_cambio.setText("Calcular cambio");
        jButton_calcular_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcular_cambioActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_calcular_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 130, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 380, 220));

        jButton_RegistrarVenta.setBackground(new java.awt.Color(204, 204, 255));
        jButton_RegistrarVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_RegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrito.png"))); // NOI18N
        jButton_RegistrarVenta.setText("Registrar Venta");
        jButton_RegistrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_RegistrarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_RegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 170, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_clienteActionPerformed

    private void jComboBox_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_productoActionPerformed
    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA BUSCAR CLIENTE
    * ********************************************
     */
    
    private void jButton_busca_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_busca_clienteActionPerformed

        String clienteBuscar = txt_cliente_buscar.getText().trim();
        Connection cn = (Connection) Conexion.conectar();
        String sql = "select nombre, apellido from tb_cliente where DNI = '" + clienteBuscar + "'";
        Statement st;
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                jComboBox_cliente.setSelectedItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            } else {
                jComboBox_cliente.setSelectedItem("Seleccione cliente:");
                JOptionPane.showMessageDialog(null, "¡DNI de cliente incorrecta!");
            }
            txt_cliente_buscar.setText("");
            cn.close();
        } catch (SQLException e) {
            System.out.println("!Error al buscar cliente!, " + e);
        }
    }//GEN-LAST:event_jButton_busca_clienteActionPerformed
    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA AÑADIR PRODUCTO
    * ********************************************
     */
    
    private void jButton_añadir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_añadir_productoActionPerformed

        String combo = this.jComboBox_producto.getSelectedItem().toString();
        //validar seleccion de producto
        if (combo.equalsIgnoreCase("Seleccione producto:")) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un producto!");
        } else {
            //valida que ingrese cantidad
            if (!txt_cantidad.getText().isEmpty()) {
                //validad que el usuario no ingrese caracteres no numéricos
                boolean validacion = validar(txt_cantidad.getText());
                if (validacion == true) {
                    //validar cantidad sea mayor a 0
                    if (Integer.parseInt(txt_cantidad.getText()) > 0) {
                        cantidad = Integer.parseInt(txt_cantidad.getText());
                        //ejecutar metodo para obtener datos de productos
                        this.DatosDelProducto();
                        //validar cantidad de producto seleccionado no sea mayor al stock de bd
                        if (cantidad <= cantidadProductoBBDD) {

                            subtotal = precioUnitario * cantidad;
                            totalPagar = subtotal + IGV + descuento;
                            //redondear
                            subtotal = (double) Math.round(subtotal * 100) / 100;
                            IGV = (double) Math.round(IGV * 100) / 100;
                            descuento = (double) Math.round(descuento * 100) / 100;
                            totalPagar = (double) Math.round(totalPagar * 100) / 100;

                            //se crea un nuevo producto
                            producto = new DetalleVenta(auxIdDetalle,
                                    1, //idCabecera
                                    idProducto, nombre, Integer.parseInt(txt_cantidad.getText()),
                                    precioUnitario,
                                    subtotal,
                                    descuento,
                                    IGV,
                                    totalPagar,
                                    1);
                            //añadir a la lista
                            listaProductos.add(producto);
                            JOptionPane.showMessageDialog(null, "Producto agregado");
                            auxIdDetalle++;
                            txt_cantidad.setText("");//limpiar el campo
                            //volver a cargar combo productos
                            this.CargarComboProductos();
                            this.CalcularTotalPagar();
                            txt_efectivo.setEnabled(true);
                            jButton_calcular_cambio.setEnabled(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "La cantidad supera el stock");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No puede ser 0 ni negativa");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se permiten caracteres no numéricos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad de productos");
            }
        }
        //llamar metodo
        this.listaTablaProductos();
    }//GEN-LAST:event_jButton_añadir_productoActionPerformed
    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA CALCULAR EL CAMBIO
    * ********************************************
     */
    
    private void jButton_calcular_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcular_cambioActionPerformed
        if (!txt_efectivo.getText().isEmpty()) {
            //validar que el usuario no ingrese otros caracteres no numericos
            boolean validacion = validarDouble(txt_efectivo.getText());
            if (validacion == true) {
                //validar efectivo sea mayor a 0
                double efc = Double.parseDouble(txt_efectivo.getText().trim());
                double top = Double.parseDouble(txt_total_pagar.getText().trim());
                if (efc < top) {
                    JOptionPane.showMessageDialog(null, "Dinero en efecto no es suficiente");
                } else {
                    Double cambio = (efc - top);
                    double cambi = (double) Math.round(cambio * 100d) / 100;
                    String camb = String.valueOf(cambi);
                    txt_cambio.setText(camb);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se admiten caracteres no numéricos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero en efectivo");
        }
    }//GEN-LAST:event_jButton_calcular_cambioActionPerformed
    int idArrayList = 0;
        /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA ELIMAR PRODUCTO DE LA TABLA
    * ********************************************
     */
    
    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked
        int fila_point = jTable_productos.rowAtPoint(evt.getPoint());
        int columna_point = 0;
        if (fila_point > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(fila_point, columna_point);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Eliminar producto?");
        //opciones de confirmar dialog = (si = 0 ; no= 1 ; cancel = 2; close = -1)
        switch (opcion) {
            case 0: //presione si
                listaProductos.remove(idArrayList - 1);
                this.CalcularTotalPagar();
                this.listaTablaProductos();
                break;
            case 1: //presione no
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jTable_productosMouseClicked
    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA REGISTAR VENTA
    * ********************************************
     */
   
    private void jButton_RegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarVentaActionPerformed

        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        DetalleVenta detalleVenta = new DetalleVenta();
        Ctrl_RegistrarVenta controlVenta = new Ctrl_RegistrarVenta();

        String fechaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);

        if (!jComboBox_cliente.getSelectedItem().equals("Seleccione cliente:")) {
            if (listaProductos.size() > 0) {
                //metodo para obtener id de cliente
                this.ObtenerIdCliente();
                //registrar cabecera venta
                cabeceraVenta.setIdCabeceraventa(0);
                cabeceraVenta.setIdCliente(idCliente);
                cabeceraVenta.setValorPagar(Double.parseDouble(txt_total_pagar.getText()));
                cabeceraVenta.setFechaVenta(fechaActual);
                cabeceraVenta.setEstado(1);
                if (controlVenta.guardar(cabeceraVenta)) {
                    JOptionPane.showMessageDialog(null, "¡Venta registrada!");
                    //generar la factura
                    VentaPDF pdf = new VentaPDF();
                    pdf.DatosCliente(idCliente);
                    pdf.generarFacturaPDF();
                    //guardar detalle
                    for (DetalleVenta elemento : listaProductos) {
                        detalleVenta.setIdDetalleVenta(0);
                        detalleVenta.setIdCabeceraVenta(0);
                        detalleVenta.setIdProducto(elemento.getIdProducto());
                        detalleVenta.setCantidad(elemento.getCantidad());
                        detalleVenta.setPrecioUnitario(elemento.getPrecioUnitario());
                        detalleVenta.setSubtotal(elemento.getSubtotal());
                        detalleVenta.setDescuento(elemento.getDescuento());
                        detalleVenta.setIgv(elemento.getIgv());
                        detalleVenta.setTotalPagar(elemento.getTotalPagar());
                        detalleVenta.setEstado(1);

                        if (controlVenta.guardarDetalle(detalleVenta)) {
                            //System.out.println("Detalle de venta registrada");
                            
                            txt_subtotal.setText("0.0");
                            txt_iGV.setText("0.0");
                            txt_descuento.setText("0.0");
                            txt_total_pagar.setText("0.0");
                            txt_efectivo.setText("0.0");
                            txt_cambio.setText("0.0");
                            auxIdDetalle = 1;
                            
                            this.CargarComboCliente();
                            this.RestarStockProductos(elemento.getIdProducto(), elemento.getCantidad());
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al guardar Detalle de venta");
                        }
                    }
                    //vaciamos la lista
                    listaProductos.clear();
                    listaTablaProductos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar cabecera");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un producto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente");
        }

    }//GEN-LAST:event_jButton_RegistrarVentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_RegistrarVenta;
    private javax.swing.JButton jButton_añadir_producto;
    private javax.swing.JButton jButton_busca_cliente;
    private javax.swing.JButton jButton_calcular_cambio;
    private javax.swing.JComboBox<String> jComboBox_cliente;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cliente_buscar;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_iGV;
    private javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables

    // método para cargar cliente
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

    /*Cargar productos*/
    private void CargarComboProductos() {
        Connection cn = (Connection) Conexion.conectar();
        String sql = "select * from tb_producto";
        Statement st;
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_producto.removeAllItems();
            jComboBox_producto.addItem("Seleccione producto:");
            while (rs.next()) {
                jComboBox_producto.addItem(rs.getString("nombre"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("!Error al cargar productos, !" + e);
        }
    }

    /*metodo para validar que usuario no ingrese caracteres no numericos*/
    private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("");
            return false;
        }
    }

    /*metodo para validar que usuario no ingrese caracteres no numericos*/
    private boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("");
            return false;
        }
    }

    /*metodo para mostrar datos del producto*/
    private void DatosDelProducto() {
        try {
            String sql = "select * from tb_producto where nombre = '" + this.jComboBox_producto.getSelectedItem() + "'";
            Connection cn = (Connection) Conexion.conectar();
            Statement st;
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idProducto = rs.getInt("IdProducto");
                nombre = rs.getString("nombre");
                cantidadProductoBBDD = rs.getInt("cantidad");
                precioUnitario = rs.getDouble("precio");
                porcentajeIgv = rs.getInt("porcentajeIva");
                this.CalcularIgv(precioUnitario, porcentajeIgv); //calcula y retorna Iva
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto" + e);
        }
    }

    /*metodo para calcular Iva*/
    private double CalcularIgv(double precio, int porcentajeIva) {
        int p_igv = porcentajeIva;
        switch (p_igv) {
            case 0:
                IGV = 0.0;
                break;
            case 18:
                IGV = (precio * cantidad) * 0.18;
                break;
            default:
                break;
        }
        return IGV;
    }

    //metodo para calcular total a pagar todos los productos
    private void CalcularTotalPagar() {
        subtotalGeneral = 0;
        descuentoGeneral = 0;
        IgvGeneral = 0;
        totalPagarGeneral = 0;

        for (DetalleVenta elemento : listaProductos) {
            subtotalGeneral += elemento.getSubtotal();
            descuentoGeneral += elemento.getDescuento();
            IgvGeneral += elemento.getIgv();
            totalPagarGeneral += elemento.getTotalPagar();
        }
        //redondear
        subtotalGeneral = (double) Math.round(subtotalGeneral * 100) / 100;
        IgvGeneral = (double) Math.round(IgvGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        totalPagarGeneral = (double) Math.round(totalPagarGeneral * 100) / 100;

        //enviar datos a la vista
        txt_subtotal.setText(String.valueOf(subtotalGeneral));
        txt_iGV.setText(String.valueOf(IgvGeneral));
        txt_descuento.setText(String.valueOf(descuentoGeneral));
        txt_total_pagar.setText(String.valueOf(totalPagarGeneral));
    }

    //método para obtener id del cliente
    private void ObtenerIdCliente() {
        try {
            String sql = "select * from tb_cliente where concat(nombre, ' ', apellido) = '" + this.jComboBox_cliente.getSelectedItem() + "'";
            Connection cn = (Connection) Conexion.conectar();
            Statement st;
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idCliente = rs.getInt("IdCliente");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener id del cliente, " + e);
        }
    }
    //metodo para restar cantidad vendida en stock
    private void RestarStockProductos(int idProducto, int cantidad){
        int cantidadProductosBaseDeDatos = 0;
        try {
            Connection cn = (Connection) Conexion.conectar();
            String sql="select IdProducto, cantidad from tb_producto where IdProducto = '" +idProducto+ "'";
            Statement st;
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                cantidadProductosBaseDeDatos = rs.getInt("cantidad");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad, " + e);
        }
        try {
            Connection cn = (Connection) Conexion.conectar();
            PreparedStatement consulta = (PreparedStatement) cn.prepareStatement("update tb_producto set cantidad=? where IdProducto= '"+idProducto+"'");
            int cantidadNueva = cantidadProductosBaseDeDatos - cantidad;
            consulta.setInt(1, cantidadNueva);
            if(consulta.executeUpdate() > 0){
                System.out.println("Se actualizó correectamente");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 2, " +e);
        }
    }
}
