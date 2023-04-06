package models.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.entities.Files;
import models.entities.Player;

public class LeaderboardController implements Initializable {

    ScreenMethods sm = new ScreenMethods();

    @FXML
    private AnchorPane root;

    @FXML
    private Button BtBack;
    
    @FXML
    private TableView<Player> tbLeaderboard;

    @FXML
    private TableColumn<Player, String> cDraw;

    @FXML
    private TableColumn<Player, Integer> cLoose;

    @FXML
    private TableColumn<Player, Integer> cName;

    @FXML
    private TableColumn<Player, Integer> cWin;    

    @FXML
    private Label tittle;

    private ObservableList<Player> items = FXCollections.observableArrayList();


    @FXML
    void backToMenu(ActionEvent event) throws IOException {
        sm.changeScreen("Menu.fxml", event);
    }


    @Override
    public void initialize(URL url, ResourceBundle resources){
        Files players = new Files();

        if(items.isEmpty()){
            items.addAll(players.getPlayers());
            
            cName.setCellValueFactory(new PropertyValueFactory<>("name"));
            cWin.setCellValueFactory(new PropertyValueFactory<>("wins"));
            cLoose.setCellValueFactory(new PropertyValueFactory<>("looses"));
            cDraw.setCellValueFactory(new PropertyValueFactory<>("draws"));
            
            tbLeaderboard.setItems(items);
        }
        players.updateCsv();
    }

}
