import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Ex4Test {

    @Test
    public void testCountIslands(){
        boolean[][] mapTiles = new boolean[4][4];
        mapTiles[0][1] = true;
        mapTiles[1][0] = true;
        mapTiles[1][1] = true;
        mapTiles[0][3] = true;
        mapTiles[2][2] = true;
        mapTiles[3][2] = true;
        Ex4 countIslands = new Ex4();
        assertEquals(3, countIslands.countIslands(mapTiles.length, mapTiles[0].length, mapTiles));
    }

    @Test
    public void testZeroIsland(){
        boolean[][] mapTiles = new boolean[4][4];
        Ex4 countIslands = new Ex4();
        assertEquals(0, countIslands.countIslands(mapTiles.length, mapTiles[0].length, mapTiles));
    }

    @Test
    public void testOneIsland(){
        boolean[][] mapTiles = new boolean[4][4];
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mapTiles[i][j] = true;
            }
        }
        Ex4 countIslands = new Ex4();
        assertEquals(1, countIslands.countIslands(mapTiles.length, mapTiles[0].length, mapTiles));
    }


}