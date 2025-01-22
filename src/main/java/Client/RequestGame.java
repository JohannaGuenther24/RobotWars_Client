package Client;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestGame {

    public JSONObject getGameById(String gameId) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/games/game/" + gameId))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
//            String responseBody = response.body().replaceAll("[\\[\\]]", "");
            System.out.println(response.body());
            JSONObject jsonData = new JSONObject(response.body());
            return jsonData;
        } else {
            System.out.println("Fehler: " + response.statusCode());
            return null;
        }
    }

    public JSONObject postNewGame(String mapId) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        JSONObject jsonObjekt = new JSONObject();
        jsonObjekt.put("mapId", mapId);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/games/game"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonObjekt.toString()))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 201) {
            System.out.println("Game created successfully: " + response.body());
            JSONObject jsonData = new JSONObject(response.body());
            return jsonData;
        } else {
            System.out.println("Error: " + response.statusCode());
            System.out.println(response.body());
            return null;
        }
    }

    public JSONObject postJoinGame(String gameId, String robotId) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        JSONObject jsonObjekt = new JSONObject();
        jsonObjekt.put("robotId", robotId);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/games/game/"+gameId+"/join"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonObjekt.toString()))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 201) {
            System.out.println("Game successfully joined: " + response.body());
            JSONObject jsonData = new JSONObject(response.body());
            return jsonData;
        } else {
            System.out.println("Error: " + response.statusCode());
            System.out.println(response.body());
            return null;
        }
    }

    public String getGameId(JSONObject body){
        String id = body.getString("id");

        return id;
    }

    public String getPlayerId(JSONObject body){
        String id = body.getString("playerId");
        return id;
    }
}
