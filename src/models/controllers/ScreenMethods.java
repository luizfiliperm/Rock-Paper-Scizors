package models.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ScreenMethods {
    
    public void changeScreen(String path, ActionEvent event) throws IOException{
        path = "../views/" + path;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        Image icon = new Image(getClass().getResourceAsStream("../views/images/tesoura.png"));

        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setTitle("PEDRA PAPEL TESOURA");
        stage.setScene(scene);
        stage.show();
    }

    public void openPopup(String path) throws IOException{
        path = "../views/" + path;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage popup = new Stage();
        
        Image icon = new Image(getClass().getResourceAsStream("../views/images/tesoura.png"));

        
        popup.getIcons().add(icon);
        popup.setResizable(false);
        popup.setTitle("PEDRA PAPEL TESOURA");
        popup.setScene(scene);
        popup.show();
    }
}
