/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

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

    FXMLLoader fxmll;

    public PanelSucursal(WindowMain app) {
        this.app = app;
    }

    public void inicializar() throws Exception {
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/gui/fxml/panel_sucursal.fxml"));
        fxmll.setController(this);
        fxmll.load();

        btnCerrarModulo.setOnAction(evt -> {
            app.cerrarModulo();
        });
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

    
    
    

}
