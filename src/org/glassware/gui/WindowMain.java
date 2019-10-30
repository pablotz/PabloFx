package org.glassware.gui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class WindowMain extends Application {

    FXMLLoader fxmll;
    Stage window;
    Scene scene;

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

    }

}
