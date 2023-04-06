package models.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ScreenMethods {
    
    public void changeScreen(String path, ActionEvent event) throws IOException{
        path = "../views/" + path;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        stage.setResizable(false);
        stage.setTitle("PEDRA PAPEL TESOURA");
        stage.setScene(scene);
        stage.show();
    }

}