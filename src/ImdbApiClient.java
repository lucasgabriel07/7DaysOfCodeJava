import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient implements APIClient {

    public JSONArray getBody() throws IOException, InterruptedException {
        String API_KEY;

        try {
            Dotenv dotenv = new Dotenv();
            API_KEY = dotenv.getEnv("API_KEY");
        } catch (IOException exception) {
            System.out.println("Erro ao carregar arquivo .env.\n" +
                    "Crie um arquivo com o nome '.env' na raiz do projeto, " +
                    "e cole sua API KEY no arquivo, com o seguinte formato:\n" +
                    "API_KEY=<Sua chave aqui>");
            return null;
        }

        if (API_KEY != null) {
            String url = "https://imdb-api.com/en/API/Top250Movies/" + API_KEY;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject data = new JSONObject(response.body());

            return data.getJSONArray("items");
        }

        return null;
    }
}