package Client;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestMove {

    public JSONObject getMovesAfter(String gameId, String moveId) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/games/game/" + gameId + "/move/" + moveId + "/after"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body().replaceAll("[\\[\\]]", "");
            System.out.println(responseBody.replaceAll("[,}]", "$0\n"));
            JSONObject jsonData = new JSONObject(response.body());
            return jsonData;

        } else {
            System.out.println("Fehler: " + response.statusCode());
            return null;
        }
    }

    public JSONObject getAllMoves(String gameId) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/games/game/" + gameId + "/move"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body().replaceAll("[\\[\\]]", "");
            System.out.println(responseBody.replaceAll("[,}]", "$0\n"));
            JSONObject jsonData = new JSONObject(response.body());
            return jsonData;

        } else {
            System.out.println("Fehler: " + response.statusCode());
            return null;
        }
    }


    public void postDoAMove(String gameId, String playerId, String movementType, int mapindex, String align) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        JSONObject jsonObjekt = new JSONObject();
        jsonObjekt.put("id", gameId);
        jsonObjekt.put("playerId", playerId);
        jsonObjekt.put("movementType", movementType);
        jsonObjekt.put("align", align);
        jsonObjekt.put("mapIndex", mapindex);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/games/game/"+gameId+"/move/player/"+playerId))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonObjekt.toString()))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 201) {
            System.out.println("Movement successfully completed: " + response.body());
        } else {
            System.out.println("Error: " + response.statusCode());
            System.out.println(response.body());
        }
    }
}
