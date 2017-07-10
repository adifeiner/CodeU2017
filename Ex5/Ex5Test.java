import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static junit.framework.Assert.assertEquals;

public class Ex5Test {

    @Test
    public void testfindAlphabetOrder_FirstDict(){
        List<String> dictionary = Arrays.asList("clock", "cloocki", "cocktail","cookie", "car");
        assertEquals(Arrays.asList('c','l','r','k','t','i','e','o','a'), Ex5.findAlphabetOrder(dictionary));
    }

    @Test
    public void testfindAlphabetOrder_SecondDict(){
        List<String> dictionary = Arrays.asList("ART", "RAT", "CAT", "CAR");
        assertEquals(Arrays.asList('A','T','R','C'), Ex5.findAlphabetOrder(dictionary));
    }

    @Test
    public void testfindAlphabetOrder_EmptyDict(){
        List<String> dictionary = Arrays.asList("");
        assertEquals(new LinkedList<Character>(), Ex5.findAlphabetOrder(dictionary));
    }

    @Test
    public void testfindAlphabetOrder_OneChar(){
        List<String> dictionary = Arrays.asList("a", "a", "a");
        assertEquals(Arrays.asList('a'), Ex5.findAlphabetOrder(dictionary));
    }

    @Test
    public void testfindAlphabetOrder_OneWord(){
        List<String> dictionary = Arrays.asList("Google", "Google", "Google");
        assertEquals(Arrays.asList('G', 'o', 'g', 'l', 'e'), Ex5.findAlphabetOrder(dictionary));
    }

    @Test
    public void testfindAlphabetOrder_ThirdDict(){
        List<String> dictionary = Arrays.asList("G", "Go", "Goo", "Gooo", "Google");
        assertEquals(Arrays.asList('G', 'o', 'l', 'e', 'g'), Ex5.findAlphabetOrder(dictionary));
    }


}
