package models.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import models.entities.Files;
import models.entities.Game;
import models.entities.Player;
import models.enums.Option;

public class GameController implements Initializable {

    private Game game;

    ScreenMethods sm = new ScreenMethods();

    private Files file;

    @FXML
    private Button btBack;

    @FXML
    private Button btPaper;

    @FXML
    private Button btRock;

    @FXML
    private Button btScissors;

    @FXML
    private Label lOptionP1;

    @FXML
    private Label lOptionP2;

    @FXML
    private Label lPlayer1;

    @FXML
    private Label lPlayer2;

    @FXML
    private Label lScore;

    @FXML
    private Label lwinnerName;

    @FXML
    private AnchorPane root;

    public void setGame(Game game){
        this.game = game;
    }

    @FXML
    void choosePaper(ActionEvent event) {
        peformTurn(Option.Paper);
    }

    @FXML
    void chooseRock(ActionEvent event) {
        peformTurn(Option.Rock);
    }

    @FXML
    void chooseScissors(ActionEvent event) {
        peformTurn(Option.Scissors);
    }

    @FXML
    void changeToMenuScreen(ActionEvent event) throws IOException {
        file = new Files();
        file.updateAll(game.getPlayer1(), game.getPlayer2());
        sm.changeScreen("Menu.fxml", event);
    }

    public void peformTurn(Option option){
        game.setOptionP1(option);
        game.setComputerOption();
        game.updatePlayerAtributes();
        setOptions();
        setScore();
        setWinner();
    }

    public void setScore(){
        game.incremateScore(game.getWinner());
        lScore.setText(game.getScore());
    }

    public void setWinner(){
        if(game.getWinner() == null){
            lwinnerName.setText("Empate");
        }else{
            lwinnerName.setText(game.getWinner().getName());
        }
    }

    public void setOptions(){        
        lOptionP1.setText(String.valueOf(game.getOptionP1()));
        lOptionP2.setText(String.valueOf(game.getOptionP2()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        game = new Game(Player.createRealPlayer(ChooseNameController.getPlayerName()), Player.createComputerPlayer());
        lPlayer1.setText(game.getPlayer1().getName());
        lPlayer2.setText(game.getPlayer2().getName());
        lScore.setText(game.getScore());
    }

}
