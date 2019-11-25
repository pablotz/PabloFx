/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.gui;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author pablo
 */
public class PanelTratamientos {

    @FXML
    JFXButton btnCerrarModulo;
    WindowMain app;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXTextField txtBuscarCliente;

    @FXML
    private JFXButton btnBuscarCliente;

    @FXML
    private JFXTextField txtNombreTratamiento;

    @FXML
    private JFXTextArea txaDescripcionTratamiento;

    @FXML
    private JFXTextField txtCostoTratamiento;

    @FXML
    private JFXButton btnRegistrarTratamiento;

    FXMLLoader fxmll;

    public PanelTratamientos(WindowMain app) {
        this.app = app;
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/gui/fxml/panel_tratamientos.fxml"));
        fxmll.setController(this);
    }

    public void inicializar() throws Exception {
        fxmll.load();

        btnCerrarModulo.setOnAction(evt -> {
            app.cerrarModulo();
        });
    }

    public Node getRoot() {
        return fxmll.getRoot();
    }
    // getters

    private int idTratamiento;
    private String nombre;
    private String descripcion;
    private float costo;
    private int estatus;

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public int getEstatus() {
        return estatus;
    }
}
