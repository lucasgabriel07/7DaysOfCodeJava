public class Movie {

    private final String id;
    private final String title;
    private final String urlImage;
    private final Float rating;
    private final Integer year;
    private final Integer ranking;

    public Movie(String id, String title, String urlImage, Float rating, Integer year, Integer ranking) {
        this.id = id;
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
        this.ranking = ranking;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public Float getRating() {
        return rating;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getRanking() {
        return ranking;
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
}
