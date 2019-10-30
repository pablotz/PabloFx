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
    void cambiarControlSala(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaControlSalas/ventana_controlSalas.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void cambiarEmpleados(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaEmpleados/ventana_empleado.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void cambiarSalas(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaSalas/ventana_salas.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void cambiarSucursales(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaSucursales/ventana_sucursales.fxml"));
        rootPane.getChildren().setAll(pane);

    }

    @FXML
    void cambiarTratamientos(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaTratamientos/ventana_tratamientos.fxml"));
        rootPane.getChildren().setAll(pane);

    }

    @FXML
    void cambiarClientes(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaClientes/ventana_clientes.fxml"));
        rootPane.getChildren().setAll(pane);

    }

}
