package org.glassware.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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
    
        @FXML
    private JFXTextField txtBuscarSala;

    @FXML
    private JFXButton btnBuscarSala;

    @FXML
    private JFXButton btnGuardarSala;

    @FXML
    private JFXButton btnEliminarSala;

    @FXML
    private JFXButton btnModificarSala;

    @FXML
    private JFXButton btnRegistrarSala;

    @FXML
    private JFXButton btnSelectFotoSala;

    @FXML
    private JFXTextField txtNombreSala;

    @FXML
    private JFXTextArea txtDescripcionSala;

    @FXML
    private JFXTextField txtEstatusSala;

    @FXML
    private JFXTextField txtSucursalSala;

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

    public JFXButton getBtnCerrarModulo() {
        return btnCerrarModulo;
    }

    public WindowMain getApp() {
        return app;
    }

    public JFXTextField getTxtBuscarSala() {
        return txtBuscarSala;
    }

    public JFXButton getBtnBuscarSala() {
        return btnBuscarSala;
    }

    public JFXButton getBtnGuardarSala() {
        return btnGuardarSala;
    }

    public JFXButton getBtnEliminarSala() {
        return btnEliminarSala;
    }

    public JFXButton getBtnModificarSala() {
        return btnModificarSala;
    }

    public JFXButton getBtnRegistrarSala() {
        return btnRegistrarSala;
    }

    public JFXButton getBtnSelectFotoSala() {
        return btnSelectFotoSala;
    }

    public JFXTextField getTxtNombreSala() {
        return txtNombreSala;
    }

    public JFXTextArea getTxtDescripcionSala() {
        return txtDescripcionSala;
    }

    public JFXTextField getTxtEstatusSala() {
        return txtEstatusSala;
    }

    public JFXTextField getTxtSucursalSala() {
        return txtSucursalSala;
    }

    public FXMLLoader getFxmll() {
        return fxmll;
    }
    
    
    
    
    

}
