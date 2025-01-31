package Server;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int gameIdCounter = 0;

    private int gameId;
    private int mapId;
    //TODO: Muss raus
    private int robotId;
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

    public Game(int mapId, int robotId){
        this.gameId = ++gameIdCounter;
        this.mapId = mapId;
        this.robotId = robotId;
        if(robotId !=0) {
            Player newPlayer = Player.createPlayerId(robotId);
            this.players.add(newPlayer);
        }
        if (players.size() <= 1) {
            setStatus("INITIAL");
        } else {
            setStatus("STARTED");
        }
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getRobotId() {
        return robotId;
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

    public void setRobotId(int robotId) {
        this.robotId = robotId;
    }

}
