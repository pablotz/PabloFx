package org.glassware.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ControladorVentanas {

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

    @FXML
    private void cambiarProductos(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaProductos/ventana_productos.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void cambiarControlSala(ActionEvent event) {

    }

    @FXML
    void cambiarEmpleados(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaProductos/ventana_productos.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void cambiarSalas(ActionEvent event) {

    }

    @FXML
    void cambiarSucursales(ActionEvent event) {

    }

    @FXML
    void cambiarTratamientos(ActionEvent event) {

    }
    
     @FXML
    void cambiarClientes(ActionEvent event) {

    }

}
