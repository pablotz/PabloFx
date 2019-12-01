/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassware.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import org.glassware.model.Empleado;
import org.glassware.model.Persona;
import org.glassware.model.Usuario;
import org.glassware.task.empleado.TableAdapterEmpleado;
import org.glassware.task.empleado.TaskEmpleadoGetAll;
import org.glassware.task.empleado.TaskEmpleadoInsert;

/**
 *
 * @author ximena Uribe
 */
public class PanelEmpleado {

    @FXML
    JFXButton btnCerrarModulo;
    WindowMain app;

    FXMLLoader fxmll;

    @FXML
    private Tab tabEmpleados;
    
    @FXML
    private TableView<Empleado> tblvEmpleados;

    @FXML
    private JFXTextField txtBuscarEmpleado;

    @FXML
    private JFXButton btnBuscarEmpleado;

    @FXML
    private Tab tabMasterDetails;

    @FXML
    private JFXButton btnRegistrarEmpleado;

    @FXML
    private JFXButton btnEliminarEmpleado;

    @FXML
    private JFXComboBox<?> cmbGeneroEmpleado;
    
    @FXML
    private JFXComboBox<?> cmbRolEmpleado;

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

    public Tab getTabEmpleados() {
        return tabEmpleados;
    }

    public TableView<Empleado> getTblvEmpleados() {
        return tblvEmpleados;
    }
    
    public JFXTextField getTxtBuscarEmpleado() {
        return txtBuscarEmpleado;
    }

    public JFXButton getBtnBuscarEmpleado() {
        return btnBuscarEmpleado;
    }

    public Tab getTabMasterDetails() {
        return tabMasterDetails;
    }

    public JFXButton getBtnRegistrarEmpleado() {
        return btnRegistrarEmpleado;
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
    
    
    
    public void consultarEmpleados() {
        Thread hilo = null;
        TaskEmpleadoGetAll task = new TaskEmpleadoGetAll(app, this);

        hilo = new Thread(task);
        hilo.start();

    }

    public void addSucursales() {
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
            //p.setGenero(cmbGeneroEmpleado);   ASIGNAR VALORES
            p.setDomicilio(txtDomicilioEmpleado.getText());
            p.setTelefono(txtTelefonoEmpleado.getText());
            p.setRfc(txtRFCEmpleado.getText());

            us.setNombreUsuario(txtNombreUsuarioEmpleado.getText());
            us.setContrasenia(txtContraseniaEmpleado.getText());
            //us.setRol(cmbRolEmpleado); ASIGNAR VALORES

            // em.setNumeroEmpleado(); IMPLEMENTAR MÉTODO
             em.setPuesto(txtPuestoEmpleado.getText());
            //em.setFoto();     IMPLEMENTAR MÉTODO
            //em.setRutaFoto(rutaFoto); IMPLEMENTAR MÉTODO
            em.setIdPersona(p);
            em.setIdUsuario(us);
        
        Thread hilo = null;
        TaskEmpleadoInsert task = new TaskEmpleadoInsert(app, this, em);

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

    
    public void inicializar() throws Exception {
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/gui/fxml/panel_empleado.fxml"));
        fxmll.setController(this);
        fxmll.load();
        
        consultarEmpleados();
        TableAdapterEmpleado.adapt(tblvEmpleados);
        
        btnCerrarModulo.setOnAction(evt -> {
            app.cerrarModulo();
        });
    }

}
