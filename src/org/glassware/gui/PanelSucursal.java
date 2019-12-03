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
import org.glassware.gui.components.TableAdapterSucursal;
import org.glassware.model.Sala;
import org.glassware.model.Sucursal;
import org.glassware.task.sala.TaskSalaInsert;

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
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/gui/fxml/panel_sucursal.fxml"));
        fxmll.setController(this);
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

    public String validarDatosSala() {
        String error = null;

        if (txtNombreSucursal.getText().trim().isEmpty()) {
            error = "Debe especificar un nombre de sala";
        } else if (txtDomicilioSucursal.getText().trim().isEmpty()) {
            error = "Debe especificar una descripción";
        } else if (txtLatitudSucursal.getText().trim().isEmpty()) {
            error = "Debe espicificar una latitud a la sala";
        } else if (txtLongitudSucursal.getText().trim().isEmpty()) {
            error = "Debe espicificar una longitud a la sala";
        }
        return error;
    }

    public void addSucursal() {
        String error = validarDatosSala();

        if (error != null) {
            app.showAlert("Datos incorrectos", error, Alert.AlertType.WARNING);
            return;
        }
        else{
        Sucursal su = new Sucursal();

        su.setNombre(txtNombreSucursal.getText());
        su.setDomicilio(txtDomicilioSucursal.getText());
        su.setLatitud(Double.parseDouble(txtLatitudSucursal.getText()));
        su.setLongitud(Double.parseDouble(txtLongitudSucursal.getText()));

        Thread hilo = null;

        TaskSucursalInsert task2 = new TaskSucursalInsert(app, this, su);
            System.out.println("Insertar fjfjfjf");

        hilo = new Thread(task2);
        hilo.start();
        }

    }

    TableAdapterSucursal tableA = new TableAdapterSucursal();

    public void inicializar() throws Exception {

        fxmll.load();

        btnCerrarModulo.setOnAction(evt -> {
            app.cerrarModulo();
        });

        btnRegistrarSucursal.setOnAction(evt -> {
            addSucursal();
        });

        consultarSucursales();
        tableA.adapt(tblvSucursales);

    }

}
