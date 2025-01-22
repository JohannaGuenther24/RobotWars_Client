package DB.Database;

import jakarta.persistence.*;

@Entity
@Table(name="MapItem")
public class MapItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MapItemId")
    private int mapItemId;

    @Column(name="MapId")
    private int mapId;

    @Column(name="Type")
    private int type;

    public int getIndexPos() {
        return indexPos;
    }

    public int getMapItemId() {
        return mapItemId;
    }

    public int getMapId() {
        return mapId;
    }

    public int getType() {
        return type;
    }

    @Column(name="IndexPos")
    private int indexPos;

    public void setType(int type) {
        this.type = type;
    }

    public void setIndexPos(int indexPos) {
        this.indexPos = indexPos;
    }
}
