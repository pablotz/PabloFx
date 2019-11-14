package org.glassware.controller;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.glassware.gui.WindowMain;

public class ControladorVentanas {

    @FXML
    AnchorPane rootPane;

    @FXML
    JFXButton btnProductos;

    @FXML
    JFXButton btnEmpleados;

    @FXML
    JFXButton btnClientes;

    @FXML
    JFXButton btnTratamientos;

    @FXML
    JFXButton btnSalas;

    @FXML
    JFXButton btnSucursales;

    @FXML
    JFXButton btnControlSala;

    @FXML
    JFXButton btnSelectFoto;

    @FXML
    ImageView imgvFoto;
    
    @FXML Pane secPane;
    
    FileChooser fc = new FileChooser();

    @FXML
    void cambiarProductos(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaProductos/ventana_productos.fxml"));
        Scene home = new Scene(parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(home);
        stage.show();
        
    }

    @FXML
    void cambiarControlSala(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaControlSalas/ventana_controlSalas.fxml"));
        Scene home = new Scene(parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(home);
        stage.show();
    }

    @FXML
    void cambiarEmpleados(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaEmpleados/ventana_empleado.fxml"));
        Scene home = new Scene(parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(home);
        stage.show();
    }

    @FXML
    void cambiarSalas(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaSalas/ventana_salas.fxml"));
        Scene home = new Scene(parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(home);
        stage.show();
    }

    @FXML
    void cambiarSucursales(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaSucursales/ventana_sucursales.fxml"));
        Scene home = new Scene(parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(home);
        stage.show();

    }

    @FXML
    void cambiarTratamientos(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaTratamientos/ventana_tratamientos.fxml"));
        Scene home = new Scene(parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(home);
        stage.show();

    }

    @FXML
    void cambiarClientes(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/glassware/fxml/ventanaClientes/ventana_clientes.fxml"));
        Scene home = new Scene(parent);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(home);
        stage.show();

    }

    @FXML
    private void seleccionarFoto(ActionEvent event) throws IOException {
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        fc.setTitle("Selecciona la foto");
        File seleccion = fc.showOpenDialog(WindowMain.window);

        if (seleccion != null) {
            Image image = new Image("file:" + seleccion.getAbsolutePath());
            imgvFoto.setImage(image);
        }

        generarBase64();
    }

    public static void generarBase64() throws UnsupportedEncodingException {
        byte[] bytes = "Hola mundo".getBytes("UTF-8");
        String encoded = Base64.getEncoder().encodeToString(bytes);
        byte[] decoded = Base64.getDecoder().decode(encoded);
        System.out.println(Arrays.toString(decoded));
    }
    
    

}
