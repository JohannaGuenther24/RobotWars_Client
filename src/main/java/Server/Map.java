package Server;

public class Map {
    private static int idCounter = 0;
    private int mapId;
    private int mapSizeX;
    private int mapSize;

    public Map(){

    }

    public Map(int mapSizeX, int mapSize){
        this.mapId = ++idCounter;
        this.mapSize = mapSize;
        this.mapSizeX = mapSizeX;
    }

    public int getMapId() {
        return mapId;
    }

    public int getMapSizeX() {
        return mapSizeX;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public void setMapSizeX(int mapSizeX) {
        this.mapSizeX = mapSizeX;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }
}
