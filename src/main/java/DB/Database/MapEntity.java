package DB.Database;

import jakarta.persistence.*;

@Entity
@Table(name="Map")
public class MapEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MapId")
    private int mapId;

    @Column(name="MapSizeX")
    private int mapSizeX;

    @Column(name="MapSize")
    private int mapSizeY;

    @Column(name="MapItems")
    private int mapItems;

    public int getMapId() {
        return mapId;
    }

    public int getMapSizeX() {
        return mapSizeX;
    }

    public int getMapSize() {
        return mapSizeY;
    }

    public void setMapSizeX(int mapSizeX) {
        this.mapSizeX = mapSizeX;
    }

    public void setMapSize(int mapSizeY) {
        this.mapSizeY = mapSizeY;
    }

    public void setMapItems(int mapItems) {
        this.mapItems = mapItems;
    }

    public int getMapItems() {
        return mapItems;
    }
}
