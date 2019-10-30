/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.fxml.ventanaPrincipal;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author pablo
 */
public class ControladorVentanas implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXButton btnProductos;
    @FXML
    private JFXButton btnEmpleados;
    @FXML
    private JFXButton btnClientes;
    @FXML
    private JFXButton btnTratamientos;
    @FXML
    private JFXButton btnSalas;
    @FXML
    private JFXButton btnSucursales;
    @FXML
    private JFXButton btnControlSala;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cambiarProductos(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaProductos/ventana_productos.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
}
