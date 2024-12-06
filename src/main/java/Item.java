public class Item {
    private final int itemX;
    private final int itemY;

    public Item(int x, int y){
        itemX = x;
        itemY = y;
    }

    public int getItemX() {
        return itemX;
    }

    public int getItemY() {
        return itemY;
    }

    public String getColor() {
        return "\u001B[32m";
    }

    public char getSymbol() {
        return '?';
    }
}
