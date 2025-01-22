package Classes;

public class Hindernis {
    private final int hindernesX;
    private final int hindernesY;

    public Hindernis(int x, int y) {
        hindernesX = x;
        hindernesY = y;
    }

    public int getItemX() {
        return hindernesX;
    }

    public int getItemY() {
        return hindernesY;
    }

    public String getColor() {
        return "\u001B[35m";
    }

    public char getSymbol() {
        return '|';
    }
}
