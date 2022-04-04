public class Movie {

    private final String title;
    private final String urlImage;
    private final Float rating;
    private final Integer year;

    public Movie(String title, String urlImage, Float rating, Integer year) {
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
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
