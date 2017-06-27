import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class WordSearch {

    /**
     * The function receives the number of rows, number of colums, a 2-dimensional array of characters and the dictionary.
     * @param numOfCols
     * @param numOfRows
     * @param characters
     * @param dictionary
     * @return Set of all words found
     */
    public TreeSet<String> findAllWords(int numOfCols, int numOfRows, char[][] characters, Dictionary dictionary) {
        TreeSet results = new TreeSet();
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                String word = String.valueOf(characters[i][j]);
                if (dictionary.isPrefix(word)) {
                    // Create 2-dimensional boolean array
                    boolean[][] visit = new boolean[numOfRows][numOfCols];
                    visit[i][j] = true;
                    findAllWords(i, j, visit, characters, word, dictionary, results, numOfRows, numOfCols);
                }
            }
        }
        return results;
    }

    /**
     * The function move on the 8 adjacent cells and check if words from the dictionary exist
     * @param rowIndex
     * @param colIndex
     * @param visit
     * @param characters
     * @param word
     * @param dictionary
     * @param results
     * @param numOfRows
     * @param numOfCols
     */
    public void findAllWords(int rowIndex, int colIndex, boolean[][] visit, char[][] characters, String word,
                         Dictionary dictionary, TreeSet<String> results, int numOfRows, int numOfCols) {
        if (dictionary.isWord(word)) {
                results.add(word);
        }

        for (int i = rowIndex - 1; i <= rowIndex + 1 && i < numOfRows; i++) {
            for (int j = colIndex - 1; j <= colIndex + 1 && j < numOfCols; j++) {
                if (i >= 0 && j >= 0 && !visit[i][j]) {
                    String tmp = word + characters[i][j];
                    if (dictionary.isPrefix(tmp)) {
                        visit[i][j] = true;
                        findAllWords(i, j, visit, characters, word + characters[i][j], dictionary, results,
                                numOfRows, numOfCols);
                    }
                }
            }
        }
    }
}