package models.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class ChooseNameController {

    ScreenMethods sm = new ScreenMethods();

    public static String playerName;

    public void setPlayerName(String playerName){
        ChooseNameController.playerName = playerName;
    }

    public static String getPlayerName(){
        return playerName;
    }

    @FXML
    private Button btBacktoMenu;

    @FXML
    private Button btPlay;

    @FXML
    private TextField tfName;

    @FXML
    private AnchorPane root;

    @FXML
    void backToMenu(ActionEvent event) throws IOException{
        sm.changeScreen("Menu.fxml", event);
    }

    @FXML
    // Vai mudar a tela, e passar o nome do player para criar um novo jogador
    void CreateNewPlayer(ActionEvent event) throws IOException{
        setPlayerName(tfName.getText());
        sm.changeScreen("Game.fxml", event);
    }


}