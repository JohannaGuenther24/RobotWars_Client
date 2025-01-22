package DB.Database;

import jakarta.persistence.*;

@Entity
@Table(name="Game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GameId")
    private int gameId;

    @Column(name="MapId")
    private int mapId;

    @Column(name="RobotId")
    private int robotId;

    @Column(name="MoveId")
    private int moveId;

    @Column(name="Status")
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public int getGameId() {
        return gameId;
    }

    public int getMapId() {
        return mapId;
    }

    public int getRobotId() {
        return robotId;
    }

    public int getMoveId() {
        return moveId;
    }


}
