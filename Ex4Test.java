import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Ex4Test {

    @Test
    public void testCountIslands(){
        boolean[][] mapTiles = {
                {false, true, false, true},
                {true, true, false, false},
                {false, false, true, false},
                {false, false, true, false}
        };
        assertEquals(3, Ex4.countIslands(mapTiles.length, mapTiles[0].length, mapTiles));
    }

    @Test
    public void testZeroIsland(){
        boolean[][] mapTiles = new boolean[4][4];
        assertEquals(0, Ex4.countIslands(mapTiles.length, mapTiles[0].length, mapTiles));
    }

    @Test
    public void testOneIsland(){
        boolean[][] mapTiles = {
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true}
        };
        assertEquals(1, Ex4.countIslands(mapTiles.length, mapTiles[0].length, mapTiles));
    }


}