package DB.Database;

import DB.Services.GameService;
import DB.Services.RobotService;

public class Main {
    public static void main(String[] args) {
        //RobotService Methoden
        RobotService robot = new RobotService();
//        robot.getRobotById(2);
//        robot.getAllRobots();

        //MapService Methode
//        MapService map = new MapService();
//        map.getAllMaps();

        //MoveService Methode
//        MoveService move = new MoveService();
//        move.getAllGameMoves(1);

        //GameService Methoden
        GameService game = new GameService();
        game.getGameById(1);
    }
}