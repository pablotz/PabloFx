package org.glassware.task.empleado;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import org.glassware.commons.MySPACommons;
import org.glassware.commons.MySPAHTTPUtils;
import org.glassware.gui.PanelEmpleado;
import org.glassware.gui.WindowMain;
import org.glassware.model.Empleado;

/**
 *
 * @author LiveGrios
 */
public class TaskEmpleadoUpdate extends Task<Void> {

    PanelEmpleado panelEmpleado;
    WindowMain app;

    JsonObject jso;
    HttpURLConnection connHttp;
    Empleado empleado;

    Exception resultException;

    public TaskEmpleadoUpdate(WindowMain app, PanelEmpleado panelEmpleado, Empleado empleado) {
        this.app = app;
        this.panelEmpleado = panelEmpleado;
        this.empleado = empleado;
    }

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

    private void save() throws Exception {
        String server = MySPACommons.URL_SERVER + "/api/Empleado/update?";
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
        connHttp.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connHttp.setRequestProperty("charset", "utf-8");
        connHttp.setRequestProperty("Content-Length", Integer.toString(postParamsBytes.length));
        connHttp.setUseCaches(false);

        MySPAHTTPUtils.write(connHttp, postParams);

        connHttp.connect();

        responseCode = connHttp.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            responseContent = MySPAHTTPUtils.read(connHttp);

            connHttp.disconnect();
            jso = jp.parse(responseContent).getAsJsonObject();
        } else {
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
    public void succeeded() {
        try {
            if (jso.has("result")) {
                if (jso.get("result").getAsString().toLowerCase().equals("exito")) {
                    app.showAlert("Movimiento realizado", "Se actualizó el registro correctamente", Alert.AlertType.INFORMATION);
                    panelEmpleado.consultarEmpleados();
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
        String params = "idPersona=" + (empleado.getPersona().getIdPersona()) 
                + "&idUsuario=" + (empleado.getUsuario().getIdUsuario())
                + "&idEmpleado=" + (empleado.getIdEmpleado()) 
                + "&nombre=" + URLEncoder.encode(empleado.getPersona().getNombre(), "UTF-8")
                + "&apellidoPaterno=" + URLEncoder.encode(empleado.getPersona().getApellidoPaterno(), "UTF-8")
                + "&apellidoMaterno=" + URLEncoder.encode(empleado.getPersona().getApellidoMaterno(), "UTF-8")
                + "&genero=" + URLEncoder.encode(empleado.getPersona().getGenero(), "UTF-8")
                + "&domicilio=" + URLEncoder.encode(empleado.getPersona().getDomicilio(), "UTF-8")
                + "&telefono=" + URLEncoder.encode(empleado.getPersona().getTelefono(), "UTF-8")
                + "&rfc=" + URLEncoder.encode(empleado.getPersona().getRfc(), "UTF-8")
                + "&nombreUsuario=" + URLEncoder.encode(empleado.getUsuario().getNombreUsuario(), "UTF-8")
                + "&rol=" + URLEncoder.encode(empleado.getUsuario().getRol(), "UTF-8")
                + "&puesto=" + URLEncoder.encode(empleado.getPuesto(), "UTF-8")
                + "&foto=" + URLEncoder.encode(empleado.getFoto(), "UTF-8")
                + "&rutaFoto=" + URLEncoder.encode(empleado.getRutaFoto(), "UTF-8");
        return params;
    }

}
