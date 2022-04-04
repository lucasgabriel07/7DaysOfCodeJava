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
            JSONArray items = data.getJSONArray("items");

            ArrayList<Movie> movies = new ArrayList<>();

            for (int i=0; i<items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                String title = item.getString("title");
                String urlImage = item.getString("image");
                Float rating = item.getFloat("imDbRating");
                Integer year = item.getInt("year");

                movies.add(new Movie(title, urlImage, rating, year));
            }

            movies.forEach(System.out::println);
        }
    }

}