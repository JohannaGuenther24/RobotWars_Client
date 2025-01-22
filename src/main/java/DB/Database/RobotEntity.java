package DB.Database;


import jakarta.persistence.*;

@Entity
@Table(name = "Robot")
public class RobotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RobotId")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Health")
    private int health;

    @Column(name = "AttackDamage")
    private int attackDamage;

    @Column(name = "AttackRange")
    private int attackRange;

    @Column(name = "MovementRate")
    private int movementRate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getMovementRate() {
        return movementRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public void setMovementRate(int movementRate) {
        this.movementRate = movementRate;
    }
}
