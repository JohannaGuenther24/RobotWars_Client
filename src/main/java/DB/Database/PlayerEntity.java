package DB.Database;

import jakarta.persistence.*;

@Entity
@Table(name="Player")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PlayerId")
    private int playerId;

    @Column(name="RobotId")
    private int RobotId;

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }
}
