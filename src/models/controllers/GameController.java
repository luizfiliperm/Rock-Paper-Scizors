package models.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import models.entities.Game;
import models.entities.Player;
import models.enums.Option;

public class GameController implements Initializable {

    private Game game;

    ScreenMethods sm = new ScreenMethods();


    @FXML
    private Button btBack;

    @FXML
    private Button btPaper;

    @FXML
    private Button btRock;

    @FXML
    private Button btScissors;

    
    @FXML
    private ImageView ivChooseP1;

    @FXML
    private ImageView ivChooseP2;

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
    void choosePaper(ActionEvent event) throws IOException{
        peformTurn(Option.Paper);
    }

    @FXML
    void chooseRock(ActionEvent event)throws IOException {
        peformTurn(Option.Rock);
    }

    @FXML
    void chooseScissors(ActionEvent event) throws IOException{
        peformTurn(Option.Scissors);
    }

    @FXML
    void changeToMenuScreen(ActionEvent event) throws IOException {
        game.endGame();
        sm.changeScreen("Menu.fxml", event);
    }

    public void peformTurn(Option option) throws IOException{
        game.setOptionP1(option);
        game.setComputerOption();
        game.updatePlayerAtributes();
        setOptions();
        setScore();
        setWinner();
    }

    public void setScore(){
        game.incrementScore(game.getWinner());
        lScore.setText(game.getScore());
    }

    public void setWinner(){
        if(game.getWinner() == null){
            lwinnerName.setText("Empate");
        }else{
            lwinnerName.setText(game.getWinner().getName());
        }
    }

    public String getPlayerOption(Player player){

        switch (player.getOption()) {
            case Scissors:
                return "tesoura";
            case Paper:
                return "papel";
            case Rock:
                return "pedra";
        }

        return null;
    }

    public Image getImageOption(String option) throws IOException{
        String path = "models/views/images/" + option + ".png";
        return new Image(path);
    }

    public void setOptions() throws IOException{
        ivChooseP1.setImage(getImageOption(getPlayerOption(game.getPlayer1())));  
        ivChooseP2.setImage(getImageOption(getPlayerOption(game.getPlayer2())));

    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        game = new Game(Player.createRealPlayer(ChooseNameController.getPlayerName()), Player.createComputerPlayer());
        lPlayer1.setText(game.getPlayer1().getName());
        lPlayer2.setText(game.getPlayer2().getName());
        lScore.setText(game.getScore());
    }

}
