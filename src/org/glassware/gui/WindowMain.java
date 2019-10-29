package org.glassware.gui;


import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class WindowMain extends Application {

    FXMLLoader fxmll;
    Stage window;
    Scene scene;
    
    


    public WindowMain() {
        fxmll = new FXMLLoader(System.class.getResource("/org/glassware/fxml/ventana_principal.fxml"));
        fxmll.setController(this);
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

