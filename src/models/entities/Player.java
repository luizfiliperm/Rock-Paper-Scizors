package models.entities;


import models.enums.PlayerType;

public class Player {
    private String name;
    private Integer wins;
    private Integer looses;
    private Integer draws;
    private PlayerType playerType;
    
    public Player(String name, Integer wins, Integer looses, Integer draws) {
        this.name = name;
        this.wins = wins;
        this.looses = looses;
        this.draws = draws;
        this.playerType = PlayerType.PERSON;
    }

    public Player(String name, Integer wins, Integer looses, Integer draws, PlayerType playerType) {
        this.name = name;
        this.wins = wins;
        this.looses = looses;
        this.draws = draws;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getLooses() {
        return looses;
    }

    public Integer getDraws() {
        return draws;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
    

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public void setLooses(Integer looses) {
        this.looses = looses;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }


}
