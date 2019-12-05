/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.glassware.model.Empleado;
import org.glassware.model.Persona;
import org.glassware.model.Usuario;
import org.glassware.gui.components.TableAdapterEmpleado;
import org.glassware.task.empleado.TaskEmpleadoDelete;
import org.glassware.task.empleado.TaskEmpleadoGetAll;
import org.glassware.task.empleado.TaskEmpleadoInsert;
import org.glassware.task.empleado.TaskEmpleadoUpdate;

/**
 *
 * @author ximena Uribe
 */
public class PanelEmpleado {

    @FXML
    JFXButton btnCerrarModulo;

    WindowMain app;

    FXMLLoader fxmll;

    TaskEmpleadoGetAll task;

    public PanelEmpleado(WindowMain app) {
        this.app = app;
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

    public FXMLLoader getFxmll() {
        return fxmll;
    }
    
    @FXML
    private JFXTabPane allTabPane;
    
    @FXML
    private Tab tabEmpleados;

    @FXML
    private JFXTextField txtBuscarEmpleado;

    @FXML
    private JFXButton btnBuscarEmpleado;

    @FXML
    private TableView<Empleado> tblvEmpleados;

    @FXML
    private Tab tabMasterDetails;

    @FXML
    private ImageView imgvFotoEmpleado;

    @FXML
    private JFXButton btnAñadirFoto;

    @FXML
    private JFXButton btnRegistrarEmpleado;

    @FXML
    private JFXButton btnModificarEmpleado;

    @FXML
    private JFXButton btnGuardarEmpleado;

    @FXML
    private JFXButton btnEliminarEmpleado;

    @FXML
    private JFXComboBox<String> cmbGeneroEmpleado;

    @FXML
    private JFXTextField txtApellidoPEmpleado;

    @FXML
    private JFXTextField txtNombreEmpleado;

    @FXML
    private JFXTextField txtPuestoEmpleado;

    @FXML
    private JFXTextField txtDomicilioEmpleado;

    @FXML
    private JFXTextField txtApellidoMEmpleado;

    @FXML
    private JFXTextField txtRFCEmpleado;

    @FXML
    private JFXTextField txtTelefonoEmpleado;

    @FXML
    private JFXTextField txtNombreUsuarioEmpleado;

    @FXML
    private JFXTextField txtContraseniaEmpleado;

    @FXML
    private JFXTextField txtRolEmpleado;

    @FXML
    private JFXTextField txtNumEmpleado;

    @FXML
    private JFXTextField txtEstatusEmpleado;

    @FXML
    private JFXTextField txtIdEmpleado;

    @FXML
    private JFXTextField txtIdPersona;

    @FXML
    private JFXTextField txtIdUsuario;

    public JFXTabPane getAllTabPane() {
        return allTabPane;
    }
    
    public Tab getTabEmpleados() {
        return tabEmpleados;
    }

    public JFXTextField getTxtBuscarEmpleado() {
        return txtBuscarEmpleado;
    }

    public JFXButton getBtnBuscarEmpleado() {
        return btnBuscarEmpleado;
    }

    public TableView<Empleado> getTblvEmpleados() {
        return tblvEmpleados;
    }

    public Tab getTabMasterDetails() {
        return tabMasterDetails;
    }

    public ImageView getImgvFotoEmpleado() {
        return imgvFotoEmpleado;
    }

    public JFXButton getBtnAñadirFoto() {
        return btnAñadirFoto;
    }

    public JFXButton getBtnRegistrarEmpleado() {
        return btnRegistrarEmpleado;
    }

    public JFXButton getBtnModificarEmpleado() {
        return btnModificarEmpleado;
    }

    public JFXButton getBtnGuardarEmpleado() {
        return btnGuardarEmpleado;
    }

    public JFXButton getBtnEliminarEmpleado() {
        return btnEliminarEmpleado;
    }

    public JFXComboBox<?> getCmbGeneroEmpleado() {
        return cmbGeneroEmpleado;
    }

    public JFXTextField getTxtApellidoPEmpleado() {
        return txtApellidoPEmpleado;
    }

    public JFXTextField getTxtNombreEmpleado() {
        return txtNombreEmpleado;
    }

    public JFXTextField getTxtPuestoEmpleado() {
        return txtPuestoEmpleado;
    }

    public JFXTextField getTxtDomicilioEmpleado() {
        return txtDomicilioEmpleado;
    }

    public JFXTextField getTxtApellidoMEmpleado() {
        return txtApellidoMEmpleado;
    }

    public JFXTextField getTxtRFCEmpleado() {
        return txtRFCEmpleado;
    }

    public JFXTextField getTxtTelefonoEmpleado() {
        return txtTelefonoEmpleado;
    }

    public JFXTextField getTxtNombreUsuarioEmpleado() {
        return txtNombreUsuarioEmpleado;
    }

    public JFXTextField getTxtContraseniaEmpleado() {
        return txtContraseniaEmpleado;
    }

    public JFXTextField getTxtRolEmpleado() {
        return txtRolEmpleado;
    }

    public JFXTextField getTxtNumEmpleado() {
        return txtNumEmpleado;
    }

    public JFXTextField getTxtEstatusEmpleado() {
        return txtEstatusEmpleado;
    }

    public TableAdapterEmpleado getTableE() {
        return tableE;
    }

    public JFXTextField getTxtIdEmpleado() {
        return txtIdEmpleado;
    }

    public JFXTextField getTxtIdPersona() {
        return txtIdPersona;
    }

    public JFXTextField getTxtIdUsuario() {
        return txtIdUsuario;
    }

    public void consultarEmpleados() {
        Thread hilo = null;
        TaskEmpleadoGetAll task = new TaskEmpleadoGetAll(app, this);

        hilo = new Thread(task);
        hilo.start();
    }

    public void addEmpleado() {
        String error = validarDatos();
        if (error != null) {
            app.showAlert(error, error, Alert.AlertType.WARNING);
            return;
        }
        Persona p = new Persona();
        Usuario us = new Usuario();
        Empleado em = new Empleado();

        p.setNombre(txtNombreEmpleado.getText());
        p.setApellidoPaterno(txtApellidoPEmpleado.getText());
        p.setApellidoMaterno(txtApellidoMEmpleado.getText());

        String genero = cmbGeneroEmpleado.getSelectionModel().getSelectedItem().toString();

        if (genero.equals("Hombre")) {
            p.setGenero("M");
        }
        if (genero.equals("Mujer")) {
            p.setGenero("F");
        }
        if (genero.equals("Otro")) {
            p.setGenero("O");
        }

        p.setDomicilio(txtDomicilioEmpleado.getText());
        p.setTelefono(txtTelefonoEmpleado.getText());
        System.out.println(txtTelefonoEmpleado.getText());
        System.out.println(p.getTelefono());
        p.setRfc(txtRFCEmpleado.getText());

        us.setNombreUsuario(txtNombreUsuarioEmpleado.getText());
        us.setContrasenia(txtContraseniaEmpleado.getText());
        us.setRol(txtRolEmpleado.getText());

        em.setNumeroEmpleado("QULP000");
        em.setPuesto(txtPuestoEmpleado.getText());
        em.setFoto("FOTO");
        em.setRutaFoto("FOTO");

        em.setPersona(p);
        em.setUsuario(us);
        limpiarCampos();

        Thread hilo = null;
        TaskEmpleadoInsert task = new TaskEmpleadoInsert(app, this, em);

        hilo = new Thread(task);
        hilo.start();
    }

    public void updateEmpleado() {
        String error = validarDatosUpdate();
        if (error != null) {
            app.showAlert(error, error, Alert.AlertType.WARNING);
            return;
        }

        Persona p = new Persona();
        Usuario us = new Usuario();
        Empleado em = new Empleado();

        p.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
        p.setNombre(txtNombreEmpleado.getText());
        p.setApellidoPaterno(txtApellidoPEmpleado.getText());
        p.setApellidoMaterno(txtApellidoMEmpleado.getText());

        String genero = cmbGeneroEmpleado.getSelectionModel().getSelectedItem().toString();

        if (genero.equals("Hombre")) {
            p.setGenero("M");
        }
        if (genero.equals("Mujer")) {
            p.setGenero("F");
        }
        if (genero.equals("Otro")) {
            p.setGenero("O");
        }

        p.setDomicilio(txtDomicilioEmpleado.getText());
        p.setTelefono(txtTelefonoEmpleado.getText());
        p.setRfc(txtRFCEmpleado.getText());

        us.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
        us.setNombreUsuario(txtNombreUsuarioEmpleado.getText());
        us.setRol(txtRolEmpleado.getText());

        em.setIdEmpleado(Integer.parseInt(txtIdEmpleado.getText()));
        em.setPuesto(txtPuestoEmpleado.getText());
        em.setFoto(" ");
        em.setRutaFoto(" ");
        em.setPersona(p);
        em.setUsuario(us);
        limpiarCampos();

        Thread hilo = null;
        TaskEmpleadoUpdate task = new TaskEmpleadoUpdate(app, this, em);

        hilo = new Thread(task);
        hilo.start();
    }

    public void deleteEmpleado() {
        Empleado em = new Empleado();
        em.setIdEmpleado(Integer.parseInt(txtIdEmpleado.getText()));
        limpiarCampos();

        Thread hilo = null;
        TaskEmpleadoDelete task = new TaskEmpleadoDelete(app, this, em);

        hilo = new Thread(task);
        hilo.start();
    }

    public String validarDatos() {
        String error = null;

        if (txtNombreEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar un nombre de empleado";
        } else if (txtApellidoPEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar un apellido paterno del empleado";
        } else if (txtApellidoMEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar un apellido materno del empleado";
        } else if (txtDomicilioEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar un domicilio del empleado";
        } else if (txtPuestoEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar un puesto del empleado";
        } else if (txtTelefonoEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar un número de telefono";
        } else if (txtRFCEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar el RFC del emopleado";
        } else if (txtNombreUsuarioEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar un usuario del empleado";
        } else if (txtContraseniaEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar una contraseña del empleado";
        } else {
            try {
                Double.valueOf(txtTelefonoEmpleado.getText().trim());
            } catch (NumberFormatException nfe) {
                error = "Ingresa correctamente el número de telefono";
            }
        }
        return error;
    }

    public String validarDatosUpdate() {
        String error = null;

        if (txtNombreEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar un nombre de empleado";
        } else if (txtApellidoPEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar un apellido paterno del empleado";
        } else if (txtApellidoMEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar un apellido materno del empleado";
        } else if (txtDomicilioEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar un domicilio del empleado";
        } else if (txtPuestoEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar un puesto del empleado";
        } else if (txtTelefonoEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar un número de telefono";
        } else if (txtRFCEmpleado.getText().trim().isEmpty()) {
            error = "Debe especificar el RFC del emopleado";
        } else if (txtNombreUsuarioEmpleado.getText().trim().isEmpty()) {
            try {
                Double.valueOf(txtTelefonoEmpleado.getText().trim());
            } catch (NumberFormatException nfe) {
                error = "Ingresa correctamente el número de telefono";
            }
        }
        return error;
    }

    public void llenarCombobox() {
        cmbGeneroEmpleado.getItems().addAll("Hombre", "Mujer", "Otro");
    }

    public void agregarFoto() {
        btnAñadirFoto.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Buscar Imagen");

            // Agregar filtros para facilitar la busqueda
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.*"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );

            Stage window = new Stage();
            // Obtener la imagen seleccionada
            File imgFile = fileChooser.showOpenDialog(window);

            // Mostar la imagen
            if (imgFile != null) {
                Image image = new Image("file:" + imgFile.getAbsolutePath());
                imgvFotoEmpleado.setImage(image);
            }
        });
    }

    public void limpiarCampos() {
        txtNombreEmpleado.setText("");
        txtApellidoPEmpleado.setText("");
        txtApellidoMEmpleado.setText("");
        txtTelefonoEmpleado.setText("");
        txtDomicilioEmpleado.setText("");
        txtPuestoEmpleado.setText("");
        txtRFCEmpleado.setText("");
        txtRolEmpleado.setText("");
        txtNombreUsuarioEmpleado.setText("");
        txtNumEmpleado.setText("");
        txtContraseniaEmpleado.setText("");
        txtEstatusEmpleado.setText("");
        cmbGeneroEmpleado.setValue("");
        txtIdPersona.setText("");
        txtIdUsuario.setText("");
        txtIdEmpleado.setText("");
    }

    public void mostrarDetalleEmpleado() {
        Empleado e = tblvEmpleados.getSelectionModel().getSelectedItem();
        if (e == null) {
            desblockTxTLabel();
            limpiarCampos();
            return;
        } else {
            blockTxTLabel();
            txtNombreEmpleado.setText("" + e.getPersona().getNombre());
            txtApellidoPEmpleado.setText("" + e.getPersona().getApellidoPaterno());
            txtApellidoMEmpleado.setText("" + e.getPersona().getApellidoMaterno());
            txtTelefonoEmpleado.setText("" + e.getPersona().getTelefono());
            txtDomicilioEmpleado.setText("" + e.getPersona().getDomicilio());
            txtRFCEmpleado.setText("" + e.getPersona().getRfc());
            if (e.getPersona().getGenero().equals("M")) {
                cmbGeneroEmpleado.setValue("Hombre");
            }
            if (e.getPersona().getGenero().equals("F")) {
                cmbGeneroEmpleado.setValue("Mujer");
            }
            if (e.getPersona().getGenero().equals("O")) {
                cmbGeneroEmpleado.setValue("Otro");
            }
            txtNombreUsuarioEmpleado.setText("" + e.getUsuario().getNombreUsuario());
            txtRolEmpleado.setText("" + e.getUsuario().getRol());
            txtPuestoEmpleado.setText("" + e.getPuesto());
            txtNumEmpleado.setText("" + e.getNumeroEmpleado());
            txtEstatusEmpleado.setText("" + e.getEstatus());
            txtIdEmpleado.setText("" + e.getIdEmpleado());
            txtIdPersona.setText("" + e.getPersona().getIdPersona());
            txtIdUsuario.setText("" + e.getUsuario().getIdUsuario());
            if (e.getEstatus() == 1) {
                txtEstatusEmpleado.setText("Activa");
            } else {
                txtEstatusEmpleado.setText("Inactiva");
            }
        }
    }

    public void seleccionarEmpleado() {
        tblvEmpleados.getSelectionModel().selectedItemProperty().addListener(evt -> {
            allTabPane.getSelectionModel().select(tabMasterDetails );
            mostrarDetalleEmpleado();
        });
    }

    public void blockTxTLabel() {
        txtNombreEmpleado.setDisable(true);
        txtApellidoPEmpleado.setDisable(true);
        txtApellidoMEmpleado.setDisable(true);
        txtTelefonoEmpleado.setDisable(true);
        txtDomicilioEmpleado.setDisable(true);
        txtRFCEmpleado.setDisable(true);
        txtNombreUsuarioEmpleado.setDisable(true);
        txtNumEmpleado.setDisable(true);
        txtPuestoEmpleado.setDisable(true);
        txtRolEmpleado.setDisable(true);
        txtContraseniaEmpleado.setDisable(true);
    }

    public void desblockTxTLabel() {
        txtNombreEmpleado.setDisable(false);
        txtApellidoPEmpleado.setDisable(false);
        txtApellidoMEmpleado.setDisable(false);
        txtTelefonoEmpleado.setDisable(false);
        txtDomicilioEmpleado.setDisable(false);
        txtRFCEmpleado.setDisable(false);
        txtNombreUsuarioEmpleado.setDisable(false);
        txtPuestoEmpleado.setDisable(false);
        txtRolEmpleado.setDisable(false);
        //txtContraseniaEmpleado.setDisable(false);
    }

    TableAdapterEmpleado tableE = new TableAdapterEmpleado();

    public void noVisisbleLabel() {
        txtEstatusEmpleado.setDisable(true);
        txtNumEmpleado.setDisable(true);
        txtIdPersona.setVisible(false);
        txtIdUsuario.setVisible(false);
        txtIdEmpleado.setVisible(false);
    }

    public void inicializar() throws Exception {
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/gui/fxml/panel_empleado.fxml"));
        fxmll.setController(this);
        fxmll.load();

        llenarCombobox();

        noVisisbleLabel();

        agregarFoto();

        consultarEmpleados();
        tableE.adapt(tblvEmpleados);

        seleccionarEmpleado();

        agregarOyentes();

    }

    public void agregarOyentes() {
        btnModificarEmpleado.setOnAction(evt -> {
            desblockTxTLabel();
        });

        btnEliminarEmpleado.setOnAction(evt -> {
            deleteEmpleado();
        });

        btnRegistrarEmpleado.setOnAction(evt -> {
            addEmpleado();
        });

        btnGuardarEmpleado.setOnAction(evt -> {
            updateEmpleado();
            txtContraseniaEmpleado.setDisable(false);
        });

        btnCerrarModulo.setOnAction(evt -> {
            app.cerrarModulo();
        });
    }

}
