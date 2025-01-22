package DB.Services;

import DB.Database.Connection;
import DB.Database.GameEntity;
import DB.IMove;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class MoveService implements IMove {

    @Override
    public void getMovesAfter(String gameId, String moveId) {
        Session session = Connection.openSession();
        session.beginTransaction();

        GameEntity game = session.get(GameEntity.class, gameId);

        session.getTransaction().commit();
        Connection.disconnect(session);
    }

    @Override
    public void getAllGameMoves(int gameId) {
        Session session = Connection.openSession();
        session.beginTransaction();

        Query moveId = session.createQuery("SELECT MoveId FROM Game WHERE GameId = :gameId");
        moveId.setParameter("gameId", gameId);
        List moves = moveId.list();

        for (Object move : moves) {
            System.out.println("ID: " + move);
            Query movementType = session.createQuery("SELECT MovementType FROM Move WHERE MoveID = :move");
            movementType.setParameter("move", move);
        }

        session.getTransaction().commit();
        Connection.disconnect(session);
    }
}
