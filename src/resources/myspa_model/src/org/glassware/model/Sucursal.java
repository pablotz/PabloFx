package org.glassware.model;

/**
 *
 * @author pablo
 */
public class Sucursal {
    int idSucursal;
    String nombre;
    String domicilio;
    double latitud;
    double longitud;
    int estatus;

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Sucursal(int idSucursal, String nombre, String domicilio, double latitud, double longitud, int estatus) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estatus = estatus;
    }

    

   
    public Sucursal() {
    }
    
    @Override
    public String toString() { //sobreescribimos el metodo toString 
        return idSucursal + "  " + nombre;  //traemos los datos datos en el core principal
    }
    
}
