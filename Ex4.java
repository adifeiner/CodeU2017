public class Ex4 {

    /**
     * The fuction loop over the mapTiles array and count the number of islands
     *
     * @param numOfRow - the number of rows
     * @param numOfCol - the number of columns
     * @param mapTiles - 2-dimensional array of booleans where false means water and true means land
     * @return - the number of islands
     */
    public static int countIslands(int numOfRow, int numOfCol, boolean[][] mapTiles) {
        int numOfIslands = 0;
        boolean[][] visit = new boolean[numOfRow][numOfCol];
        for (int i = 0; i < numOfRow; i++) {
            for (int j = 0; j < numOfCol; j++) {
                if (!visit[i][j] && mapTiles[i][j]) {
                    numOfIslands++;
                    // find all the tiles that belong to this island
                    markAllTilesOfIsland(mapTiles, visit, numOfRow, numOfCol, i, j);
                }
            }
        }
        return numOfIslands;
    }

    /**
     * The function finding all tiles that belong to the island containing tile (rowIndex, colIndex)
     * and marking them as visited.
     *
     *  @param mapTiles - 2-dimensional array of booleans where false means water and true means land
     * @param visit - 2-dimensional array of booleans
     * @param numOfRows - number of rows
     * @param numOfCols - number of columns
     * @param rowIndex - row index in the tiles array
     * @param colIndex - column index in te tiles array
     */
    private static void markAllTilesOfIsland(boolean[][] mapTiles, boolean[][] visit, int numOfRows, int numOfCols,
                                       int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= numOfRows || colIndex < 0 || colIndex >= numOfCols || !mapTiles[rowIndex][colIndex]
                || visit[rowIndex][colIndex]) {
            return;
        }
        visit[rowIndex][colIndex] = true;
        markAllTilesOfIsland(mapTiles, visit, numOfRows, numOfCols, rowIndex - 1, colIndex);
        markAllTilesOfIsland(mapTiles, visit, numOfRows, numOfCols, rowIndex + 1, colIndex);
        markAllTilesOfIsland(mapTiles, visit, numOfRows, numOfCols, rowIndex, colIndex - 1);
        markAllTilesOfIsland(mapTiles, visit, numOfRows, numOfCols, rowIndex, colIndex + 1);
    }
}
