/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.gui;

import javafx.scene.control.Tab;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.glassware.gui.components.TableAdapterSucursal;
import org.glassware.model.Sucursal;
import org.glassware.task.sucursal.TaskSucursalDelete;
import org.glassware.task.sucursal.TaskSucursalGetAll;
import org.glassware.task.sucursal.TaskSucursalInsert;
import org.glassware.task.sucursal.TaskSucursalUpdate;

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
    private JFXTextField txtIdSucursal;

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
    private JFXTabPane tabpSucursales;

    @FXML
    private Tab tabRegistrarSucursal;

    @FXML
    private Tab tabSucursales;

    @FXML
    private JFXTextField txtEstatusSucursal;

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

    public void mostrarDetalleSucursal() {
        Sucursal su = tblvSucursales.getSelectionModel().getSelectedItem();
        if (su == null) {
            limpiarCampos();
            return;
        } else {
            txtIdSucursal.setText("" + su.getIdSucursal());
            txtIdSucursal.setVisible(false);
            txtNombreSucursal.setText("" + su.getNombre());
            txtDomicilioSucursal.setText("" + su.getDomicilio());
            txtLatitudSucursal.setText("" + su.getLatitud());
            txtLongitudSucursal.setText("" + su.getLongitud());

            int estatus = su.getEstatus();

            if (estatus == 1) {
                txtEstatusSucursal.setText("Activo");
            }
            if (estatus == 2) {
                txtEstatusSucursal.setText("Inactivo");
            }

        }
    }

    public void limpiarCampos() {

        txtNombreSucursal.setText("");
        txtDomicilioSucursal.setText("");
        txtLatitudSucursal.setText("");
        txtLongitudSucursal.setText("");

    }

    public void deleteSucursal() {
        String error = validarDatos();
        if (error != null) {
            app.showAlert("Datos Incorectos", error, Alert.AlertType.WARNING);
            return;
        }
        Thread hilo = null;
        Sucursal su = new Sucursal();
        su.setIdSucursal(Integer.parseInt(txtIdSucursal.getText()));
        su.setNombre(txtNombreSucursal.getText());
        su.setDomicilio(txtDomicilioSucursal.getText());
        su.setLatitud(Double.parseDouble(txtLatitudSucursal.getText()));
        su.setLatitud(Double.parseDouble(txtLongitudSucursal.getText()));

        TaskSucursalDelete task2 = new TaskSucursalDelete(app, this, su);
        hilo = new Thread(task2);
        hilo.start();

    }

    public void consultarSucursales() {
        Thread hilo = null;
        TaskSucursalGetAll task = new TaskSucursalGetAll(app, this);

        hilo = new Thread(task);
        hilo.start();

    }

    public String validarDatos() {
        String error = null;

        if (txtNombreSucursal.getText().trim().isEmpty()) {
            error = "Debe especificar un nombre de sucursal";
        } else if (txtDomicilioSucursal.getText().trim().isEmpty()) {
            error = "Debe especificar un domicilio de la sucursal";
        } else if (txtLatitudSucursal.getText().trim().isEmpty()) {
            error = "Debe especificar la latitud de la sucursal";
        } else if (txtLongitudSucursal.getText().trim().isEmpty()) {
            error = "Debe especificar la longitud de la sucursal";
        } else {
            try {
                Double.valueOf(txtLatitudSucursal.getText().trim());
                Double.valueOf(txtLongitudSucursal.getText().trim());
            } catch (NumberFormatException nfe) {
                error = "Captura solo numero para latitud y longitud";
            }
        }
        return error;
    }

    public void addSucursal() {
        String error = validarDatos();

        if (error != null) {
            app.showAlert("Datos incorrectos", error, Alert.AlertType.WARNING);
            return;
        } else {
            Sucursal su = new Sucursal();

            su.setNombre(txtNombreSucursal.getText());
            su.setDomicilio(txtDomicilioSucursal.getText());
            su.setLatitud(Double.parseDouble(txtLatitudSucursal.getText()));
            su.setLongitud(Double.parseDouble(txtLongitudSucursal.getText()));

            Thread hilo = null;

            TaskSucursalInsert task2 = new TaskSucursalInsert(app, this, su);

            hilo = new Thread(task2);
            hilo.start();
        }

    }

    public void updateSucursal() {
        String error = validarDatos();
        if (error != null) {
            app.showAlert("Datos Incorectos", error, Alert.AlertType.WARNING);
            return;
        }
        Thread hilo = null;
        Sucursal su = new Sucursal();

        su.setIdSucursal(Integer.parseInt(txtIdSucursal.getText()));
        su.setNombre(txtNombreSucursal.getText());
        su.setDomicilio(txtDomicilioSucursal.getText());
        su.setLatitud(Double.parseDouble(txtLatitudSucursal.getText()));
        su.setLongitud(Double.parseDouble(txtLongitudSucursal.getText()));

        TaskSucursalUpdate task2 = new TaskSucursalUpdate(app, this, su);
        hilo = new Thread(task2);
        hilo.start();

    }

    public void bloquearComponentes() {
        txtNombreSucursal.setDisable(true);
        txtDomicilioSucursal.setDisable(true);
        txtLatitudSucursal.setDisable(true);
        txtLongitudSucursal.setDisable(true);

    }

    TableAdapterSucursal tableA = new TableAdapterSucursal();

    public void inicializar() throws Exception {

        fxmll.load();

        agrgarOyentes();
        consultarSucursales();
        txtEstatusSucursal.setDisable(true);
        txtIdSucursal.setVisible(false);
        tableA.adapt(tblvSucursales);

    }

    public void agrgarOyentes() {
        tblvSucursales.getSelectionModel().selectedItemProperty().addListener(evt -> {
            tabpSucursales.getSelectionModel().select(tabRegistrarSucursal);
            mostrarDetalleSucursal();
            bloquearComponentes();
        });

        btnRegistrarSucursal.setOnAction(evt -> {
            addSucursal();
        });
        btnCerrarModulo.setOnAction(evt -> {
            app.cerrarModulo();
        });

        btnEliminarSucursal.setOnAction(evt -> {
            deleteSucursal();
        });

        btnGuardarSucursal.setOnAction(evt -> {
            updateSucursal();
        });

        btnModificarSucursal.setOnAction(evt -> {
            txtNombreSucursal.setDisable(false);
            txtDomicilioSucursal.setDisable(false);
            txtLatitudSucursal.setDisable(false);
            txtLongitudSucursal.setDisable(false);
        });
    }

}
