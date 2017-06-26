public class Ex4 {

    /**
     * The fuction loop over the mapTiles array and count the number of islands
     * @param numOfRow
     * @param numOfCol
     * @param mapTiles - 2-dimensional array of booleans where false means water and true means land
     * @return
     */
    public static int countIslands(int numOfRow, int numOfCol, boolean[][] mapTiles) {
        int numOfIslands = 0;
        boolean[][] visit = new boolean[numOfRow][numOfCol];
        for (int i = 0; i < numOfRow; i++) {
            for (int j = 0; j < numOfCol; j++) {
                if (!visit[i][j] && mapTiles[i][j]) {
                    numOfIslands++;
                    // find all the tiles that belong to this island
                    findAllTilesOfIsland(mapTiles, visit, numOfRow, numOfCol, i, j);
                }
            }
        }
        return numOfIslands;
    }

    /**
     * The function check if the arguments legal and check
     * all the options for tiles belong to the same island
     * @param mapTiles - 2-dimensional array of booleans where false means water and true means land
     * @param visit - 2-dimensional array of booleans
     * @param numOfRows - number of rows
     * @param numOfCols - number of columns
     * @param rowIndex - row index in the tiles array
     * @param colIndex - column index in te tiles array
     */
    private static void findAllTilesOfIsland(boolean[][] mapTiles, boolean[][] visit, int numOfRows, int numOfCols,
                                       int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= numOfRows || colIndex < 0 || colIndex >= numOfCols || !mapTiles[rowIndex][colIndex]
                || visit[rowIndex][colIndex]) {
            return;
        }
        visit[rowIndex][colIndex] = true;
        findAllTilesOfIsland(mapTiles, visit, numOfRows, numOfCols, rowIndex - 1, colIndex);
        findAllTilesOfIsland(mapTiles, visit, numOfRows, numOfCols, rowIndex + 1, colIndex);
        findAllTilesOfIsland(mapTiles, visit, numOfRows, numOfCols, rowIndex, colIndex - 1);
        findAllTilesOfIsland(mapTiles, visit, numOfRows, numOfCols, rowIndex, colIndex + 1);
    }
}
