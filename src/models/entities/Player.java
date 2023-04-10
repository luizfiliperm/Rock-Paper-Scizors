package models.entities;


import models.enums.PlayerType;

public class Player implements Comparable<Player>{
    
    private String name;
    private Integer wins;
    private Integer looses;
    private Integer draws;
    private PlayerType playerType;

    // Construtor 
    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.playerType = playerType;
        this.wins = 0;
        this.looses = 0;
        this.draws = 0;
    }

    // Construtor que a classe Files vai utilizar
    public Player(String name, Integer wins, Integer looses, Integer draws){
        this.name = name;
        this.wins = wins;
        this.looses = looses;
        this.draws = draws;
    }

    // Cria um player "real", recebendo seu nome
    public static Player createRealPlayer(String name){
        return new Player(name, PlayerType.PERSON);
    }

    // Cria o player controlado pela máquina
    public static Player createComputerPlayer() {
        return new Player("Computador", PlayerType.COMPUTER);
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

    public void incremateWins(){
        wins++;
    }

    public void setLooses(Integer looses) {
        this.looses = looses;
    }

    public void incremateLooses(){
        looses++;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public void incremateDraws(){
        draws++;
    }


    // hashCode e equals vai comparar se um Player é igual ao outro utilizando o nome
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

    // compareTo criado para organizar a lista por quem tem mais vitórias para quem tem menos
    @Override
    public int compareTo(Player o) {
        return -wins.compareTo(o.getWins());
    }
    

}
