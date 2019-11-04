package org.glassware.gui;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.glassware.controller.ControladorVentanas;

public class WindowMain extends Application {

    FXMLLoader fxmll;
    public static Stage window;
    Scene scene;

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
    Button button12;

    public static final Image ICONO_SPA = new Image(System.class.getResource("/resources/My Spa.png").toString());
    ControladorVentanas cv = new ControladorVentanas();

    public WindowMain() {
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/fxml/ventanaPrincipal/ventana_principal.fxml"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        fxmll.load();

        scene = new Scene(fxmll.getRoot());

        window = primaryStage;

        window.setScene(scene);

        window.show();
        window.getIcons().add(ICONO_SPA);

    }

}
