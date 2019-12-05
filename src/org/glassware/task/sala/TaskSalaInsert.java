/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.task.sala;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import org.glassware.commons.MySPACommons;
import org.glassware.commons.MySPAHTTPUtils;
import org.glassware.gui.PanelSala;
import org.glassware.gui.WindowMain;
import org.glassware.model.Sala;
import org.glassware.model.Sucursal;

/**
 * Esta clase sirve para insertar un nuevo registro de Sucursal.
 *
 * @author LiveGrios
 */
public class TaskSalaInsert extends Task<Void> {

    // El panel que contiene los controles visuales
    // relacionados con el modulo Sucursal:
    PanelSala panelSala;

    // La aplicación:
    WindowMain app;

    // Este objeto guardará la respuesta que nos de el
    // servidor:
    JsonObject jso;

    // La conexión http con el servicio REST:
    HttpURLConnection connHttp;

    // El objeto que contiene todos los datos de la sucursal:
    Sala sala;

    Sucursal suc;

    // Guardamos la excepción, si es que ocurre una,
    // durante la ejecución paralela de la tarea:
    Exception resultException;

    public TaskSalaInsert(WindowMain app,
            PanelSala panelSala,
            Sala sala) {
        this.app = app;
        this.panelSala = panelSala;
        this.sala = sala;
    }

    /**
     * Este método se ejecutará asíncronamente de manera paralela en donde se
     * invocará el servicio REST que insertará un nuevo registro de sucursal.
     *
     * @return
     * @throws Exception
     */
    @Override
    protected Void call() throws Exception {
        try {
            save();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception Managed");
        }
        return null;
    }

    /**
     * Este método invocará al servicio REST que nos permitirá insertar un nuevo
     * registro de empleado.
     *
     * @throws Exception
     */
    private void save() throws Exception {
        // Establecemos la ruta del servicio REST:
        String server = MySPACommons.URL_SERVER + "/api/Sala/insert";

        // Generamos una URL con la ruta anteriormente establecida:
        URL url = new URL(server);

        // Construimos la cadena con los parámetros y sus valores
        // que enviaremos al servidor:
        String postParams = buildPOSTParams();

        // Este objeto nos permitirá leer la respuesta JSON del servidor:
        JsonParser jp = new JsonParser();

        int responseCode = 0;
        String currentLine = null;
        String responseContent = "";

        // Establecemos comunicación con el servidor:
        connHttp = (HttpURLConnection) url.openConnection();

        // Indicamos que vamos a enviar datos al servidor:
        connHttp.setDoOutput(true);

        // Indicamos que vamos a leer datos de respuesta del servidor:
        connHttp.setDoInput(true);

        // Establecemos el tipo de petición,
        // de acuerdo al servicio que invocaremos:
        connHttp.setRequestMethod("POST");

        // Establecemos que enviaremos los parámetros como un 
        // formulario codificado en la URL. (Leer más sobre este tema):
        connHttp.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        // Establecemos el tipo de codificación que tendrá la respuesta del
        // servidor:
        connHttp.setRequestProperty("charset", "utf-8");

        // Establecemos la longitud (en bytes) de los parámetros 
        // que enviaremos al servidor:
        connHttp.setRequestProperty("Content-Length", String.valueOf(MySPAHTTPUtils.size(postParams)));

        // Establecemos que no vamos a usar caché de datos local:
        connHttp.setUseCaches(false);

        // Enviamos los parámetros al servidor:
        MySPAHTTPUtils.write(connHttp, postParams);

        // Le avisamos al servidor que estamos listos para hacer la petición:
        connHttp.connect();

        // Hacemos la petición y obtenemos el código de respuesta:
        responseCode = connHttp.getResponseCode();

        // Si el resultado fue exitoso:
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Leemos los datos que nos manda el servidor:
            responseContent = MySPAHTTPUtils.read(connHttp);

            // Cerramos la conexión con el servidor:
            connHttp.disconnect();

            // Convertimos la cadena JSON en un JSonObject de Java:
            jso = jp.parse(responseContent).getAsJsonObject();
        } else // Si hubo un error, nos desconectamos del servidor y 
        // mostramos el mensaje correspondiente dentro del hilo
        // de JavaFX:
        {

            connHttp.disconnect();
            resultException = new Exception("Server responses with code: " + responseCode);
            Platform.runLater(() -> {
                app.showAlert("Error al consultar catálogo de salas.",
                        resultException.toString(),
                        Alert.AlertType.NONE);
            });
        }
    }

    /**
     * Este método se invoca cuando la tarea termina.
     *
     * Así mismo, este método ya corre sobre el hilo de JavaFX.
     */
    @Override
    public void succeeded() {
        try {
            if (jso.has("result")) {
                if (jso.get("result").getAsString().toLowerCase().equals("exito")) {
                    app.showAlert("Movimiento realizado", "Se añadio el registro correctamente", Alert.AlertType.INFORMATION);
                    panelSala.consultarSala();
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

    private String buildPOSTParams() throws Exception {
        String params = "nombre=" + URLEncoder.encode(sala.getNombre(), "UTF-8")
                + "&descripcion=" + URLEncoder.encode(sala.getDescripcion(), "UTF-8")
                + "&idSucursal=" + sala.getSucursal().getIdSucursal();
        return params;
    }

}
