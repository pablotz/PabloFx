package org.glassware.task.cliente;

import org.glassware.task.sucursal.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import org.glassware.model.Sucursal;
import org.glassware.commons.MySPACommons;
import org.glassware.commons.MySPAHTTPUtils;
import org.glassware.gui.PanelCliente;
import org.glassware.gui.PanelProducto;
import org.glassware.gui.PanelSucursal;
import org.glassware.gui.WindowMain;
import org.glassware.model.Cliente;
import org.glassware.model.Persona;
import org.glassware.model.Usuario;

/**
 *
 * @author LiveGrios
 */
public class TaskClienteUpdate extends Task<Void>
{
    PanelCliente panelCliente;
    WindowMain app;
    
    JsonObject jso;
    HttpURLConnection connHttp;
    Cliente cliente;
    Persona persona;
    Usuario usuario;
    Exception resultException;
    
    public TaskClienteUpdate(WindowMain app, PanelCliente panelCliente, Cliente cliente)
    {
        this.app = app;
        this.panelCliente = panelCliente;
        this.cliente = cliente;
    }
    
    @Override
    protected Void call() throws Exception
    {
        try
        {
            save();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception Managed");
        }
        return null;
    }
    
    private void save() throws Exception
    {
        String server = MySPACommons.URL_SERVER + "/api/Cliente/update?";
        String postParams = buildPOSTParams();
        JsonParser jp = new JsonParser();
        URL url = new URL(server);
        connHttp = (HttpURLConnection) url.openConnection();
        int responseCode = 0;
        String currentLine = null;
        String responseContent = "";
                
        byte[] postParamsBytes = postParams.getBytes();
        
        connHttp.setDoOutput(true);
        connHttp.setDoInput(true);        
        connHttp.setRequestMethod("POST");
        connHttp.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
        connHttp.setRequestProperty( "charset", "utf-8");
        connHttp.setRequestProperty( "Content-Length", Integer.toString(postParamsBytes.length));
        connHttp.setUseCaches(false);
        
        MySPAHTTPUtils.write(connHttp, postParams);
                
        connHttp.connect();
        
        responseCode = connHttp.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK)
        {
            responseContent = MySPAHTTPUtils.read(connHttp);
            
            connHttp.disconnect();
            jso = jp.parse(responseContent).getAsJsonObject();            
        }
        else
        {
            connHttp.disconnect();
            resultException = new Exception("Server responses with code: " + responseCode);
        }
    }
    
    /**
     * Este método se invoca cuando la tarea termina.
     * 
     * Así mismo, este método ya corre sobre el hilo de JavaFX.
     */
    @Override
    public void succeeded()
    {                
       try {
            if (jso.has("result")) {
                if (jso.get("result").getAsString().toLowerCase().equals("exito")) {
                    app.showAlert("Movimiento realizado", "Se inserto el registro correctamente", Alert.AlertType.INFORMATION);
                    panelCliente.consultarClientes();
                } else {
                    app.showAlert("Error", jso.get("result").getAsString(), Alert.AlertType.WARNING);
                }

            } else {
                app.showAlert("Error", "Error desconocido", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            app.showAlert("Excepcion", e.toString(), Alert.AlertType.ERROR);
        }
    }
    
    private String buildPOSTParams() throws Exception
    {        
        String params = "idPersona="     + cliente.getPersona().getIdPersona()+
                        "&idUsuario="    + cliente.getUsuario().getIdUsuario()+
                        "&idCliente="    +cliente.getIdCliente() + 
                        "&nombre="          + URLEncoder.encode(cliente.getPersona().getNombre(), "UTF-8")+
                        "&apellidoPaterno=" + URLEncoder.encode(cliente.getPersona().getApellidoPaterno(), "UTF-8")+ 
                        "&apellidoMaterno=" + URLEncoder.encode(cliente.getPersona().getApellidoMaterno(), "UTF-8")+
                        "&genero="          + URLEncoder.encode(cliente.getPersona().getGenero(), "UTF-8")+
                        "&domicilio="       + URLEncoder.encode(cliente.getPersona().getDomicilio(), "UTF-8")+
                        "&telefono="        + URLEncoder.encode(cliente.getPersona().getTelefono(), "UTF-8")+
                        "&rfc="             + URLEncoder.encode(cliente.getPersona().getRfc(), "UTF-8")+
                        "&nombreUsuario="     + URLEncoder.encode(cliente.getUsuario().getNombreUsuario(), "UTF-8")+
                        "&contrasenia="       + URLEncoder.encode(cliente.getUsuario().getContrasenia(), "UTF-8")+
                        "&rol="               + URLEncoder.encode(cliente.getUsuario().getRol(), "UTF-8")+
                        "&NumeroUnico="       + URLEncoder.encode(cliente.getNumeroUnico(), "UTF-8")+
                        "&Correo="            + URLEncoder.encode(cliente.getCorreo(), "UTF-8");
        return params;
    }
    
}
