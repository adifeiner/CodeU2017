package Ex5;
import java.util.*;

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
        List<String> updateDict = filterWordsByLength(dictionary, index);
        Map<String, List<String>> newDictionary = findSubDictionary(updateDict, index);

        while (!newDictionary.isEmpty()) {
            for (Iterator<List<String>> iterator = newDictionary.values().iterator(); iterator.hasNext();) {
                List<String> subDict = iterator.next();
                List<Character> subAlphabet = findAlphabetList(subDict);
                alphabetGraph.updateGraph(subAlphabet);
            }
            index++;
            updateDict = filterWordsByLength(updateDict, index);
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
    private static Map<String, List<String>> findSubDictionary(List<String> dictionary, int index) {
        Map<String, List<String>> dictionaryMap = new LinkedHashMap<>();
        List<String> subDictionary = new ArrayList<>();

        for (ListIterator<String> iterator = dictionary.listIterator(); iterator.hasNext(); ) {
            String word = iterator.next();
            if (word.length() <= index) {
                continue;
            }

            if (!dictionaryMap.containsKey(word.substring(0, index))) {
                subDictionary = new ArrayList<>();
                subDictionary.add(word.substring(index));
            } else {
                subDictionary.add(word.substring(index));
            }
            dictionaryMap.put(word.substring(0, index), subDictionary);
        }
        return dictionaryMap;
    }

    /**
     * The function receives a dictionary and an index, and return an ordered list of the characters at the index
     *
     * @param dictionary - a list of words in lexicographic order
     * @return - a list of ordered characters
     */
    private static List<Character> findAlphabetList(List<String> dictionary) {
        List<Character> alphabet = new ArrayList<>();
        for (String word : dictionary) {
            if (!alphabet.contains(word.charAt(0))) {
                alphabet.add(word.charAt(0));
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
    private static List<String> filterWordsByLength(List<String> dictionary, int length) {
        List<String> words = new LinkedList<>();
        for (ListIterator<String> iterator = dictionary.listIterator(); iterator.hasNext();) {
            String word = iterator.next();
            if (word.length() > length) {
                words.add(word);
            }
        }

        return words;
    }
}