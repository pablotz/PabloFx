/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.glassware.model.Sucursal;
import org.glassware.task.sucursal.TableAdapterSucursal;
import org.glassware.task.sucursal.TaskSucursalGetAll;
import org.glassware.task.sucursal.TaskSucursalInsert;

/**
 *
 * @author pablo
 */
public class PanelSucursal {

    @FXML
    JFXButton btnCerrarModulo;
    WindowMain app;

    @FXML
    AnchorPane rootPane;

    @FXML
    private JFXTextField txtBuscarSucursal;

    @FXML
    private JFXButton btnBuscarSucursal;

    @FXML
    private JFXButton btnRegistrarSucursal;

    @FXML
    private JFXButton btnModificarSucursal;

    @FXML
    private JFXButton btnGuardarSucursal;

    @FXML
    private JFXButton btnEliminarSucursal;

    @FXML
    private JFXTextField txtNombreSucursal;

    @FXML
    private JFXTextField txtLatitudSucursal;

    @FXML
    private JFXTextField txtLongitudSucursal;

    @FXML
    private JFXTextField txtDomicilioSucursal;

    @FXML
    private TableView<Sucursal> tblvSucursales;

    @FXML
    private JFXTextField txtIdSucursal;

    FXMLLoader fxmll;

    TaskSucursalGetAll task;

    public PanelSucursal(WindowMain app) {
        this.app = app;
    }

    public Node getRoot() {
        return fxmll.getRoot();
    }

    public AnchorPane getRooPane() {
        return rootPane;
    }

    public JFXButton getBtnCerrarModulo() {
        return btnCerrarModulo;
    }

    public WindowMain getApp() {
        return app;
    }

    public AnchorPane getRootPane() {
        return rootPane;
    }

    public JFXTextField getTxtBuscarSucursal() {
        return txtBuscarSucursal;
    }

    public JFXButton getBtnBuscarSucursal() {
        return btnBuscarSucursal;
    }

    public JFXButton getBtnRegistrarSucursal() {
        return btnRegistrarSucursal;
    }

    public JFXButton getBtnModificarSucursal() {
        return btnModificarSucursal;
    }

    public JFXButton getBtnGuardarSucursal() {
        return btnGuardarSucursal;
    }

    public JFXButton getBtnEliminarSucursal() {
        return btnEliminarSucursal;
    }

    public JFXTextField getTxtNombreSucursal() {
        return txtNombreSucursal;
    }

    public JFXTextField getTxtLatitudSucursal() {
        return txtLatitudSucursal;
    }

    public JFXTextField getTxtLongitudSucursal() {
        return txtLongitudSucursal;
    }

    public JFXTextField getTxtDomicilioSucursal() {
        return txtDomicilioSucursal;
    }

    public FXMLLoader getFxmll() {
        return fxmll;
    }

    public TableView<Sucursal> getTblvSucursales() {
        return tblvSucursales;
    }

    public JFXTextField getTxtIdSucursal() {
        return txtIdSucursal;
    }

    public void consultarSucursales() {
        Thread hilo = null;
        TaskSucursalGetAll task = new TaskSucursalGetAll(app, this);

        hilo = new Thread(task);
        hilo.start();

    }
    
    public void addSucursales(){
        String error = validarDatos();
        if(error != null){
            app.showAlert(error, error, Alert.AlertType.WARNING);
            return;
        }
        
        Sucursal s = new Sucursal();
        s.setNombre(txtNombreSucursal.getText());
        s.setDomicilio(txtDomicilioSucursal.getText());
        s.setLatitud(Double.parseDouble(txtLatitudSucursal.getText()));
        s.setLongitud(Double.parseDouble(txtLongitudSucursal.getText()));
        
        Thread hilo = null;
        TaskSucursalInsert task = new TaskSucursalInsert(app, this, s);

        hilo = new Thread(task);
        hilo.start();
    }
    
    public String validarDatos(){
        String error = null;
        
        if(txtNombreSucursal.getText().trim().isEmpty())
            error = "Debe especificar un nombre de sucursal";
        else if(txtDomicilioSucursal.getText().trim().isEmpty())
            error = "Debe especificar un domicilio de la sucursal";
        else if(txtLatitudSucursal.getText().trim().isEmpty())
            error = "Debe especificar la latitud de la sucursal";
        else if(txtLongitudSucursal.getText().trim().isEmpty())
            error = "Debe especificar la longitud de la sucursal";
        else{
            try {
                Double.valueOf(txtLatitudSucursal.getText().trim());
                Double.valueOf(txtLongitudSucursal.getText().trim());
            } catch (NumberFormatException nfe) {
                error = "Captura solo numero para latitud y longitud";
            }
        }
        return error;
    }

    TableAdapterSucursal tableA = new TableAdapterSucursal();

    public void inicializar() throws Exception {
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/gui/fxml/panel_sucursal.fxml"));
        fxmll.setController(this);
        fxmll.load();
        
        btnRegistrarSucursal.setOnAction(evt -> {
            addSucursales();
        });
        
        btnCerrarModulo.setOnAction(evt -> {
            app.cerrarModulo();
        });
        
        consultarSucursales();
        tableA.adapt(tblvSucursales);
       
    }

}
