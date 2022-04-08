import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONArray;

public class Main {

    public static void main(String []args) {

        ImdbApiClient client = new ImdbApiClient();

        try {
            JSONArray items = client.getBody();
            if (items != null) {
                ImdbMovieJsonParser parser = new ImdbMovieJsonParser(items);
                ArrayList<Movie> movies = parser.parse();
                movies.sort(Collections.reverseOrder());

                String title = "Top 250 filmes - IMDb";
                HTMLGenerator generator = new HTMLGenerator(new FileWriter("index.html"), title);
                generator.generate(movies);
                System.out.println("HTML gerado com sucesso!");
            }
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}