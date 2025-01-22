package DB.Services;

import DB.Database.Connection;
import DB.Database.MapItemEntity;
import DB.IMapItem;
import org.hibernate.Session;

import java.util.ArrayList;

public class MapItemService implements IMapItem {

    @Override
    public void getAllMapItems() {
        Session session = Connection.openSession();

        String hql = "SELECT id FROM MapEntity";
        ArrayList<Integer> ids = (ArrayList<Integer>) session.createQuery(hql, Integer.class).getResultList();


        Integer[] idArray = ids.toArray(new Integer[0]);


        for (Integer id : idArray) {
            MapItemEntity data = session.get(MapItemEntity.class, id);

        }

        Connection.disconnect(session);
    }
}
