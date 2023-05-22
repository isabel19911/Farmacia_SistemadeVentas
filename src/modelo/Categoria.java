package modelo;

public class Categoria {
    /*
    * ********************************************
            AUTOR: ROY MIRANDA
            MÉTODO PARA CREAR ATRIBUTOS
    * ********************************************
     */
    private int idCategoria;
    private String descripcion;
    private int estado;
       /*
    * ********************************************
            AUTOR: ROY MIRANDA
            MÉTODO PARA CONSTRUCTOR DE CLIENTE
    * ********************************************
     */
    public Categoria() {
        this.idCategoria = 0;
        this.descripcion = "";
        this.estado = 0;
    }
    /*
    * ********************************************
            AUTOR: ROY MIRANDA
            MÉTODO PARA CONSTRCUTOR SOBRECARGADO DE CLIENTE
    * ********************************************
     */
    public Categoria(int idCategoria, String descripcion, int estado) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.estado = estado;
    }
      /*
    * ********************************************
            AUTOR:ROY MIRANDA
            MÉTODO PARA GET Y SET DE CLIENTE
    * ********************************************
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
