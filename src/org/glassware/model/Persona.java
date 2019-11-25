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
public  class Persona {

     int idPersona;
     String nombre;
     String apellidoPaterno;
     String apellidoMaterno;
     String genero;
     String domicilio;
     String telefono;
     String rfc;

    public int getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRfc() {
        return rfc;
    }
    
}
