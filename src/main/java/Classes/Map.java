package Classes;

public class Map {
    private int columns;
    private int rows;


    public Map(int breite, int hoehe) {
        this.columns = breite;
        this.rows = hoehe;

    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }


}
