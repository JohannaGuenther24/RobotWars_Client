package Client;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestMap {

    public JSONObject getMaps() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/maps"))
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

    //TODO: getMapById, fehlt in der API
//    public JSONObject getMapById(String mapId) throws IOException, InterruptedException {
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/api/maps"))
//                .build();
//        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//        if (response.statusCode() == 200) {
//            //Eckige Klammern entfernen, da ich es sonst nicht in ein JSONObj umwandeln konnte
//            String responseBody = response.body().replaceAll("[\\[\\]]", "");
//            System.out.println(responseBody.replaceAll("[,}]", "$0\n"));
//            JSONObject jsonData = new JSONObject(response.body());
//            return jsonData;
//        } else {
//            System.out.println("Fehler: " + response.statusCode());
//            return null;
//        }
//    }

    //Getter für die Variablen
    //TODO: wenn "getMapById" vorhanden, dann parameter auf JSONObj ändern
    public int getMapSizeX(String body){
        String startText = "\"mapSizeX\":";
        String endText = ",\"mapSize\"";
        int startIndex = body.indexOf(startText) + startText.length();
        int endIndex = body.indexOf(endText);
        String result = body.substring(startIndex, endIndex).trim();
        System.out.println("MapSizeX: "+result);
        return Integer.parseInt(result);
    }

    public int getMapSize(String body){
        String startText = "\"mapSize\":";
        String endText = ",\"mapItems\"";
        int startIndex = body.indexOf(startText) + startText.length();
        int endIndex = body.indexOf(endText);
        String result = body.substring(startIndex, endIndex).trim();
        System.out.println("MapSize: "+result);
        return Integer.parseInt(result);
    }

}
