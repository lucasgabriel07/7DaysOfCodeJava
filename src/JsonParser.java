import java.util.ArrayList;

public interface JsonParser {
    ArrayList<? extends Content> parse();
}