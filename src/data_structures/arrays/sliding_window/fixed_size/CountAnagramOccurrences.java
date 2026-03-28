package data_structures.arrays.sliding_window.fixed_size;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: Count Occurrences of Anagrams
 *
 * Given a text and a pattern, return the starting indices of all anagram substrings of the pattern in the text.
 * For example:
 * Input: txt = "ababaabbab", pat = "aba"
 * Output: [0, 1, 5]
 *
 * Concept:
 * This is a classic fixed-size sliding window problem.
 * We move a window of size `k` (length of pattern) over the text and check whether the current window
 * contains an anagram of the pattern using a frequency map.
 */
public class CountAnagramOccurrences {

    public static void main(String[] args) {
        String txt = "ababaabbab";
        String pat = "aba";
        System.out.println(countAnagrams(txt, pat)); // Output: [0, 1, 5]
    }

    /**
     * Counts the starting indices of anagrams of the pattern in the given text.
     *
     * @param txt The text to search in.
     * @param pat The pattern whose anagrams we need to count.
     * @return A list of starting indices of the anagram substrings.
     */
    private static String countAnagrams(String txt, String pat) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        int k = pat.length(); // Size of the sliding window
        int n = txt.length(); // Length of the text

        int start = 0;
        int end = 0;
        int count = 0; // Number of unique characters still to be matched

        // Step 1: Build the frequency map from the pattern
        for (char c : pat.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Initialize count to the number of unique characters
        count = map.size();

        // Step 2: Start sliding the window
        while (end < n) {
            char endChar = txt.charAt(end);

            // If the current character is part of the pattern
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    count--; // One unique character fully matched
                }
            }

            // Expand the window until its size is k
            if (end - start + 1 < k) {
                end++;
            }

            // When the window size is exactly k
            else if (end - start + 1 == k) {
                // If all characters are matched (i.e., count == 0), it's an anagram
                if (count == 0) {
                    result.add(start);
                }

                // Prepare to slide the window by removing start character
                char startChar = txt.charAt(start);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) == 1) {
                        count++; // We're now missing one character again
                    }
                }

                start++;
                end++;
            }
        }

        return result.toString();
    }
}
