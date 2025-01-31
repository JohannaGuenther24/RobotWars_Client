package Server;

public class Robot {
    private static int idCounter = 0;

    private int robotId;
    private  String name;
    private int attackRange;
    private int attackDamage;
    private int health;
    private int movementRate;


    public Robot(){

    }

    public Robot(String name, int health, int attackRange, int attackDamage, int movementRate){
        this.robotId = ++idCounter;
        this.name = name;
        this.attackRange = attackRange;
        this.health = health;
        this.attackDamage = attackDamage;
        this.movementRate = movementRate;
    }


    public int getId() {
        return robotId;
    }

    public String getName() {
        return name;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getHealth() {
        return health;
    }

    public int getMovementRate() {
        return movementRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMovementRate(int movementRate) {
        this.movementRate = movementRate;
    }

    public void setId(int id) {
        this.robotId = id;
    }

}
