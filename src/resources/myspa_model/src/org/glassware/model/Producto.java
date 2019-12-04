
package org.glassware.model;

/**
 *
 * @author ximena Uribe
 */
public class Producto {
    private int idProducto;
    private String nombre;
    private String marca;
    private int estatus;
    private float  precioUso;

    public Producto(String nombre, String marca, float precioUso) {
        this.nombre = nombre;
        this.marca = marca;
        this.precioUso = precioUso;
    }
    
    
    public Producto(int id, String nombre, String marca, int estatus, float precioUso) {
        this.idProducto = id;
        this.nombre = nombre;
        this.marca = marca;
        this.estatus = estatus;
        this.precioUso = precioUso;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int id) {
        this.idProducto = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public float getPrecioUso() {
        return precioUso;
    }

    public void setPrecioUso(float precioUso) {
        this.precioUso = precioUso;
    }
    @Override
    public String toString() {
        return "Producto{" + "id=" + idProducto + ", nombre=" + nombre + ", marca=" + marca + ", estatus=" + estatus + ", precioUso=" + precioUso + '}';
    }
    
    
}
