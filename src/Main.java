import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;

public class Main {

    public static void main(String []args) {

        ImdbApiClient client = new ImdbApiClient();

        try {
            JSONArray items = client.fetch();
            ImdbMovieJsonParser parser = new ImdbMovieJsonParser(items);
            ArrayList<Movie> movies = parser.parse();

            HTMLGenerator generator = new HTMLGenerator(new FileWriter("index.html"));
            generator.generate(movies);

            System.out.println("HTML gerado com sucesso!");
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}