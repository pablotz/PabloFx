/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.task.producto;

import com.google.gson.Gson;
import org.glassware.task.sucursal.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
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
 * Esta clase sirve para insertar un nuevo registro de Sucursal.
 *
 * @author LiveGrios
 */
public class TaskProductoSearch extends Task<Void> {

    PanelProducto panelProducto;
    WindowMain app;
    
    // La lista dinÃ¡mica que contendrÃ¡ objetos de tipo Sucursal:
    List<Producto> productos;
    
    JsonObject jso;
    HttpURLConnection connHttp;
    Producto producto;
    
    Exception resultException;
    
    public TaskProductoSearch(WindowMain app, PanelProducto panelProducto, Producto producto)
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
            search();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Exception Managed");
        }
        return null;
    }
    
    private void search() throws Exception
    {
        String server = MySPACommons.URL_SERVER + "/api/Producto/search?";
        String postParams = buildPOSTParams();
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
            
            // Convertimos el texto JSON en una lista dinÃ¡mica de Java:
            productos = parseProductos(responseContent);
            
            // Actualizamos la tabla (el control visual TableView) de sucursales
            // dentro del hilo de JavaFX, porque de no hacerlo allÃ­, se generarÃ¡
            // una excepciÃ³n:
            Platform.runLater(()->{ 
                panelProducto.getTblvProductos().setItems(FXCollections.observableArrayList(productos)); 
            });
        }
        else
        {
            connHttp.disconnect();
           app.showAlert("Excepcion", "Hubo un error de codigo "+responseCode, Alert.AlertType.ERROR);
            System.out.println(responseCode);
        }
    }
    
    private String buildPOSTParams() throws Exception
    {        
        String params = "variable="+URLEncoder.encode(producto.getNombre(), "UTF-8");
        return params;
    }
    
    private List<Producto> parseProductos(String strJson) throws Exception
    {
        // Esta es la lista que contendrÃ¡ los objetos de tipo Sucursal:
        List<Producto> productos = new ArrayList<>();
        
        // Con este objeto le vamos a indicar a Gson que queremos convertir
        // el contenido JSON en una List<Sucursal>:
        Type listType = new TypeToken<List<Producto>>() {}.getType();
        
        // Creamos un objeto de tipo Gson:
        Gson gson = new Gson();
        
        // Convertimos la cadena JSON en una lista de sucursales de Java:
        productos = gson.fromJson(strJson, listType);
        
        // Devolvemos la lista creada:
        return productos;
    }
}
