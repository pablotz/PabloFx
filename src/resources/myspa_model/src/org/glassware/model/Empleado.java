/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.model;


/**
 *
 * @author EQUIPO
 */
public class Empleado {
    public int idEmpleado;
    public String numeroEmpleado;
    public String puesto;
    public int estatus;
    public String foto;
    public String rutaFoto;
    public Persona idPersona;
    public Usuario idUsuario;

    public Empleado(int idEmpleado, String numeroEmpleado, String puesto, int estatus, String foto, String rutaFoto, Persona idPersona, Usuario idUsuario) {
        this.idEmpleado = idEmpleado;
        this.numeroEmpleado = numeroEmpleado;
        this.puesto = puesto;
        this.estatus = estatus;
        this.foto = foto;
        this.rutaFoto = rutaFoto;
        this.idPersona = idPersona;
        this.idUsuario = idUsuario;
    }

    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
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

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
}
