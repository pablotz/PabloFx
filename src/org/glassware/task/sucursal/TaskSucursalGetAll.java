/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.task.sucursal;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import org.glassware.model.Sucursal;
import org.glassware.commons.MySPACommons;
import org.glassware.commons.MySPAHTTPUtils;
import org.glassware.gui.PanelSucursal;
import org.glassware.gui.WindowMain;

/**
 * Esta clase nos permite consultar todos los registros de las sucursales
 * almacenadas en la BD, a través del uso de servicios REST.
 *
 * @author LiveGrios
 */
public class TaskSucursalGetAll extends Task<Void> {

    // El Panel que contiene todos los controles visuales
    // que manipulan el catálogo y los datos de las sucursales:
    PanelSucursal panelSucursal;

    // Necesitamos el objeto que hace referencia a la aplicación:
    WindowMain app;

    // La conexión http con el servicio REST:
    HttpURLConnection connHttp;

    // La lista dinámica que contendrá objetos de tipo Sucursal:
    List<Sucursal> sucursales;

    // Guardamos la excepción, si es que ocurre una,
    // durante la ejecución paralela de la tarea:
    Exception resultException;

    public TaskSucursalGetAll(WindowMain app, PanelSucursal panelSucursal) {
        this.app = app;
        this.panelSucursal = panelSucursal;
    }

    /**
     * Este método se ejecutará asíncronamente de manera paralela y hará la
     * consulta al servicio REST que devolverá los registros de sucursales como
     * un JSON array.
     *
     * @return
     * @throws Exception
     */
    @Override
    protected Void call() throws Exception {
        try {
            getAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception Managed");
        }
        return null;
    }

    /**
     * Este método se conecta al servicio REST que devolverá el catálogo de
     * sucursales como un JSON array que posteriormente será convertido en una
     * List<Sucursal> de Java.
     *
     * @throws Exception
     */
    private void getAll() throws Exception {
        // Establecemos la ruta del servicio REST:
        String server = MySPACommons.URL_SERVER + "/api/Sucursal/mostrar";

        // Generamos una URL con la ruta anteriormente establecida:
        URL url = new URL(server);

        // Aquí guardaremos el código de respuesta del servidor:
        int responseCode = 0;

        // Aquí guardaremos el documento (en formato texto/JSON) que nos
        // devolverá el servidor:
        String responseContent = "";

        // Abrimos la conexión HTTP:
        connHttp = (HttpURLConnection) url.openConnection();

        // Indicamos que vamos a enviar datos al servidor:
        connHttp.setDoOutput(true);

        // Indicamos que vamos a leer datos de respuesta del servidor:
        connHttp.setDoInput(true);

        // Establecemos el tipo de petición,
        // de acuerdo al servicio que invocaremos:
        connHttp.setRequestMethod("GET");

        // Establecemos el tipo de codificación que tendrá la respuesta del
        // servidor:
        connHttp.setRequestProperty("charset", "utf-8");

        // Le avisamos al servidor que haremos la petición:
        connHttp.connect();

        // Hacemos la petición y obtenemos el código de respuesta:
        responseCode = connHttp.getResponseCode();

        // Si el resultado fue exitoso:
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Leemos los datos que nos manda el servidor:
            responseContent = MySPAHTTPUtils.read(connHttp);

            // Cerramos la conexión con el servidor:
            connHttp.disconnect();

            // Convertimos el texto JSON en una lista dinámica de Java:
            sucursales = parseSucursales(responseContent);

            // Actualizamos la tabla (el control visual TableView) de sucursales
            // dentro del hilo de JavaFX, porque de no hacerlo allí, se generará
            // una excepción:
            Platform.runLater(() -> {
                panelSucursal.getTblvSucursales().setItems(FXCollections.observableArrayList(sucursales));
            });
        } else // Si hubo un error, nos desconectamos del servidor y 
        // mostramos el mensaje correspondiente dentro del hilo
        // de JavaFX:            
        {
            connHttp.disconnect();
            resultException = new Exception("Server responses with code: " + responseCode);
            Platform.runLater(() -> {
                app.showAlert("Error al consultar catálogo de sucursales.",
                        resultException.toString(),
                        Alert.AlertType.NONE);
            });
        }

    }

    /**
     * Este método convierte una cadena JSON en una lista de sucursales Java de
     * tipo ArrayList<Sucursal>.
     *
     * @param strJson
     * @return
     * @throws Exception
     */
    private List<Sucursal> parseSucursales(String strJson) throws Exception {
        // Esta es la lista que contendrá los objetos de tipo Sucursal:
        List<Sucursal> sucursales = new ArrayList<>();

        // Con este objeto le vamos a indicar a Gson que queremos convertir
        // el contenido JSON en una List<Sucursal>:
        Type listType = new TypeToken<List<Sucursal>>() {
        }.getType();

        // Creamos un objeto de tipo Gson:
        Gson gson = new Gson();

        // Convertimos la cadena JSON en una lista de sucursales de Java:
        sucursales = gson.fromJson(strJson, listType);

        // Devolvemos la lista creada:
        return sucursales;
    }
}
