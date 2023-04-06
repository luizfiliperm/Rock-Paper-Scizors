package models.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class MenuController {

    ScreenMethods sm = new ScreenMethods();

    @FXML
    private Button btChangeName;

    @FXML
    private Button btLeaderBoard;

    @FXML
    void changeScreenLeaderboard(ActionEvent event) throws IOException {
        sm.changeScreen("Leaderboard.fxml", event);
    }


    @FXML
    void changeScreenChooseName(ActionEvent event) throws IOException {
        sm.changeScreen("ChooseName.fxml", event);
    }
   
}
