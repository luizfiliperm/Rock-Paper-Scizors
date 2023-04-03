package models.entities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Files {

    private List<Player> players;
    private File leaderBoard = new File("Leaderboard.csv");

    // Instancia a lista de jogadores, que serão lidas do arquivo "Leaderboard.csv"
    public Files() {
        this.players = new ArrayList<>();
    }

    public List<Player> getPlayers(){
        return players;
    }

    // Vai criar o arquivo se o mesmo não existir
    public void createLeaderBoard(){

        if(!leaderBoard.exists()){
            try{
                leaderBoard.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
}
