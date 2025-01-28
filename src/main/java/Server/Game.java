package Server;

public class Game {
    private static int idCounter = 0;
    private int gameId;
    private int mapId;
    private int[] players;
    private int[] moves;
    private String status;

    public Game(){

    }

    public Game(int mapId){
        this.gameId = ++idCounter;
        this.mapId = mapId;
    }

    public int getGameId() {
        return gameId;
    }

    public int getMapId() {
        return mapId;
    }

    public int[] getPlayers() {
        return players;
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

    public void setPlayers(int[] players) {
        this.players = players;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMoves(int[] moves) {
        this.moves = moves;
    }
}
