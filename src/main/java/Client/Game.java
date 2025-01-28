package Client;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class Game {
    static View view = new View();
    static RequestGame rg = new RequestGame();
    static RequestMap rma = new RequestMap();
    static RequestMove rmo = new RequestMove();
    static RequestRobot rr = new RequestRobot();

    //Vorerst vorgegebene Map, da nur eine existiert
    static String mapId = "d2d0b803-955d-4367-8fdd-c8c3f94fecbb";

    //Vorerst vorgegebenen Gegner
    static String enemyId = "7ed1e65c-b560-4599-864c-0e2458fdcf08";
    static String enemyPlayerId = "";
    static int enemyMovementPoints = 0;
    static int MapIndexPlayer;
    static String align;

    static String robotId = "fe833182-9ef0-4025-b8e0-7ee859e30c94";
    static String robotPlayerId = "";
    static int robotMovementPoints = 0;

    static String gameId = "810492bf-820c-4a73-a886-3f7722e3c3bf";

    public static void main(String[] args) throws IOException, InterruptedException {


//        view.intro();
//
//        int decision = view.createOrChooseRobot();
//        if (decision == 1){
//            robotId = view.createRobot();
//        } else if (decision == 2){
//            view.viewRobots();
//            robotId = view.chooseRobot();
//        }
//
//
//        JSONObject JSONData = rg.postNewGame(mapId);
//
//
//        if (JSONData != null) {
//            gameId = rg.getGameId(JSONData);
//
//
//            JSONObject join = rg.postJoinGame(gameId, robotId);
//            //Mit festen Gegner
////            robotPlayerId = rg.getPlayerId(join);
////            join = rg.postJoinGame(gameId, enemyId);
////            enemyPlayerId = rg.getPlayerId(join);
//
//
//            //Ohne festen Gegner
//            JSONObject game = rg.getGameById(gameId);
//            JSONArray players = game.getJSONArray("player");
//
//            int sleepCount = 0;
//            while (players.length() <2){
//                System.out.println("Warte auf Spieler....");
//                Thread.sleep(10000);
//                sleepCount++;
//                if (sleepCount == 10){
//                    System.exit(0);
//                }
//                game = rg.getGameById(gameId);
//                players = game.getJSONArray("player");
//            }
//            System.out.println("Gegner gefunden!");
//            enemyPlayerId = players.getJSONObject(1).getString("playerId");
//        } else{
//            System.out.println("Zeitüberschreitung");
//            System.exit(0);
//        }

        enemyMovementPoints = rr.getRobotMovementRateById(enemyId);
        robotMovementPoints = rr.getRobotMovementRateById(robotId);



        if (enemyMovementPoints < robotMovementPoints){
            int counter = 0;
            while (counter <= robotMovementPoints) {
                turn();
                counter++;
            }
        } else {
            //check new move
        }

//        ToDo: Hinzufügen, sobald mehr maps vorhanden sind.
//        view.viewMaps();
//        mapId = view.chooseMap();
    }

    public static void turn() throws IOException, InterruptedException {

        String movementType = view.decideMovementType();
        boolean moveExecuted = false;

        switch (movementType){
            case "MOVE":
                while (moveExecuted == false) {
                    String move = view.moveDirection();
                    moveExecuted = checkMove(move);
                }
                rmo.postDoAMove(gameId, robotPlayerId, "MOVE", MapIndexPlayer, align);
            case "ALIGN":
                String direction = view.aligndDirection();
                rmo.postDoAMove(gameId, enemyPlayerId, "ALIGN", 0, direction);

            case "ATTACK":

            case "END":
                break;
        }
    }

    public static boolean checkMove(String move) throws IOException, InterruptedException {
        int mapSizeX = rma.getMapSizeX(mapId);
        int mapSize = rma.getMapSize(mapId);
        boolean validate = false;

        int vorletzteReihe = (mapSize / mapSizeX) - 1;

        switch (move) {
            case "w" -> {
                if (MapIndexPlayer > mapSizeX - 1) {
                    MapIndexPlayer -= mapSizeX;
                    validate = true;
                } else {
                    System.out.println("Fehler!");
                }
            }
            case "d" -> {
                if (MapIndexPlayer % mapSizeX != mapSizeX - 1) {
                    MapIndexPlayer += 1;
                    validate = true;
                } else {
                    System.out.println("Fehler!");
                }
            }
            case "s" -> {
                if (MapIndexPlayer >= vorletzteReihe * mapSizeX) {
                    MapIndexPlayer += mapSizeX;
                    validate = true;
                } else {
                    System.out.println("Fehler!");
                }
            }
            case "a" -> {
                if (MapIndexPlayer % mapSizeX != 0) {
                    MapIndexPlayer -= 1;
                    validate = true;
                } else {
                    System.out.println("Fehler!");
                }

            }
        }
        return validate;
    }

}
