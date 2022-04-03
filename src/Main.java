import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

    public static void main(String []args) {
        Dotenv dotenv = new Dotenv();
        String API_KEY = dotenv.getEnv("API_KEY");
        String url = "https://imdb-api.com/en/API/Top250Movies/" + API_KEY;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }

        if (response != null) {
            JSONObject data = new JSONObject(response.body());
            JSONArray movies = data.getJSONArray("items");

            ArrayList<String> titles = getAttributeList(movies, "title");
            ArrayList<String> urlImages = getAttributeList(movies, "image");
            ArrayList<String> years = getAttributeList(movies, "year");
            ArrayList<String> imDbRatings = getAttributeList(movies, "imDbRating");

            titles.forEach(System.out::println);
            urlImages.forEach(System.out::println);
            years.forEach(System.out::println);
            imDbRatings.forEach(System.out::println);
        }
    }

    public static ArrayList<String> getAttributeList(JSONArray array, String attribute) {
        ArrayList<String> attributeList = new ArrayList<>();

        for (int i=0; i<array.length(); i++) {
            JSONObject movie = array.getJSONObject(i);
            String attr = movie.get(attribute).toString();
            attributeList.add(attr);
        }

        return  attributeList;
    }

}