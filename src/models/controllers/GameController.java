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
    private AnchorPane root;

    @FXML
    private Button btPaper;

    @FXML
    private Button btRock;

    @FXML
    private Button btScissors;

    @FXML
    private Label lwinnerName;

    @FXML
    private Label lScore;

    @FXML
    private Label lPlayer1;

    @FXML
    private Label lPlayer2;

    public void setGame(Game game){
        this.game = game;
    }

    @FXML
    void choosePaper(ActionEvent event) {
        game.setOptionP1(Option.PAPER);
        game.setComputerOption();
        game.updatePlayerAtributes();
        setScore();
        setWinner();
    }

    @FXML
    void chooseRock(ActionEvent event) {
        game.setOptionP1(Option.ROCK);
        game.setComputerOption();
        game.updatePlayerAtributes();
        setScore();
        setWinner();
    }

    @FXML
    void chooseScissors(ActionEvent event) {
        game.setOptionP1(Option.SCISSORS);
        game.setComputerOption();
        game.updatePlayerAtributes();
        setScore();
        setWinner();
    }

    @FXML
    void changeToMenuScreen(ActionEvent event) throws IOException {
        file = new Files();
        file.updateAll(game.getPlayer1(), game.getPlayer2());
        sm.changeScreen("Menu.fxml", event);
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

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        game = new Game(Player.createRealPlayer(ChooseNameController.getPlayerName()), Player.createComputerPlayer());
        lPlayer1.setText(game.getPlayer1().getName());
        lPlayer2.setText(game.getPlayer2().getName());
        lScore.setText(game.getScore());
    }

}
