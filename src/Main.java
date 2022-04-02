import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
            System.out.println(data);
        }
    }

}
