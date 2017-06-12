import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordSearchTest {
    @Test
    public void testFindAllWords() {
        List<String> myDictionary = Arrays.asList("CAR", "CARD", "CART", "CAT");
        List<String> prefixes = Arrays.asList("C", "CA", "CAR", "CARD", "CART", "CAT");
        Dictionary dictionary = new Dictionary(myDictionary, prefixes);

        WordSearch wordSearch = new WordSearch();
        char[][] characters = new char[][]{{'A', 'A', 'R'}, {'T', 'C', 'D'}};

        List<String> expected = new ArrayList<>(Arrays.asList("CAT", "CAR", "CARD"));
        wordSearch.findAllWords(3, 2, characters, dictionary);
        assertEquals("The correct output", expected, wordSearch.getResults());
    }
}