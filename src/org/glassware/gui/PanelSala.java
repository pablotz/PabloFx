package org.glassware.gui;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 *
 * @author pablo
 */
public class PanelSala {

    @FXML
    JFXButton btnCerrarModulo;
    WindowMain app;

    FXMLLoader fxmll;

    public PanelSala(WindowMain app) {
        this.app = app;
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/gui/fxml/panel_salas.fxml"));
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

}
