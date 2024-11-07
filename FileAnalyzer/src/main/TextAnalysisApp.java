// --- Main Application ---
package main;

import lib.TextAnalyzer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class TextAnalysisApp {
    public static void main(String[] args) {
        TextAnalyzer analyzer = new TextAnalyzer();
        Path filePath = Path.of("sample.txt"); // Replace with your file path
        
        try {
            // Count total words
            int totalWords = analyzer.countTotalWords(filePath);
            System.out.println("Total number of words: " + totalWords);

            // Count word occurrences
            Map<String, Integer> wordOccurrences = analyzer.countWordOccurrences(filePath);
            System.out.println("Word occurrences: ");
            for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
