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
    
    public AnchorPane getRooPane(){
        return rootPane;
    }

}
