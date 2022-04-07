import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Dotenv {
    private final HashMap<String, String> env;

    public Dotenv() throws IOException {

        this.env = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(".env"));
        String line;
        while((line = reader.readLine()) != null) {
            String key = line.split("=")[0];
            String value = line.split("=")[1];
            env.put(key, value);
        }
    }

    public String getEnv(String key) {
        return this.env.get(key);
    }
}