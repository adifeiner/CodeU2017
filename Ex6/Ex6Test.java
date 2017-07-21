import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by adi on 7/20/2017.
 */
public class Ex6Test {

    @Test
    public void testRearrangingCars(){
        List<Move> expected = Arrays.asList(new Move(0, 2), new Move(3, 0),
                new Move(1, 3), new Move(2, 1), new Move(3, 2));
        List<Move> actual = Ex6.rearrangingCars(new int[]{1, 2, 0, 3}, new int[]{3,  1, 2, 0});
        assertEquals("Lists should be identical", expected, actual);
    }

    @Test
    public void testRearrangingCars_EqualsArrays() {
        List<Move> actual = Ex6.rearrangingCars(new int[]{1, 2, 3, 0}, new int[]{1, 2, 3, 0});
        assertEquals("Lists should be empty", new ArrayList<Move>(), actual);
    }

    @Test
    public void testRearrangingCars_TheFirstSoltIsEmpty(){
        List<Move> expected = Arrays.asList(new Move(2, 0), new Move(1, 2), new Move(3, 1));
        List<Move> actual = Ex6.rearrangingCars(new int[]{0, 1, 2, 3}, new int[]{2, 3, 1, 0});
        assertEquals("Lists should be identical", expected, actual);
    }
}
