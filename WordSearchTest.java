import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class WordSearchTest {
    private List<String> myDictionary;
    private Dictionary dictionary;
    private WordSearch wordSearch;

    @Before
    public void setUp() {
        myDictionary = Arrays.asList("CAR", "CARD", "CART", "CAT");
        dictionary = new Dictionary(myDictionary);
        wordSearch = new WordSearch();
    }

    @Test
    public void testFindAllWords() {
        char[][] characters = {{'A', 'A', 'R'}, {'T', 'C', 'D'}};
        TreeSet<String> expected = new TreeSet<String>();
        expected.add("CAT");
        expected.add("CAR");
        expected.add("CARD");
        assertEquals("The correct output", expected, this.wordSearch.findAllWords(3, 2, characters, this.dictionary));
    }

    @Test
    public void testEmptyGrid(){
        char[][] characters = {{}, {}};
        assertEquals("The correct output", new TreeSet<String>(),
                this.wordSearch.findAllWords(0, 0, characters, this.dictionary));
    }

    @Test
    public void testNoWordsFromTheDictionary(){
        char[][] characters = {{'A', 'A', 'A'}, {'B', 'C', 'C'}};
        assertEquals("The correct output", new TreeSet<String>(),
                this.wordSearch.findAllWords(0, 0, characters, this.dictionary));
    }
}