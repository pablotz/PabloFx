/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.model;

public class Sala {

    int idSala;
    String nombre;
    String descripcion;
    String foto;
    String rutaFoto;
    int estatus;
    int idSucursal;

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Sala(int idSala, String nombre, String descripcion, String foto, String rutaFoto, int estatus, int idSucursal) {
        this.idSala = idSala;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
        this.rutaFoto = rutaFoto;
        this.estatus = estatus;
        this.idSucursal = idSucursal;
    }
    
    
    

    @Override
    public String toString() { //sobreescribimos el metodo toString 
        return idSala + "  " + nombre;  //traemos los datos datos en el core principal
    }

    public Sala() {
    }

}
