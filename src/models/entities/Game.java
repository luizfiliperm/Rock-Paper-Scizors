package models.entities;

import models.enums.Option;
import models.enums.PlayerType;

public class Game {
    private Player player1;
    private Player player2;
    private Option optionP1;
    private Option optionP2;
    private Integer scoreP1;
    private Integer scoreP2;
    private LeaderboardFile leaderboardFile;
    
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scoreP1 = 0;
        this.scoreP2 = 0;
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

    public Integer getScoreP1() {
        return scoreP1;
    }

    public void setScoreP1(Integer scoreP1) {
        this.scoreP1 = scoreP1;
    }

    public Integer getScoreP2() {
        return scoreP2;
    }

    public void setScoreP2(Integer scoreP2) {
        this.scoreP2 = scoreP2;
    }

    public String getScore(){
        return String.format("%d X %d", scoreP1, scoreP2);
    }

    public void incremateScore(Player winner) {
        if(winner == null){

        }
        else if(winner.equals(player1)){
            scoreP1++;
        }
        else if(winner.equals(player2)){
            scoreP2++;
        }
        
    }
    
    
    public Player getWinner(){

        if(optionP1.equals(optionP2)){
            return null;
        }
        else if(optionP1 == Option.Paper && optionP2 == Option.Rock ||
           optionP1 == Option.Rock && optionP2 == Option.Scissors ||
           optionP1 == Option.Scissors && optionP2 == Option.Paper){
            return player1;
        }else{
            return player2;
        }
    }

    // Escolhe a opção do computador
    public void setComputerOption(){
        if(player1.getPlayerType() == PlayerType.COMPUTER){
            setOptionP1(Option.getRandomOption());
        }
        if(player2.getPlayerType() == PlayerType.COMPUTER){
            setOptionP2(Option.getRandomOption());
        }
    }


    // Atualiza atributo dos players
    public void updatePlayerAtributes(){
        if(getWinner() == null){
            player1.incremateDraws();
            player2.incremateDraws();

        }
        else if(getWinner().equals(player1)){
            player1.incremateWins();
            player2.incremateLooses();

        }
        else if(getWinner().equals(player2)){
            player2.incremateWins();
            player1.incremateLooses();

        }
    }

    public void endGame(){
        leaderboardFile = new LeaderboardFile();
        leaderboardFile.updateAll(player1, player2);
    }
}
