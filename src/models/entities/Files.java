package models.entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Files {

    private List<Player> players;
    private File leaderBoard = new File("Leaderboard.csv");

    // Instancia a lista de jogadores, que serão lidas do arquivo "Leaderboard.csv"
    public Files() {
        this.players = new ArrayList<>();
        readLeaderBoard();
        
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

    // Vai ler o leaderboard e guardar os dados numa lista
    public void readLeaderBoard(){
        createLeaderBoard();
        try(BufferedReader br = new BufferedReader(new FileReader(leaderBoard))){
            String line;

            br.readLine();

            while((line = br.readLine()) != null){

                String[] fields = line.split(",");

                String name = fields[0];
                Integer wins = Integer.parseInt(fields[1]);
                Integer loses = Integer.parseInt(fields[2]);
                Integer draws = Integer.parseInt(fields[3]);

                players.add(new Player(name, wins, loses, draws));
                Collections.sort(players); // Vai organizar a lista, por quem tem mais vitórias pra quem tem menos
            }

        }catch(IOException  e){
            e.printStackTrace();
        }
    }

    // Checka se um jogador existe na lista
    public Boolean playerExists(Player player){
        if(players.contains(player)){
            return true;
        }
        return false;
    }

    // Vai atualizar o placar recebendo um player como parâmetro
    public void updateLeaderboard(Player player){
         
        if(!playerExists(player)){ // Se não existir um player com mesmo nome, vai adicionar o player na lista
            players.add(player);
        }else{
            // Se ja existir, vai apenas atualizar a lista
            for(Player p : players){
                if(p.equals(player)){
                    p.setDraws(player.getDraws());
                    p.setWins(player.getWins());
                    p.setLooses(player.getLooses());
                }
            }
        }
    }

    // Esse método vai atualizar o arquivo
    public void updateCsv(){
        // Criar o arquivo se o mesmo não existir
        createLeaderBoard();

        Collections.sort(players); // Vai organizar a lista, por quem tem mais vitórias pra quem tem menos
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(leaderBoard))){
            // Primeira linha do arquivo
            bw.write("Name,Wins,Loses,Draws");
            bw.newLine();

            // Percorre toda a lista, adcionando os players na lista
            for(Player p : players){
                bw.write(String.format("%s,%d,%d,%d", p.getName(), p.getWins(), p.getLooses(), p.getDraws()));
                bw.newLine();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
