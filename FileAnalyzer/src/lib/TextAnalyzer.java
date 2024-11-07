package lib;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer {

    /**
     * Method to count the total number of words in the given text file.
     *
     * @param filePath Path to the text file
     * @return Total number of words
     * @throws IOException if an error occurs during file reading
     */
    public int countTotalWords(Path filePath) throws IOException {
        String content = Files.readString(filePath);
        String[] words = content.split("\\s+"); // Split by whitespace
        return words.length;
    }

    /**
     * Method to count the occurrences of each word in the given text file.
     *
     * @param filePath Path to the text file
     * @return Map containing words as keys and their occurrences as values
     * @throws IOException if an error occurs during file reading
     */
    public Map<String, Integer> countWordOccurrences(Path filePath) throws IOException {
        String content = Files.readString(filePath).toLowerCase();
        String[] words = content.split("\\s+"); // Split by whitespace
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        for (String word : words) {
            if (!word.isBlank()) { // Ignore blank entries (e.g., extra spaces)
                word = word.replaceAll("[^a-zA-Z]", ""); // Remove punctuation
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        return wordCountMap;
    }
}

