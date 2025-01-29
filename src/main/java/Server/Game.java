package Server;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int gameIdCounter = 0;

    private int gameId;
    private int mapId;
    private int robotId;
    private List<Player> players;
    private int[] moves;
    private String status;

    public Game(){

    }

    public Game(int mapId, int robotId){
        this.gameId = ++gameIdCounter;
        this.mapId = mapId;
        players = createPlayerId(robotId);
        setStatus("INITIAL");
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

    public int[] getMoves() {
        return moves;
    }

    public String getStatus() {
        return status;
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

    public void setMoves(int[] moves) {
        this.moves = moves;
    }

    public void setRobotId(int robotId) {
        this.robotId = robotId;
    }

    public List<Player> createPlayerId(int robotId){
        List<Player> players = new ArrayList<>();
        Player player = new Player(robotId);
        players.add(player);
        return players;
    }
}
