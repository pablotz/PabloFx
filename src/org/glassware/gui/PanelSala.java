package org.glassware.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import org.glassware.gui.components.TableAdapterSala;
import org.glassware.model.Sala;
import javafx.scene.control.Tab;
import org.glassware.model.Sucursal;
import org.glassware.task.sala.TaskSalaDelete;
import org.glassware.task.sala.TaskSalaGetAll;
import org.glassware.task.sala.TaskSalaInsert;
import org.glassware.task.sala.TaskSalaUpdate;

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
    private TableView<Sala> tblSalas;

    @FXML
    private Tab tabSalas;

    @FXML
    private Tab tabRegistrarSala;

    @FXML
    private JFXComboBox cmbEstatus;

    @FXML
    private JFXComboBox<Sucursal> cmbSucursal;

    @FXML
    private JFXTextField txtIdSala;

    @FXML
    private JFXTabPane tabpSalas;

    FXMLLoader fxmll;

    public PanelSala(WindowMain app) {
        this.app = app;
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/gui/fxml/panel_salas.fxml"));
        fxmll.setController(this);
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

    public FXMLLoader getFxmll() {
        return fxmll;
    }

    public TableView<Sala> getTblSalas() {
        return tblSalas;
    }

    public JFXComboBox getCmbEstatus() {
        return cmbEstatus;
    }

    public JFXComboBox<Sucursal> getCmbSucursal() {
        return cmbSucursal;
    }

    public JFXTextField getTxtIdSala() {
        return txtIdSala;
    }

    public void consultarSala() {
        Thread hilo = null;
        TaskSalaGetAll task = new TaskSalaGetAll(app, this);

        hilo = new Thread(task);
        hilo.start();

    }

    TableAdapterSala tableSA = new TableAdapterSala();

    public String validarDatosSala() {
        String error = null;

        if (txtNombreSala.getText().trim().isEmpty()) {
            error = "Debe especificar un nombre de sala";
        } else if (txtDescripcionSala.getText().trim().isEmpty()) {
            error = "Debe especificar una descripción";
            //  } else if (txtSucursalSala.getText().trim().isEmpty()) {
            //       error = "Debe espicificar una sucursal a la sala";
        }
        return error;
    }

    public void addSala() {
        String error = validarDatosSala();

        if (error != null) {
            app.showAlert("Datos incorrectos", error, Alert.AlertType.WARNING);
            return;
        }
        Sala sa = new Sala();
        Sucursal su = new Sucursal();

        sa.setNombre(txtNombreSala.getText());
        sa.setDescripcion(txtDescripcionSala.getText());
        //su.setIdSucursal(Integer.parseInt(txtSucursalSala.getText()));
        sa.setSucursal(su);
        sa.setFoto("");

        Thread hilo = null;

        TaskSalaInsert task2 = new TaskSalaInsert(app, this, sa);

        hilo = new Thread(task2);
        hilo.start();

    }

    private void llenarComboBox() {
        cmbEstatus.getItems().addAll("Activo", "Inactivo");
    }

    private void bloquearComponentes() {
        txtNombreSala.setDisable(true);
        txtDescripcionSala.setDisable(true);
        cmbEstatus.setDisable(true);
        cmbSucursal.setDisable(true);

        btnModificarSala.setOnAction(evt -> {
            txtNombreSala.setDisable(false);
            txtDescripcionSala.setDisable(false);
            cmbEstatus.setDisable(false);
            cmbSucursal.setDisable(false);
        });

    }

    public void mostrarDetalleProducto() {
        Sala sa = tblSalas.getSelectionModel().getSelectedItem();
        if (sa == null) {
            limpiarCampos();
            return;
        } else {
            txtIdSala.setText("" + sa.getIdSala());
            txtIdSala.setVisible(false);
            txtNombreSala.setText("" + sa.getNombre());
            txtDescripcionSala.setText("" + sa.getDescripcion());
            //cmbEstatus.setText("" + sa.getEstatus());

            if (sa.getEstatus() == 1) {

            } else {

            }

        }
    }

    public void updateSala() {
        String error = validarDatosSala();

        if (error != null) {
            app.showAlert("Datos Incorrectos", error, Alert.AlertType.ERROR);
            return;
        }

        Thread hilo = null;
        Sala sa = new Sala();

        sa.setIdSala(Integer.parseInt(txtIdSala.getText()));
        sa.setNombre(txtNombreSala.getText());
        sa.setDescripcion(txtDescripcionSala.getText());
        sa.setEstatus((int) cmbEstatus.getItems().get(0));
        sa.setSucursal(cmbSucursal.getItems().get(0));

        TaskSalaUpdate task2 = new TaskSalaUpdate(app, this, sa);
        hilo = new Thread(task2);
        hilo.start();
    }

    public void deleteSala() {
        String error = validarDatosSala();

        if (error != null) {
            app.showAlert("Sleeciona una persona", error, Alert.AlertType.WARNING);
            return;
        }
        Thread hilo = null;
        Sala sa = new Sala();

        sa.setIdSala(Integer.parseInt(txtIdSala.getText()));
        sa.setNombre(txtNombreSala.getText());
        sa.setDescripcion(txtDescripcionSala.getText());

        TaskSalaDelete task2 = new TaskSalaDelete(app, this, sa);

        hilo = new Thread(task2);
        hilo.start();
    }

    public void limpiarCampos() {

        txtDescripcionSala.setText("");
        txtNombreSala.setText("");
    }

    public void inicializar() throws Exception {
        fxmll.load();
        llenarComboBox();
        consultarSala();
        bloquearComponentes();
        agregarOyentes();
        tableSA.adapt(tblSalas);
    }

    public void agregarOyentes() {
        tblSalas.getSelectionModel().selectedItemProperty().addListener(evt -> {
            tabpSalas.getSelectionModel().select(tabRegistrarSala);
            mostrarDetalleProducto();
        });

        btnCerrarModulo.setOnAction(evt -> {
            app.cerrarModulo();
        });

        btnRegistrarSala.setOnAction(evt -> {
            addSala();
        });

        btnEliminarSala.setOnAction(evt -> {
            deleteSala();
        });

    }

}
