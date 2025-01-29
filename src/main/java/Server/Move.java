package Server;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private static int idCounter = 0;

    private int moveId;
    private int gameId;
    private int playerId;
    private String movementType;
    private String align;
    private int mapIndex;


    public Move(){

    }

    public Move(int gameId, int playerId, String movementType, String align, int mapIndex){
        this.moveId = ++idCounter;
        this.gameId = gameId;
        this.playerId = playerId;
        this.movementType = movementType;
        this.align = align;
        this.mapIndex = mapIndex;
    }

    public int getMoveId() {
        return moveId;
    }

    public int getGameId() {
        return gameId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getMovementType() {
        return movementType;
    }

    public String getAlign() {
        return align;
    }

    public int getMapIndex() {
        return mapIndex;
    }

    public void setMoveId(int moveId) {
        this.moveId = moveId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public void setMapIndex(int mapIndex) {
        this.mapIndex = mapIndex;
    }

}
