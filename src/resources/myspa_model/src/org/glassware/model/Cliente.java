/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.model;

/**
 *
 * @author cande
 */
public class Cliente {
    private int idCliente;
    private String numeroUnico;
    private String correo;
    private int estatus;
    private Persona idPersona;
    private Usuario idUsuario;

    public Cliente() {
    }

    public Cliente(int idCliente, String numeroUnico, String correo, int estatus, Persona idPersona, Usuario idUsuario) {
        this.idCliente = idCliente;
        this.numeroUnico = numeroUnico;
        this.correo = correo;
        this.estatus = estatus;
        this.idPersona = idPersona;
        this.idUsuario = idUsuario;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(String numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return getIdCliente()+" "+getNumeroUnico()+" "+getCorreo()+" "+getEstatus()+" "+getIdPersona().getIdPersona()+" "+getIdPersona().getNombre()+" "
                +getIdPersona().getApellidoPaterno()+" "+getIdPersona().getApellidoMaterno()+" "+getIdPersona().getGenero()+" "+getIdPersona().getDomicilio()+" "
                +getIdPersona().getTelefono()+" "+getIdPersona().getRfc()+" "+getIdUsuario().getIdUsuario()+" "+getIdUsuario().getNombreUsuario()+" "+
                getIdUsuario().getContrasenia()+" "+getIdUsuario().getRol();
    }
    
}
