import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ImdbMovieJsonParser {

    private final JSONArray items;

    public ImdbMovieJsonParser(JSONArray items) {
        this.items = items;
    }

    public ArrayList<Movie> parse() {
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i=0; i<items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            String id = item.getString("id");
            String title = item.getString("title");
            String urlImage = item.getString("image");
            Float rating = item.getFloat("imDbRating");
            Integer year = item.getInt("year");
            Integer ranking = i + 1;

            movies.add(new Movie(id, title, urlImage, rating, year, ranking));
        }

        return movies;
    }
}
