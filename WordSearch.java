import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    private List<String> results = new ArrayList<>();

    public void findAllWords(int col, int row, char[][] characters, Dictionary dictionary) {
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[1].length; j++) {
                String word = String.valueOf(characters[i][j]);
                if (dictionary.isPrefix(word)) {
                    boolean[][] visit = new boolean[characters.length][characters[1].length];
                    findWord(i, j, visit, characters, word, dictionary);
                }
            }
        }
    }

    public void findWord(int row, int col, boolean[][] visit, char[][] characters, String word,
                         Dictionary dictionary) {
        if (dictionary.isWord(word)) {
            if (!this.results.contains(word)) {
                results.add(word);
            }
        }

        for (int i = row - 1; i <= row + 1 && i < characters.length; i++) {
            for (int j = col - 1; j <= col + 1 && j < characters[1].length; j++) {
                if (i >= 0 && j >= 0 && !visit[i][j]) {
                    if (dictionary.isPrefix(word + characters[i][j])) {
                        visit[i][j] = true;
                        findWord(i, j, visit, characters, word + characters[i][j], dictionary);
                    }
                }
            }
        }
    }

    public List<String> getResults(){
        return results;
    }
}