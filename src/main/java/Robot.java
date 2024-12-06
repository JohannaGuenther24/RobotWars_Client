public class Robot {
    private  String name;
    private char symbol;
    private int attackRange;
    private int attackDamage;
    private int health;
    private int x;
    private int y;
    private int movementRate;
    private String color;

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMovementRate() {
        return movementRate;
    }

    public String getColor(){
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMovementRate(int movementRate) {
        this.movementRate = movementRate;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void reduceHealth(int damagePoints){
        health = health - damagePoints;
    }

    public boolean isKnockedOut(){
        return health == 0;
    }
}
