package data_structures.arrays.sliding_window.variable_size;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Longest Substring Without Repeating Characters
 *
 * Given a string `s`, find the length and content of the longest substring
 * that contains all unique characters (i.e., no repeating characters).
 *
 * Example:
 * Input: s = "pwwkew"
 * Output: "wke"
 * Explanation: The answer is "wke" with length 3.
 * Note that "pwke" is not a valid answer because the substring must be contiguous and have all unique characters.
 *
 * Approach:
 *  - Use a sliding window (variable size) technique.
 *  - Use a HashSet to track characters in the current window.
 *  - Expand the window with `end` until you see a repeating character.
 *  - Shrink the window from `start` until the repeated character is removed.
 *  - Track the maximum length and starting index of the best window seen so far.
 *
 *  - Always track the longest valid window by comparing end - start + 1 to maxLen
 *
 */

public class LongestSubstringWithAllUniqueCharacters {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println("Longest Unique Substring with Set: " + longestUniqueSubstring(s));
    }

    /**
     * Finds the longest substring with all unique characters using sliding window.
     *
     * @param s The input string
     * @return The longest substring without repeating characters
     */
    private static String longestUniqueSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxStartingIndex = 0; // To track where the longest substring starts
        int maxLen = 0;           // To track the maximum length found
        int start = 0;            // Left boundary of the window
        int end = 0;              // Right boundary of the window

        while (end < s.length()) {

            if (set.contains(s.charAt(end))) {
                // Repeating character found, shrink window from the left
                set.remove(s.charAt(start));
                start++;
            } else {
                // Unique character found, add to set and expand the window
                set.add(s.charAt(end));

                // Update max length and start index if new max is found
                if (maxLen < end - start + 1) {
                    maxLen = end - start + 1;
                    maxStartingIndex = start;
                }

                end++;
            }
        }

        // Return the actual substring from maxStartingIndex of length maxLen
        return s.substring(maxStartingIndex, maxStartingIndex + maxLen);
    }
}
