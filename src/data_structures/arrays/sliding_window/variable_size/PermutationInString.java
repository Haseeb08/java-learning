package data_structures.arrays.sliding_window.variable_size;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "Abc";
        String s2 = "eidcbAooo";

        System.out.println("S2 contains S1 - " + containsString(s1, s2));
        System.out.println("S2 contains permutation of S1 - " + containsPermutationString(s1, s2));
    }

    private static boolean containsPermutationString(String s1, String s2) {
        Map<Character, Integer> s1FreqMap = new HashMap<>();
        Map<Character, Integer> windowFreqMap = new HashMap<>();

        // Build frequency map for s1
        for (char c : s1.toCharArray()) {
            s1FreqMap.put(c, s1FreqMap.getOrDefault(c, 0) + 1);
        }

        int start = 0;

        for (int end = 0; end < s2.length(); end++) {
            char endChar = s2.charAt(end);
            windowFreqMap.put(endChar, windowFreqMap.getOrDefault(endChar, 0) + 1);

            while (end - start + 1 > s1.length()) {
                // shrink window
                char startChar = s2.charAt(start);
                windowFreqMap.put(startChar, windowFreqMap.get(startChar) - 1);
                if (windowFreqMap.get(startChar) == 0) {
                    windowFreqMap.remove(startChar);
                }
                start++;
            }

            if (end - start + 1 == s1.length() && windowFreqMap.equals(s1FreqMap)) return true;
        }

        return false;
    }

    private static boolean containsString(String searchString, String targetString) {
        int searchLen = searchString.length();
        int targetLen = targetString.length();

        if (searchLen > targetLen) return false;

        for (int start = 0; start <= targetLen - searchLen; start++) {
            boolean match = true;
            for (int i = 0; i < searchLen; i++) {
                if (searchString.charAt(i) != targetString.charAt(start + i)) {
                    match = false;
                    break;
                }
            }
            if (match) return true;
        }

        return false;
    }
}
