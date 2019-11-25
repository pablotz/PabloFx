/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


/**
 *
 * @author pablo
 */
public class PanelControlSala 
{
    
        @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXButton btnConectarSala;

    @FXML
    private JFXComboBox<?> cmbSeleccionarSala;

    @FXML
    private BorderPane pnlGraficaTempSala;

    @FXML
    private Label lblTemperaturaSala;

    @FXML
    private Label lblStatusConexionSala;

    @FXML
    private JFXButton btnConectarSala2;

    @FXML
    private JFXComboBox<?> cmbSeleccionarSala2;

    @FXML
    private BorderPane pnlGraficaTempSala2;

    @FXML
    private Label lblTemperaturaSala2;

    @FXML
    private Label lblStatusConexionSala2;
    
    @FXML JFXButton btnCerrarModulo;
    WindowMain app;
    
    FXMLLoader fxmll;

    public JFXButton getBtnConectarSala() {
        return btnConectarSala;
    }

    public JFXComboBox<?> getCmbSeleccionarSala() {
        return cmbSeleccionarSala;
    }

    public BorderPane getPnlGraficaTempSala() {
        return pnlGraficaTempSala;
    }

    public Label getLblTemperaturaSala() {
        return lblTemperaturaSala;
    }

    public Label getLblStatusConexionSala() {
        return lblStatusConexionSala;
    }

    public JFXButton getBtnConectarSala2() {
        return btnConectarSala2;
    }

    public JFXComboBox<?> getCmbSeleccionarSala2() {
        return cmbSeleccionarSala2;
    }

    public BorderPane getPnlGraficaTempSala2() {
        return pnlGraficaTempSala2;
    }

    public Label getLblTemperaturaSala2() {
        return lblTemperaturaSala2;
    }

    public Label getLblStatusConexionSala2() {
        return lblStatusConexionSala2;
    }
    

    
    public PanelControlSala(WindowMain app)
    {
        this.app = app;
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/gui/fxml/panel_controlSala.fxml"));
        fxmll.setController(this);
    }
    public void inicializar() throws Exception
    {
        fxmll.load();
        
        btnCerrarModulo.setOnAction(evt -> {app.cerrarModulo();});
    }
    
    public Node getRoot()
    {
        return fxmll.getRoot();
    }
}
