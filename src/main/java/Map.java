public class Map {
    private final int columns = 14;
    private final int rows = 10;
    private final String[][] map = new String[rows][columns];

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public String[][] getMap() {
        return map;
    }
}
