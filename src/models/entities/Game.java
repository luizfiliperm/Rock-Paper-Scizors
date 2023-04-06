package models.entities;

import models.enums.Option;
import models.enums.PlayerType;

public class Game {
    private Player player1;
    private Player player2;
    private Option optionP1;
    private Option optionP2;
    
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Option getOptionP1() {
        return optionP1;
    }

    public void setOptionP1(Option optionP1) {
        this.optionP1 = optionP1;
    }

    public Option getOptionP2() {
        return optionP2;
    }

    public void setOptionP2(Option optionP2) {
        this.optionP2 = optionP2;
    }
    
    // Retorna o player vencedor, checkando as opções
    public Player getWinner(){

        if(optionP1 == optionP2){
            return null;
        }
        else if(optionP1 == Option.PAPER && optionP2 == Option.ROCK ||
           optionP1 == Option.ROCK && optionP2 == Option.SCISSORS ||
           optionP1 == Option.SCISSORS && optionP2 == Option.PAPER){
            return player1;
        }else{
            return player2;
        }
    }


    // Checka qual dos players é o computador, e define a opção baseada nisso
    public void setComputerOption(){
        if(player1.getPlayerType() == PlayerType.COMPUTER){
            setOptionP1(Option.getRandomOption());
        }
        if(player2.getPlayerType() == PlayerType.COMPUTER){
            setOptionP2(Option.getRandomOption());
        }
    }
}
