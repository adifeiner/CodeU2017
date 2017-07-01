import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Dictionary {
    private TreeSet<String> dictionary = new TreeSet<>();
    private TreeSet<String> prefixes = new TreeSet<>();

    public Dictionary(List<String> dictionary) {
        for (String word: dictionary) {
            this.dictionary.add(word);
            for (int i = 1; i <= word.length(); i++) {
                this.prefixes.add(word.substring(0, i));
            }
        }
    }

    public boolean isWord(String word) {
        return this.dictionary.contains(word);
    }

    public boolean isPrefix(String prefix) {
        return this.prefixes.contains(prefix);
    }
}
