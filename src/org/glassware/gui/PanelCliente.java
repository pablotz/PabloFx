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
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.glassware.model.Persona;
import org.glassware.model.Usuario;


/**
 *
 * @author pablo
 */
public class PanelCliente {

    @FXML
    JFXButton btnCerrarModulo;
    WindowMain app;

    @FXML
    AnchorPane rootPane;
    
    @FXML
    private JFXTextField txtBuscarCliente;

    @FXML
    private JFXButton btnBuscarCliente;

    @FXML
    private JFXTextField txtNombreCliente;

    @FXML
    private JFXTextField txtApellidoPCliente;

    @FXML
    private JFXTextField txtApellidoMCliente;

    @FXML
    private JFXTextField txtRFCCliente;

    @FXML
    private JFXTextField txtTelefonoCliente;

    @FXML
    private JFXTextField txtUsuarioCliente;

    @FXML
    private JFXTextField txtDomicilioCliente;

    @FXML
    private JFXTextField txtCorreoCliente;

    @FXML
    private JFXComboBox<?> cmbGeneroCliente;

    @FXML
    private JFXPasswordField pswContrasenaCliente;

    @FXML
    private JFXButton btnRegistrarCliente;
    
    FXMLLoader fxmll;

    public PanelCliente(WindowMain app) {
        this.app = app;
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/gui/fxml/panel_cliente.fxml"));
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
    
    private int idCliente;
    private String numeroUnico;
    private String correo;
    private int estatus;
    private Persona idPersona;
    private Usuario idUsuario;

    public int getIdCliente() {
        return idCliente;
    }

    public String getNumeroUnico() {
        return numeroUnico;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEstatus() {
        return estatus;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }
}
