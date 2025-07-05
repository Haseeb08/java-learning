package data_structures.arrays.sliding_window.variable_size;

/**
 * Problem: Longest Substring with Same Letters After Replacement
 *
 * Given a string `s` and an integer `k`, return the length of the longest substring
 * where you can replace at most `k` characters to make all characters in the substring the same.
 *
 * Example:
 * Input: s = "AABABBA", k = 1
 * Output: 4 (The substring "AABA" or "ABBA" can be converted to "AAAA" or "BBBB")
 */

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        System.out.println("Longest string after " + k + " replacements - " +
                longestRepeatingCharacterReplacement(s, k));
    }

    /**
     * Returns the length of the longest substring that can be formed by replacing
     * at most 'k' characters such that all characters in the substring are the same.
     *
     * @param s Input string containing only uppercase English letters
     * @param k Maximum number of characters that can be replaced
     * @return Length of the longest valid substring
     */
    private static String longestRepeatingCharacterReplacement(String s, int k) {
        int start = 0; // Left boundary of the sliding window
        int end = 0;   // Right boundary of the sliding window
        int maxLen = 0; // Tracks the maximum valid window length
        int maxFreq = 0; // Frequency of the most common character in the current window

        int[] freqMap = new int[26]; // Array to count frequencies of each character (A-Z)

        while (end < s.length()) {
            // Update the frequency of the current character at 'end'
            freqMap[s.charAt(end) - 'A']++;

            // Update the most frequent character count seen in the current window
            maxFreq = Math.max(maxFreq, freqMap[s.charAt(end) - 'A']);

            /**
             * Window size = (end - start + 1)
             * Characters to change = (window size - frequency of most frequent character)
             * If that exceeds k, shrink the window from the left
             */
            while ((end - start + 1) - maxFreq > k) {
                freqMap[s.charAt(start) - 'A']--;
                start++; // shrink from the left
            }

            // Update the maximum length of the valid window
            maxLen = Math.max(maxLen, end - start + 1);
            end++; // Expand the window from the right
        }

        // Return result as string to match previous print pattern
        return maxLen + "";
    }
}
