package DB.Services;

import DB.Database.Connection;
import DB.Database.GameEntity;
import DB.IGame;
import org.hibernate.Session;

public class GameService implements IGame {

    @Override
    public void getGameById(int id) {
        Session session = Connection.openSession();


        GameEntity data = session.get(GameEntity.class, id);
        printGame(data);


        Connection.disconnect(session);
    }

    @Override
    public void createGame(int mapId) {
        Session session = Connection.openSession();
        session.beginTransaction();

        GameEntity game = new GameEntity();
        game.setMapId(mapId);
        session.persist(game);
    }

    @Override
    public void joinGame(int gameId, int robotId){

    }

    void printGame(GameEntity data){


        RobotService robot = new RobotService();
        System.out.println("GameId: " + data.getGameId() +
                "\nmap: " + data.getMapId() +
                "\nPLAYERS");

        System.out.println("\nMOVES");


    }
}
