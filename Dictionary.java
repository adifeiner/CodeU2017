import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private List<String> dictionary = new ArrayList<>();
    private List<String> prefixes = new ArrayList<>();

    public Dictionary(List<String> dictionary, List<String> prefixes) {
        this.dictionary = dictionary;
        this.prefixes = prefixes;
    }

    public boolean isWord(String word) {
        return this.dictionary.contains(word);
    }

    public boolean isPrefix(String prefix) {
        return this.prefixes.contains(prefix);
    }
}
