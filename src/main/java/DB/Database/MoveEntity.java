package DB.Database;

import jakarta.persistence.*;

@Entity
@Table(name="Moves")
public class MoveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MoveId")
    private int moveId;

    @Column(name="RobotId")
    private int robotId;

    @Column(name ="MovementType")
    private String movementType;

    @Column(name="MapIndex")
    private int mapIndex;

    @Column(name="Align")
    private String align;

    public int getMoveId() {
        return moveId;
    }

    public int getRobotId() {
        return robotId;
    }

    public String getMovementType() {
        return movementType;
    }

    public int getMapIndex() {
        return mapIndex;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getAlign() {
        return align;
    }
}
