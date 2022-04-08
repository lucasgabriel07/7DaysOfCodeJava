public class Movie implements Content, Comparable<Content> {

    private final String id;
    private final String rank;
    private final String title;
    private final String urlImage;
    private final String rating;
    private final String year;

    public Movie(String id, String rank, String title, String urlImage, String rating, String year) {
        this.id = id;
        this.rank = rank;
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getRating() {
        return rating;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "{" +
                  "\n  title: \"" + title + "\"" +
                  "\n  urlImage: \"" + urlImage + "\"" +
                  "\n  rating: " + rating +
                  "\n  year: " + year +
                "\n}";
    }

    @Override
    public int compareTo(Content o) {
        return this.rating.compareTo(o.getRating());
    }
}