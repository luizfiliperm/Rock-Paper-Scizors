package models.entities;


import models.enums.PlayerType;

public class Player implements Comparable<Player>{
    private String name;
    private Integer wins;
    private Integer looses;
    private Integer draws;
    private PlayerType playerType;
    
    // Esse construtor tem o intuito de criar um player "real"
    public Player(String name, Integer wins, Integer looses, Integer draws) {
        this.name = name;
        this.wins = wins;
        this.looses = looses;
        this.draws = draws;
        this.playerType = PlayerType.PERSON;
    }

    // Esse construtor tem o intuito de criar um player controlado pela máquina, onde passaremos como argumento o "PlayerType.COMPUTER"
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    // Vai comparar pelas vitórias pra ordenar no placar de líder por quem tem mais vitórias
    @Override
    public int compareTo(Player o) {
        return -wins.compareTo(o.getWins());
    }
    

}
