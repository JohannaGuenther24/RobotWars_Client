package Client;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestRobot {

    //kein JSONObj
    public void getAllRobots() throws IOException, InterruptedException {
        String url = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/robots";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body().replaceAll("[\\[\\]]", "");
            System.out.println(responseBody.replaceAll("[,}]", "$0\n"));


        } else {
            System.out.println("Fehler: " + response.statusCode());
        }
    }

    public JSONObject getRobotById(String roboId) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/robots/robot/" + roboId))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            //Eckige Klammern entfernen, da ich es sonst nicht in ein JSONObj umwandeln konnte
            String responseBody = response.body().replaceAll("[\\[\\]]", "");
            System.out.println(responseBody.replaceAll("[,}]", "$0\n"));
            JSONObject jsonData = new JSONObject(response.body());
            return jsonData;
        } else {
            System.out.println("Fehler: " + response.statusCode());
            return null;
        }
    }

    public JSONObject postNewRobot(String name, int health, int attackDamage, int attackRange, int movementRate) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        JSONObject jsonObjekt = new JSONObject();
        jsonObjekt.put("name", name);
        jsonObjekt.put("health", health);
        jsonObjekt.put("attackDamage", attackDamage);
        jsonObjekt.put("attackRange", attackRange);
        jsonObjekt.put("movementRate", movementRate);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/robots/robot"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonObjekt.toString()))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 201) {
            System.out.println("Robot created successfully: " + response.body());
            JSONObject jsonData = new JSONObject(response.body());
            return jsonData;
        } else {
            System.out.println("Error: " + response.statusCode());
            System.out.println(response.body());
            return null;
        }
    }

    //Getter für die Variablen

    public String getRobotId(JSONObject body) {
        int id = body.getInt("id");
        String result = String.valueOf(id);
        return result;
    }


    public void getRobotHealthById(String robotId) throws IOException, InterruptedException {
        RequestRobot rr = new RequestRobot();
        JSONObject robot = rr.getRobotById(robotId);
        int health = robot.getInt("health");
        System.out.println("Health: " + health);
    }

    public void getRobotAttackDamageById(String robotId) throws IOException, InterruptedException {
        RequestRobot rr = new RequestRobot();
        JSONObject robot = rr.getRobotById(robotId);
        int attackDamage = robot.getInt("attackDamage");
        System.out.println("AttackDamage: " + attackDamage);
    }

    public void getRobotAttackRangeById(String robotId) throws IOException, InterruptedException {
        RequestRobot rr = new RequestRobot();
        JSONObject robot = rr.getRobotById(robotId);
        int attackRange = robot.getInt("attackRange");
        System.out.println("AttackRange: " + attackRange);
    }

    public int getRobotMovementRateById(String robotId) throws IOException, InterruptedException {
        RequestRobot rr = new RequestRobot();
        JSONObject robot = rr.getRobotById(robotId);
        int movementRate = robot.getInt("movementRate");
        System.out.println("MovementRate: " + movementRate);
        return movementRate;
    }
}
