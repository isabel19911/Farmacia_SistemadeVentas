package modelo;
    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA CREAR ATRIBUTOS DE LOS PRODUCTOS
    * ********************************************
     */
public class Producto {
   
    private int IdProducto;
    private String nombre;
    private int cantidad;
    private double precio;
    private String descripcion;
    private int porcentajeIgv;
    private int IdCategoria;
    private int estado;
    
       /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA CONSTRUCTOR DE LOS PRODUCTOS
    * ********************************************
     */
    public Producto(){
        this.IdProducto = 0;
        this.nombre = "";
        this.cantidad = 0;
        this.precio = 0.0;
        this.descripcion = "";
        this.porcentajeIgv = 0;
        this.IdCategoria = 0;
        this.estado = 0;
             
    }
    /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA CONSTRUCTOR SOBRECARGADO DE LOS PRODUCTOS
    * ********************************************
     */
    public Producto(int IdProducto, String nombre, int cantidad, double precio, String descripcion, int porcentajeIgv, int IdCategoria, int estado) {
        this.IdProducto = IdProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.porcentajeIgv = porcentajeIgv;
        this.IdCategoria = IdCategoria;
        this.estado = estado;
    }
      /*
    * ********************************************
            AUTOR: ISABEL HUAMAN
            MÉTODO PARA GET Y SET DE LOS PRODUCTOS
    * ********************************************
     */
    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPorcentajeIgv() {
        return porcentajeIgv;
    }

    public void setPorcentajeIgv(int porcentajeIgv) {
        this.porcentajeIgv = porcentajeIgv;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
}
