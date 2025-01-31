package Server;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int gameIdCounter = 0;

    private int gameId;
    private int mapId;
    private List<Player> players = new ArrayList<>();;
    private List<Move> moves = new ArrayList<>();;
    private String status;

    public Game(){

    }

    public Game(int mapId){
        this.gameId = ++gameIdCounter;
        this.mapId = mapId;
        setStatus("INITIAL");
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getGameId() {
        return gameId;
    }

    public int getMapId() {
        return mapId;
    }

    public String getStatus() {
        return status;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
