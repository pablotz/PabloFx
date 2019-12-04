package org.glassware.task.sala;

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
import org.glassware.gui.PanelSala;
import org.glassware.gui.PanelSucursal;
import org.glassware.gui.WindowMain;
import org.glassware.model.Sala;

/**
 *
 * @author LiveGrios
 */
public class TaskSalaUpdate extends Task<Void>
{
    PanelSala panelSala;
    WindowMain app;
    
    JsonObject jso;
    HttpURLConnection connHttp;
    Sala sala;
    
    Exception resultException;
    
    public TaskSalaUpdate(WindowMain app, PanelSala panelSala, Sala sala)
    {
        this.app = app;
        this.panelSala = panelSala;
        this.sala = sala;
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
        String server = MySPACommons.URL_SERVER + "/api/sucursal/update?";
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
        if (jso != null && jso.has("exception"))
        {            
            System.out.println(jso.get("exception").getAsString());
            app.showAlert("Error", 
                          jso.get("exception").getAsString(), 
                          Alert.AlertType.ERROR);
            return;
        }
        
        if (jso != null && jso.has("error"))
        {       
            System.out.println(jso.get("error").getAsString());
            app.showAlert("Error", 
                          jso.get("error").getAsString(), 
                          Alert.AlertType.ERROR);
            return;
        }
        
        if (resultException != null)
        {
            resultException.printStackTrace();
            System.out.println("Exception Managed");           
            app.showAlert("Error", 
                          resultException.toString(), 
                          Alert.AlertType.ERROR);
            return;
        }
        
        app.showAlert("Movimiento realizado.", 
                      "Sucursal actualizada de forma correcta",
                      Alert.AlertType.INFORMATION);
        panelSala.consultarSala();
    }
    
    private String buildPOSTParams() throws Exception
    {        
        String params = "id=" + sala.getIdSala()+ 
                        "&nombre=" + URLEncoder.encode(sala.getNombre(), "UTF-8") + 
                        "&domicilio=" + URLEncoder.encode(sala.getDescripcion(), "UTF-8")+
                        "&latitud=" + sala.getEstatus()+ 
                        "&longitud=" + sala.getSucursal().getIdSucursal();
        return params;
    }
    
}