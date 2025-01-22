package Client;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class View {
    static Scanner sc = new Scanner(System.in);
    RequestGame rg = new RequestGame();
    RequestMap rma = new RequestMap();
    RequestMove rmo = new RequestMove();
    RequestRobot rr = new RequestRobot();

    public void intro() {
        System.out.println("Willkommen zu Robot Wars!");
        System.out.println();
        System.out.println("""
                 _______               _______
                |@|@|@|@|             |@|@|@|@|
                |@|@|@|@|    _____    |@|@|@|@|
                |@|@|@|@| /\\_T_T_/\\ |@|@|@|@|
                |@|@|@|@||/\\ T T /\\||@|@|@|@|
                 ~~~~/|~||~\\/~T~\\/~||~T~~T\\~
                   /_,|_| \\(-(O)-)/ |_|__|/");
                  /~\\      \\\\8_8//    |_ |_
                 (O_O)  /~~[_____]~~\\   [(@)|
                       (  |       |  )    ~
                      [~` ]       [ '~]
                      |~~|         |~~|
                      |  |         |  |
                     _<\\/>_       _<\\/>_
                    /_====_\\     /_====_\\
                """);
    }

    public int createOrChooseRobot() {
        System.out.println("""
                Möchtest du einen neuen Roboter erstellen oder einen bereits erstellten wählen?
                1 - Erstellen
                2 - Auswaehlen
                """);

        int decision = sc.nextInt();
        return decision;
    }

    public String createRobot() throws IOException, InterruptedException {
        String robotId = "";

        System.out.println("Wie soll dein Roboter heißen?");
        String name = sc.next();

        System.out.println("Wie viel Leben soll dein Roboter haben?");
        int health = sc.nextInt();

        System.out.println("Wie hoch soll der Angriffschaden sein?");
        int attackDamage = sc.nextInt();

        System.out.println("Wie hoch soll die Angriffsreichweite sein?");
        int attackRange = sc.nextInt();

        System.out.println("Wie hoch soll die Bewegungsreichweite sein?");
        int movementRate = sc.nextInt();

        JSONObject JSONData = rr.postNewRobot(name, health, attackDamage, attackRange, movementRate);
        if (JSONData == null) {
            createRobot();
        } else {
            robotId = rr.getRobotId(JSONData);
        }
        return robotId;
    }

    public void viewRobots() throws IOException, InterruptedException {
        rr.getAllRobots();
    }

    public String chooseRobot() {
        System.out.println("Gebe die Id des Roboters ein, welchen du spielen möchtest.");
        return sc.next();
    }

    public void viewMaps() throws IOException, InterruptedException {
        rma.getMaps();
    }

    public String chooseMap() {
        System.out.println("""
                Gebe die Id der Map ein, welche du spielen möchtest.
                """);

        return sc.next();
    }

    public void drawMap(String playerId, String enemyId, String gameId, String mapId) throws IOException, InterruptedException {
        int counter = 0;
        String blue = "\u001B[34m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String reset = "\u001B[0m";
        int mapSize = 44;
        int mapSizeX = 9;
        int lastPlayerIndex = 0;
        int lastEnemyIndex = 44;
        int[] wall = {4,13,31,40};

        while (counter <= mapSize) {
            if (counter == lastPlayerIndex) {
                System.out.print("["+blue+"P"+reset+"]");
            } else if (counter == lastEnemyIndex) {
                System.out.print("["+red+"E"+reset+"]");
            } else if (isWall(counter, wall)) {
                System.out.print("["+green+"W"+reset+"]");
            } else {
                if ((counter + 1) % mapSizeX == 0 && counter != 0) {
                    System.out.print("[ ]");
                    System.out.println();
                } else {
                    System.out.print("[ ]");
                }
            }
            counter++;
        }
    }

    public static boolean isWall(int counter, int[] wall) {
        for (int i : wall) {
            if (i == counter) {
                return true;
            }
        }
        return false;
    }

    public String decideMovementType() {
        System.out.println("""
                Was möchtest du tun?
                MOVE
                ALIGN
                ATTACK
                END
                """);

        return sc.next();
    }

    public String direction() {
        System.out.println("""
                Wohin möchtest du dich ausrichtig?
                N
                E
                S
                W
                """);
        return sc.next();
    }
}
