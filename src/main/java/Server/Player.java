package Server;

public class Player {
    private static int idCounter = 0;

    private int robotId;
    private int playerId;

    public Player(){

    }

    public Player(int robotId){
        this.robotId = robotId;
        this.playerId = ++idCounter;
    }

    public int getRobotId() {
        return robotId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setRobotId(int robotId) {
        this.robotId = robotId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public static Player createPlayerId(int robotId){

        return new Player(robotId);
    }
}
