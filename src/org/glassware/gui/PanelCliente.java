/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.gui;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.glassware.gui.components.*;
import org.glassware.model.Cliente;
import org.glassware.model.Persona;
import org.glassware.model.Usuario;
import org.glassware.task.cliente.TaskClienteDelete;
import org.glassware.task.cliente.TaskClienteGetAll;
import org.glassware.task.cliente.TaskClienteInsert;
import org.glassware.task.cliente.TaskClienteUpdate;
import javafx.scene.control.Tab;

public class PanelCliente {

    public PanelCliente(WindowMain app) {
        this.app = app;
    }

    @FXML
    private JFXButton btnCerrarModulo;
    private WindowMain app;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXTextField txtBuscarCliente;

    @FXML
    private JFXButton btnBuscarCliente;

    @FXML
    private TableView<Cliente> tblvClientes;

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
    private JFXComboBox cmbGeneroCliente;

    @FXML
    private JFXPasswordField pswContrasenaCliente;

    @FXML
    private JFXButton btnRegistrarCliente;

    @FXML
    private JFXTextField txtidCliente;

    @FXML
    private JFXTextField txtEstatusCliente;

    @FXML
    private JFXTextField txtNumeroUCliente;

    @FXML
    private JFXTabPane tabpClientes;

    @FXML
    private Tab tabRegistrarClientes;

    public JFXButton getBtnLimpiar() {
        return btnLimpiar;
    }
    @FXML
    private JFXButton btnLimpiar;

    private FXMLLoader fxmll;

    public Node getRoot() {
        return fxmll.getRoot();
    }

    public JFXButton getBtnCerrarModulo() {
        return btnCerrarModulo;
    }

    public WindowMain getApp() {
        return app;
    }

    public AnchorPane getRootPane() {
        return rootPane;
    }

    public FXMLLoader getFxmll() {
        return fxmll;
    }

    public JFXTextField getTxtBuscarCliente() {
        return txtBuscarCliente;
    }

    public JFXButton getBtnBuscarCliente() {
        return btnBuscarCliente;
    }

    public TableView<Cliente> getTblvClientes() {
        return tblvClientes;
    }

    public JFXTextField getTxtNombreCliente() {
        return txtNombreCliente;
    }

    public JFXTextField getTxtApellidoPCliente() {
        return txtApellidoPCliente;
    }

    public JFXTextField getTxtApellidoMCliente() {
        return txtApellidoMCliente;
    }

    public JFXTextField getTxtRFCCliente() {
        return txtRFCCliente;
    }

    public JFXTextField getTxtTelefonoCliente() {
        return txtTelefonoCliente;
    }

    public JFXTextField getTxtUsuarioCliente() {
        return txtUsuarioCliente;
    }

    public JFXTextField getTxtDomicilioCliente() {
        return txtDomicilioCliente;
    }

    public JFXTextField getTxtCorreoCliente() {
        return txtCorreoCliente;
    }

    public JFXComboBox getCmbGeneroCliente() {
        return cmbGeneroCliente;
    }

    public JFXPasswordField getPswContrasenaCliente() {
        return pswContrasenaCliente;
    }

    public JFXButton getBtnRegistrarCliente() {
        return btnRegistrarCliente;
    }

    public JFXTextField getTxtidCliente() {
        return txtidCliente;
    }

    public JFXTextField getTxtNumeroUCliente() {
        return txtNumeroUCliente;
    }
    @FXML
    private JFXButton btnModificarCliente;

    @FXML
    private JFXButton btnGuardarCliente;

    @FXML
    private JFXButton btnEliminarCliente;

    public JFXButton getBtnModificarCliente() {
        return btnModificarCliente;
    }

    public JFXButton getBtnGuardarCliente() {
        return btnGuardarCliente;
    }

    public JFXButton getBtnEliminarCliente() {
        return btnEliminarCliente;
    }

    public void consultarClientes() {
        Thread hilo = null;
        TaskClienteGetAll task = new TaskClienteGetAll(app, this);

        hilo = new Thread(task);
        hilo.start();

    }

    public void addCliente() {
        String error = validarDatos();
        if (error != null) {
            app.showAlert("Datos incorrectos", error, Alert.AlertType.WARNING);
            return;
        }

        Cliente c = new Cliente();
        Persona p = new Persona();
        Usuario u = new Usuario();
        p.setNombre(txtNombreCliente.getText());
        p.setApellidoPaterno(txtApellidoPCliente.getText());
        p.setApellidoMaterno(txtApellidoMCliente.getText());
        String genero = cmbGeneroCliente.getSelectionModel().getSelectedItem().toString();
        if (genero.equals("M")) {
            p.setGenero("M");
        }
        if (genero.equals("F")) {
            p.setGenero("F");
        }
        if (genero.equals("O")) {
            p.setGenero("O");
        }
        p.setRfc(txtRFCCliente.getText());
        p.setDomicilio(txtDomicilioCliente.getText());
        p.setTelefono(txtTelefonoCliente.getText());
        u.setContrasenia(pswContrasenaCliente.getText());
        u.setNombreUsuario(txtUsuarioCliente.getText());
        c.setCorreo(txtCorreoCliente.getText());
        c.setNumeroUnico(txtNumeroUCliente.getText());
//        GeneracionNumero g = new GeneracionNumero();
//        if (txtRFCCliente.getText() == null) {
//
//            c.setNumeroUnico(g.numeroCliente(p.getNombre(), p.getApellidoPaterno(), p.getApellidoMaterno()));
//        } else {
//            c.setNumeroUnico(g.numeroClienteRFC(p.getRfc()));
//        }
        String rol = "Cliente";
        u.setRol(rol);// todos los clientes tienen el mismo rol (cliente)
        c.setPersona(p);
        c.setUsuario(u);

        Thread hilo = null;
        TaskClienteInsert tci = new TaskClienteInsert(app, this, c);
        System.out.println(u.getRol());
        hilo = new Thread(tci);
        hilo.start();

    }

    public String validarDatos() {
        String error = null;
        if (txtNombreCliente.getText().trim().isEmpty()) {
            error = "Debe de especificar un nombre de cliente";
        } else if (txtApellidoPCliente.getText().trim().isEmpty()) {
            error = "Debe de especificar el apellido paterno del cliente";
        } else if (txtApellidoMCliente.getText().trim().isEmpty()) {
            error = "Debe de especificar el apellido materno del cliente";
        } else if (cmbGeneroCliente.getItems().isEmpty()) {
            error = "Debe de especificar el genero del cliente";
        } else if (txtTelefonoCliente.getText().trim().isEmpty()) {
            error = "Debe de especificar el telefono del cliente";
            //} else if (txtRFCCliente.getText().trim().isEmpty()) {
            //  error = "Debe de especificar el RFC del cliente";
        } else if (txtCorreoCliente.getText().trim().isEmpty()) {
            error = "Debe de especificar el correo del cliente";
        } else {
            try {
                Double.valueOf(txtTelefonoCliente.getText().trim());
            } catch (NumberFormatException nfe) {
                error = "Captura solo el numero de telefono sin letras ni simbolos " + nfe.toString();
            }
        }
        return error;
    }

    TableAdapterClientes TableC = new TableAdapterClientes();

    public void inicializar() throws Exception {
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/gui/fxml/panel_cliente.fxml"));
        fxmll.setController(this);
        fxmll.load();
        agregarOyentes();
        TableC.adapt(tblvClientes);
        consultarClientes();

        llenarComboBoxes();
    }

    public void agregarOyentes() {
        btnCerrarModulo.setOnAction(evt -> {
            app.cerrarModulo();
        });

        btnRegistrarCliente.setOnAction(evt -> {
            addCliente();
        });
        btnGuardarCliente.setOnAction(evt -> {
            updateCliente();
        });
        btnModificarCliente.setOnAction(evt -> {
            desblockTxTLabel();
        });

        btnEliminarCliente.setOnAction(evt -> {
            deleteCliente();
        });

        tblvClientes.getSelectionModel().selectedItemProperty().addListener(evt -> {
            tabpClientes.getSelectionModel().select(tabRegistrarClientes);
            mostrarDetalleCliente();
        });
        btnLimpiar.setOnAction(evt -> {
            limpiarCampos();
        });

    }

    private void llenarComboBoxes() {  //llenamos los comboBox con los datos que queremos que salgan
        cmbGeneroCliente.getItems().addAll("Hombre", "Mujer", "Otro"); //aqui obtenemos los items y agregamos los nombres
    }

    public void mostrarDetalleCliente() {
        Cliente c = tblvClientes.getSelectionModel().getSelectedItem();
        if (c == null) {
            limpiarCampos();
            return;
        } else {
            limpiarCampos();
            blockTxTLabel();
            txtNombreCliente.setText("" + c.getPersona().getNombre());
            txtApellidoPCliente.setText("" + c.getPersona().getApellidoPaterno());
            txtApellidoMCliente.setText("" + c.getPersona().getApellidoMaterno());
            if (c.getPersona().genero.equals("M")) {
                cmbGeneroCliente.setValue("Hombre");
            }
            if (c.getPersona().genero.equals("M")) {
                cmbGeneroCliente.setValue("Mujer");
            }
            if (c.getPersona().genero.equals("O")) {
                cmbGeneroCliente.setValue("Otro");
            }
            txtDomicilioCliente.setText("" + c.getPersona().getDomicilio());
            txtRFCCliente.setText("" + c.getPersona().getRfc());
            txtTelefonoCliente.setText("" + c.getPersona().getTelefono());
            txtUsuarioCliente.setText("" + c.getUsuario().getNombreUsuario());
            txtCorreoCliente.setText("" + c.getCorreo());
            pswContrasenaCliente.setText("" + c.getUsuario().getContrasenia());
            txtNumeroUCliente.setText("" + c.getNumeroUnico());
            if (c.getEstatus() == 1) {
                txtEstatusCliente.setText("Activo");
            } else {
                txtEstatusCliente.setText("Inactivo");
            }
        }
        System.out.println(c.getEstatus());
        System.out.println("rol" + c.getUsuario().getRol());

    }

    public void limpiarCampos() {
        txtNombreCliente.setText("");
        txtApellidoPCliente.setText("");
        txtApellidoMCliente.setText("");
        txtCorreoCliente.setText("");
        txtDomicilioCliente.setText("");
        txtRFCCliente.setText("");
        txtTelefonoCliente.setText("");
        txtUsuarioCliente.setText("");
        pswContrasenaCliente.setText("");
        cmbGeneroCliente.setValue("");
        txtNumeroUCliente.setText("");
        txtEstatusCliente.setText("");
    }

    public JFXTextField getTxtEstatusCliente() {
        return txtEstatusCliente;
    }

    public void updateCliente() {
        String error = validarDatos();
        if (error != null) {
            app.showAlert("Datos incorrectos", error, Alert.AlertType.WARNING);
            return;
        }
        Thread hilo = null;
        Cliente c = new Cliente();
        Persona p = new Persona();
        Usuario u = new Usuario();

        c.setIdCliente(tblvClientes.getSelectionModel().getSelectedItem().getIdCliente());
        c.setNumeroUnico(txtNumeroUCliente.getText());
        c.setCorreo(txtCorreoCliente.getText());

        p.setIdPersona(tblvClientes.getSelectionModel().getSelectedItem().getPersona().getIdPersona());
        p.setNombre(txtNombreCliente.getText());
        p.setApellidoPaterno(txtApellidoPCliente.getText());
        p.setApellidoMaterno(txtApellidoMCliente.getText());
        String genero = cmbGeneroCliente.getSelectionModel().getSelectedItem().toString();
        if (genero.equals("Hombre")) {
            p.setGenero("H");
        }
        if (genero.equals("Mujer")) {
            p.setGenero("M");
        }
        if (genero.equals("Otro")) {
            p.setGenero("O");
        }
        p.setDomicilio(txtDomicilioCliente.getText());
        p.setTelefono(txtTelefonoCliente.getText());
        p.setRfc(txtRFCCliente.getText());

        u.setIdUsuario(tblvClientes.getSelectionModel().getSelectedItem().getUsuario().getIdUsuario());
        u.setNombreUsuario(txtUsuarioCliente.getText());
        u.setContrasenia(pswContrasenaCliente.getText());
        u.setRol(tblvClientes.getSelectionModel().getSelectedItem().getUsuario().getRol());
        c.setPersona(p);
        c.setUsuario(u);

        TaskClienteUpdate tcu = new TaskClienteUpdate(app, this, c);

        hilo = new Thread(tcu);
        hilo.start();

    }

    public void deleteCliente() {
        Cliente c = new Cliente();
        c.setIdCliente(tblvClientes.getSelectionModel().getSelectedItem().getIdCliente());

        Thread hilo = null;
        TaskClienteDelete tcd = new TaskClienteDelete(app, this, c);

        hilo = new Thread(tcd);
        hilo.start();

    }

    public void blockTxTLabel() {
        txtNombreCliente.setDisable(true);
        txtApellidoPCliente.setDisable(true);
        txtApellidoMCliente.setDisable(true);
        txtCorreoCliente.setDisable(true);
        txtDomicilioCliente.setDisable(true);
        txtRFCCliente.setDisable(true);
        txtTelefonoCliente.setDisable(true);
        txtUsuarioCliente.setDisable(true);
        pswContrasenaCliente.setDisable(true);
        cmbGeneroCliente.setDisable(true);
        txtNumeroUCliente.setDisable(true);
        txtEstatusCliente.setDisable(true);

    }

    public void desblockTxTLabel() {
        txtNombreCliente.setDisable(false);
        txtApellidoPCliente.setDisable(false);
        txtApellidoMCliente.setDisable(false);
        txtCorreoCliente.setDisable(false);
        txtDomicilioCliente.setDisable(false);
        txtRFCCliente.setDisable(false);
        txtTelefonoCliente.setDisable(false);
        txtUsuarioCliente.setDisable(false);
        pswContrasenaCliente.setDisable(false);
        cmbGeneroCliente.setDisable(false);
        txtNumeroUCliente.setDisable(false);
        txtEstatusCliente.setDisable(false);

    }

}
