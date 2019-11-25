package org.glassware.commons;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class MySPAHTTPUtils {

    public static String read(HttpURLConnection httpConn) throws Exception {
        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String contenido = "";
        String lineaActual = null;

        while ((lineaActual = br.readLine()) != null) {
            contenido += lineaActual;
        }
        return contenido;

    }
    
    public static void write(HttpURLConnection httpConn, String contenido) throws Exception{
        byte[] bytes = contenido.getBytes();
        DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
        dos.write(bytes);
        dos.close();
    }
    
    public static int size(String s){
        return s != null ? s.getBytes().length : 0;
    }

}
