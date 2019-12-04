package org.glassware.task.producto;

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
import org.glassware.gui.PanelProducto;
import org.glassware.gui.PanelSucursal;
import org.glassware.gui.WindowMain;
import org.glassware.model.Producto;

/**
 *
 * @author LiveGrios
 */
public class TaskProductoDelete extends Task<Void>
{
    PanelProducto panelProducto;
    WindowMain app;
    
    JsonObject jso;
    HttpURLConnection connHttp;
    Producto producto;
    
    Exception resultException;
    
    public TaskProductoDelete(WindowMain app, PanelProducto panelProducto, Producto producto)
    {
        this.app = app;
        this.panelProducto = panelProducto;
        this.producto = producto;
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
        String server = MySPACommons.URL_SERVER + "/api/Producto/delete?";
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
         try{
            if(jso.has("result")){
                if (jso.get("result").getAsString().toLowerCase().equals("exito")) {
                    app.showAlert("Movimiento realizado", "Se elimino el registro correctamente", Alert.AlertType.INFORMATION);
                    panelProducto.consultarProductos();
                }else
                    app.showAlert("Error", jso.get("result").getAsString(), Alert.AlertType.WARNING);
                
            }else{
                app.showAlert("Error", "Error desconocido", Alert.AlertType.ERROR);
            }
        }catch(Exception e){
            e.printStackTrace();
            app.showAlert("Excepcion", e.toString(), Alert.AlertType.ERROR);
        } 
    }
    private String buildPOSTParams() throws Exception
    {        
        String params = "idProducto=" + producto.getIdProducto();
        
        return params;
    }
    
}
