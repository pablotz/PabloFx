/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.generacionNumero;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author PQ
 */
public class GeneracionNumero {

    public String numeroEmpleado(String rfc) {
        String numEmpleado = "E";

        for (int i = 0; i < 4; i++) {
            numEmpleado += rfc.charAt(i);
        }

        Calendar fecha = new GregorianCalendar();

        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        numEmpleado += "0" + dia;
        numEmpleado += mes;
        numEmpleado += anio;

        return numEmpleado;
    }

    public String numeroClienteRFC(String rfc) {
        String numCliente = "";

        for (int i = 0; i < 4; i++) {
            numCliente += rfc.charAt(i);
        }

        Calendar fecha = new GregorianCalendar();

        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        numCliente += "0" + dia;
        numCliente += mes;
        numCliente += anio;

        return numCliente;
    }

    public String numeroCliente(String nombre, String apellidoP, String apellidoM) {
        String numCliente = "";

        numCliente += apellidoP.charAt(0);

        String letra;
        boolean b = false;
        int i = 0;
        while (b == false) {
            if (apellidoP.charAt(i) == 'a' || apellidoP.charAt(i) == 'e'
                    || apellidoP.charAt(i) == 'i' || apellidoP.charAt(i) == 'o'
                    || apellidoP.charAt(i) == 'u' || apellidoP.charAt(i) == 'A' || apellidoP.charAt(i) == 'E'
                    || apellidoP.charAt(i) == 'I' || apellidoP.charAt(i) == 'O'
                    || apellidoP.charAt(i) == 'U') {
                
                letra = String.valueOf(apellidoP.charAt(i));
                numCliente += letra.toUpperCase();
                b = true;
            }
            if (i > apellidoP.length()) {
                numCliente += "X";
                b = true;
            }
            i++;

        }

        if (apellidoM != null || apellidoM == "") {
            numCliente += apellidoM.charAt(0);
        }
        else{
            numCliente += "X";
        }
        
        numCliente += nombre.charAt(0);

        Calendar fecha = new GregorianCalendar();

        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        numCliente += "0" + dia;
        numCliente += mes;
        numCliente += anio;

        return numCliente;
    }
}
