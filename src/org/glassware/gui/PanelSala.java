package org.glassware.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import org.glassware.gui.components.TableAdapterSala;
import org.glassware.model.Sala;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.glassware.model.Sucursal;
import org.glassware.task.sala.TaskSalaDelete;
import org.glassware.task.sala.TaskSalaGetAll;
import org.glassware.task.sala.TaskSalaInsert;
import org.glassware.task.sala.TaskSalaUpdate;
import org.glassware.task.sala.TaskSalasGetAllSucursales;
import org.glassware.task.sucursal.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.File;
import javafx.scene.image.ImageView;

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
    private JFXComboBox<String> cmbSucursal;

    @FXML
    private JFXTextField txtIdSala;

    @FXML
    private JFXTabPane tabpSalas;

    @FXML
    private JFXTextField txtEstatusSala;

    @FXML
    private ImageView imgvFotoSala;

    FXMLLoader fxmll;

    List<Sucursal> sucursales;

    FileChooser fileChooser = new FileChooser();

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

    public JFXComboBox getCmbSucursal() {
        return cmbSucursal;
    }

    public JFXTextField getTxtIdSala() {
        return txtIdSala;
    }

    public void setCmbSucursal(JFXComboBox cmbSucursal) {
        this.cmbSucursal = cmbSucursal;
    }

    public void consultarSala() {
        Thread hilo = null;
        TaskSalaGetAll task = new TaskSalaGetAll(app, this);

        hilo = new Thread(task);
        hilo.start();

    }

    public void setSucursales(List<Sucursal> lista) {
        sucursales = lista;
        cmbSucursal.getItems().clear();

        for (int i = 0; i < lista.size(); i++) {
            cmbSucursal.getItems().add(lista.get(i).getNombre());
        }

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
        su.setIdSucursal(cmbSucursal.getSelectionModel().getSelectedIndex());
        sa.setSucursal(su);
        sa.setFoto("");
        sa.setRutaFoto("");

        Thread hilo = null;

        TaskSalaInsert task2 = new TaskSalaInsert(app, this, sa);

        hilo = new Thread(task2);
        hilo.start();

    }

    public void consultarSucursales() {
        TaskSalasGetAllSucursales task = new TaskSalasGetAllSucursales(app, this);
        Thread hilo = new Thread(task);
        hilo.start();

    }

    public void mostrarDetalleSala() {
        Sala sa = tblSalas.getSelectionModel().getSelectedItem();
        if (sa == null) {
            limpiarCampos();
            return;
        } else {
            txtIdSala.setText("" + sa.getIdSala());
            txtIdSala.setVisible(false);
            txtNombreSala.setText("" + sa.getNombre());
            txtDescripcionSala.setText("" + sa.getDescripcion());

            txtIdSala.setVisible(false);

            for (int i = 0; i < sucursales.size(); i++) {
                if (sa.getSucursal().getIdSucursal() == sucursales.get(i).getIdSucursal()) {
                    cmbSucursal.setValue(sucursales.get(i).getNombre());
                }
            }

            int estatus = sa.getEstatus();

            if (estatus == 1) {
                txtEstatusSala.setText("Activo");
            }
            if (estatus == 2) {
                txtEstatusSala.setText("Inactivo");
            }

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
//        sa.setSucursal(cmbSucursal.getItems().get(0));

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

        consultarSucursales();
        consultarSala();
        agregarOyentes();
        txtIdSala.setDisable(true);
        tableSA.adapt(tblSalas);
        txtEstatusSala.setDisable(true);
    }

    public static String encodeToString(File imgFile) throws IOException {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        BufferedImage imagen = ImageIO.read(imgFile);

        try {
            ImageIO.write(imagen, "png", bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(imageString);
        return imageString;
    }

    public static BufferedImage decodeToImage(String imageString) {
        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public void agregarFoto() {
        btnSelectFotoSala.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Buscar Imagen");

            // Agregar filtros para facilitar la busqueda
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "."),
                    new FileChooser.ExtensionFilter("JPG", ".jpg"),
                    new FileChooser.ExtensionFilter("PNG", ".png")
            );

            Stage window = new Stage();
            // Obtener la imagen seleccionada
            File imgFile = fileChooser.showOpenDialog(window);

            // Mostar la imagen
            if (imgFile != null) {
                Image image = new Image("file:" + imgFile.getAbsolutePath());

                imgvFotoSala.setImage(image);
                try {
                    encodeToString(imgFile);
                } catch (IOException ex) {

                }
            }
        });
    }

    public void agregarOyentes() {
        tblSalas.getSelectionModel().selectedItemProperty().addListener(evt -> {
            tabpSalas.getSelectionModel().select(tabRegistrarSala);
            mostrarDetalleSala();

            txtNombreSala.setDisable(true);
            txtDescripcionSala.setDisable(true);
            cmbSucursal.setDisable(true);

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

        btnModificarSala.setOnAction(evt -> {
            txtNombreSala.setDisable(false);
            txtDescripcionSala.setDisable(false);
            cmbSucursal.setDisable(false);
        });

        btnSelectFotoSala.setOnAction(evt -> {
            agregarFoto();
        });

    }

}
