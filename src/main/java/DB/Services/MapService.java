package DB.Services;

import DB.Database.Connection;
import DB.Database.MapEntity;
import DB.IMap;
import org.hibernate.Session;

import java.util.ArrayList;

public class MapService implements IMap {

    @Override
    public void getAllMaps() {
        Session session = Connection.openSession();

        String hql = "SELECT id FROM MapEntity";
        ArrayList<Integer> ids = (ArrayList<Integer>) session.createQuery(hql, Integer.class).getResultList();


        Integer[] idArray = ids.toArray(new Integer[0]);


        for (Integer id : idArray) {
            MapEntity data = session.get(MapEntity.class, id);
            printMap(data);
        }

        Connection.disconnect(session);
    }

    void printMap(MapEntity data){
        System.out.print("MapId: " + data.getMapId() +
                "\nMapSizeX: " + data.getMapSizeX() +
                "\nMapSize: " + data.getMapSize() +
                "\nMapItems: ");
    }
}
