import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex5 {
    /**
     * The function receives a dictionary (a lost of words in lexicographic order) of all words in an unknown language
     * and find the alphabet (an ordered list off characters) of that language
     *
     * @param dictionary - a list of words
     * @return - an ordered list of characters
     */
    public static List<Character> findAlphabetOrder(List<String> dictionary) {
        Graph alphabetGraph = new Graph();
        int index = 0;
        List<String> updateDict = updateDictionary(dictionary, index);
        List<List<String>> newDictionary = findSubDictionary(updateDict, index);

        while (newDictionary != null) {
            for (List<String> subDict : newDictionary) {
                List<Character> subAlphabet = findAlphabetList(subDict, index);
                alphabetGraph.updateGraph(subAlphabet);
            }
            index++;
            updateDict = updateDictionary(updateDict, index);
            newDictionary = findSubDictionary(updateDict, index);
        }
        return alphabetGraph.topologicalSort();
    }

    /**
     * The function receives a dictionary (a list of words in lexicographic order) and an index, and return
     * a list of dictionaries according to their prefixes
     *
     * @param dictionary - a list of words in lexicographic order
     * @param index - the index of the char we check
     * @return - a list of dictionaries
     */
    private static List<List<String>> findSubDictionary(List<String> dictionary, int index) {
        List<List<String>> dictionaryList = new ArrayList<>();
        List<String> subDictionary = new ArrayList<>();

        for (int j = 0; j < dictionary.size(); j++) {
            if (dictionary.get(j).length() <= index) {
                continue;
            }
            if (j == 0) {
                subDictionary.add(dictionary.get(j));
                continue;
            }
            // check if the prefixes from zero to index are equals
            if (dictionary.get(j).substring(0, index).equals(dictionary.get(j - 1).substring(0, index))) {
                subDictionary.add(dictionary.get(j));
            } else {
                if (subDictionary.size() > 0) {
                    dictionaryList.add(subDictionary);
                }
                subDictionary = new ArrayList<>();
                subDictionary.add(dictionary.get(j));
            }
        }
        if (dictionaryList.size() == 0 && subDictionary.size() == 0) {
            return null;
        }
        if (subDictionary.size() > 0) {
            dictionaryList.add(subDictionary);
        }
        return dictionaryList;
    }

    /**
     * The function receives a dictionary and an index, and return an ordered list of the characters at the index
     *
     * * @param dictionary - a list of words in lexicographic order
     * @param index - char index in the word
     * @return - a list of ordered characters
     */
    private static List<Character> findAlphabetList(List<String> dictionary, int index) {
        List<Character> alphabet = new LinkedList<>();
        for (String word : dictionary) {
            if (!alphabet.contains(word.charAt(index))) {
                alphabet.add(word.charAt(index));
            }
        }
        return alphabet;
    }

    /**
     * The function receives a dictionary and an index and return a new dictionary that contain words with length
     * greater than length parameter
     *
     * @param dictionary - a list of words
     * @param length - length parameter
     * @return - a dictionary that contain only words that their length is greater than the length parameter
     */
    private static List<String> updateDictionary(List<String> dictionary, int length) {
        List<String> updateDict = new LinkedList<>();
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).length() > length) {
                updateDict.add(dictionary.get(i));
            }
        }
        return updateDict;
    }
}