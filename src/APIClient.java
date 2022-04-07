import org.json.JSONArray;

import java.io.IOException;

public interface APIClient {
    JSONArray getBody() throws IOException, InterruptedException;
}
