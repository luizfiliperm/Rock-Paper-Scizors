package models.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.application.Platform;

public class MenuController{

    ScreenMethods sm = new ScreenMethods();

    @FXML
    private Button btChooseName;

    @FXML
    private Button btLeaderBoard;

    @FXML
    private Button btQuit;

    @FXML
    void changeScreenLeaderboard(ActionEvent event) throws IOException {
        sm.changeScreen("Leaderboard.fxml", event);
    }


    @FXML
    void changeScreenChooseName(ActionEvent event) throws IOException {
        sm.changeScreen("ChooseName.fxml", event);
    }

    @FXML
    void quitGame(ActionEvent event) {
        Platform.exit();
    }

   
}
