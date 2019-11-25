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

/**
 *
 * @author ximena Uribe
 */
public class PanelEmpleado {
        @FXML JFXButton btnCerrarModulo;
    WindowMain app;
    
    FXMLLoader fxmll;
    
    public PanelEmpleado(WindowMain app)
    {
        this.app = app;
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/gui/fxml/panel_empleado.fxml"));
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
