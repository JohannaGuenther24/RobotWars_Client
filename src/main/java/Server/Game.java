package Server;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int gameIdCounter = 0;

    private int gameId;
    private int mapId;
    private int robotId;
    private List<Player> players;
    private List<Move> moves;
    private String status;

    public Game(){

    }

    public Game(int mapId, int robotId){
        this.gameId = ++gameIdCounter;
        this.mapId = mapId;
        this.robotId = robotId;
        this.players = createPlayerId(robotId);
        this.moves = addMovesToList();
        setStatus("INITIAL");
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

    public List<Player> createPlayerId(int robotId){
        List<Player> players = new ArrayList<>();
        Player player = new Player(robotId);
        players.add(player);
        return players;
    }

    public List<Move> addMovesToList(){
        List<Move> moves = new ArrayList<>();

        return moves;
    }

    public int getPlayerIdByRobotId(List<Player> players, int robotId) {
        for (Player player : players) {
            if (player.getRobotId() == robotId) {
                return player.getPlayerId();
            }
        }
        return 0;
    }
}
