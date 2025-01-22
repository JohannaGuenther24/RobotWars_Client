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
    static String enemyId = "08196aec-84c3-4eca-82a3-0812bbdc7cd1";
    static String enemyPlayerId = "";

    static String robotId = "";
    static String robotPlayerId = "";

    static String gameId;

    public static void main(String[] args) throws IOException, InterruptedException {
        //TODO: GetMapById GetGameById

        view.drawMap("E","D","S", mapId);
        /*view.intro();

        int decision = view.createOrChooseRobot();
        if (decision == 1){
            robotId = view.createRobot();
        } else if (decision == 2){
            view.viewRobots();
            robotId = view.chooseRobot();
        }


        JSONObject JSONData = rg.postNewGame(mapId);


        if (JSONData != null) {
            gameId = rg.getGameId(JSONData);


            JSONObject join = rg.postJoinGame(gameId, robotId);
            //Mit festen Gegner
//            robotPlayerId = rg.getPlayerId(join);
//            join = rg.postJoinGame(gameId, enemyId);
//            enemyPlayerId = rg.getPlayerId(join);


            //Ohne festen Gegner
            JSONObject game = rg.getGameById(gameId);
            JSONArray players = game.getJSONArray("player");

            int sleepCount = 0;
            while (players.length() <2){
                System.out.println("Warte auf Spieler....");
                Thread.sleep(10000);
                sleepCount++;
                if (sleepCount == 10){
                    System.exit(0);
                }
                game = rg.getGameById(gameId);
                players = game.getJSONArray("player");
            }
            System.out.println("Gegner gefunden!");
            enemyPlayerId = players.getJSONObject(1).getString("playerId");
        } else{
            System.out.println("Zeitüberschreitung");
            System.exit(0);
        }
*/
//        if (rr.getRobotMovementRateById(robotId) < rr.getRobotMovementRateById(enemyId)){
//            turn(enemyId, enemyPlayerId);
//        }

//        ToDo: Hinzufügen, sobald mehr maps vorhanden sind.
//        view.viewMaps();
//        mapId = view.chooseMap();
    }

    public static void turn(String id, String playerId) throws IOException, InterruptedException {

        JSONObject robot = rr.getRobotById(id);
        String movementType = view.decideMovementType();

        switch (movementType){
            case "MOVE":


            case "ALIGN":
                String direction = view.direction();
                rmo.postDoAMove(gameId, enemyPlayerId, "ALIGN", 0, direction);

            case "ATTACK":

            case "END":

        }
    }

}
