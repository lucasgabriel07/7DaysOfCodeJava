import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class HTMLGenerator {

    private final Writer writer;
    private final String title;

    public HTMLGenerator(Writer writer, String title) {
        this.writer = writer;
        this.title = title;
    }

    public void generate(ArrayList<Movie> movies) throws IOException {
        String head =
        """
        <head class="header">
          <meta charset="utf-8">
          <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
          <link rel="stylesheet" href="styles.css">
          <title>%s</title>
        </head>
        """;

        String body =
        """
        <body>
          <header>
            <h1 class="title">%s</h1>
          </header>
        <main>
          <ul class="list">
        """;

        String divTemplate =
        """
              <li class="movie">
                <a href="https://www.imdb.com/title/%s" target="_blank" class="movie-link">&#9432;</a>
                <h2 class=movie-ranking>%s</h2>
                <h3 class="movie-title">%s</h3>
                <img class="movie-img" src="%s" alt="%s" loading="lazy">
                <p class="movie-text">Nota: %s - Ano: %s</p>
              </li>
        """;

        String footer =
        """
            </ul>
          </main>
          <footer>
            <p>Desenvolvido por Lucas Gabriel</p>
            <p>2022</p>
          </footer>
        </body>
        """;

        writer.write(String.format(head, title));
        writer.write(String.format(body, title));

        for (Movie movie : movies) {
            writer.write(String.format(
                    divTemplate, 
                    movie.getId(),
                    movie.getRank(),
                    movie.getTitle(),
                    movie.getUrlImage(),
                    movie.getTitle(),
                    movie.getRating(),
                    movie.getYear()
                )
            );
        }

        writer.write(footer);
        writer.close();
    }

}