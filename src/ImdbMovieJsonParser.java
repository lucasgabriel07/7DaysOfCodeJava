import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ImdbMovieJsonParser implements JsonParser {

    private final JSONArray items;

    public ImdbMovieJsonParser(JSONArray items) {
        this.items = items;
    }

    public ArrayList<Movie> parse() {
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i=0; i<items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            String id = item.getString("id");
            String rank = item.getString("rank");
            String title = item.getString("title");
            String urlImage = item.getString("image");
            String rating = item.getString("imDbRating");
            String year = item.getString("year");

            movies.add(new Movie(id, rank, title, urlImage, rating, year));
        }

        return movies;
    }
}
