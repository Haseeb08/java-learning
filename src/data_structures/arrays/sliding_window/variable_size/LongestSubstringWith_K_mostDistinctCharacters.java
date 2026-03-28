package data_structures.arrays.sliding_window.variable_size;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWith_K_mostDistinctCharacters {

//    while (end < s.length()) {
//        add s[end] to map;
//
//        if (map.size() < k) {
//            end++;
//        } else if (map.size() == k) {
//            update maxLen;
//            end++;
//        } else {
//            while (map.size() > k) {
//                shrink window;
//            }
//            end++;
//        }
//    }


    public static void main(String[] args) {
        String s = "aabbcc";
        int k = 2;
//        Output: 3
        System.out.println("Longest Substring with k most distinct element: " + longestSubstringWithKmostDistinct(s, k));
    }

    private static String longestSubstringWithKmostDistinct(String s, int k) {
        int maxLen = 0;
        int maxStart = 0;
        int start = 0;
        int end = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);

            if (map.size() < k) {
                end++;
            } else if (map.size() == k) {
                maxLen = Math.max(maxLen, end - start + 1);
                maxStart = start;
                end++;
            } else {
                // map.size() > k
                while (map.size() > k) {
                    char startChar = s.charAt(start);
                    map.put(startChar, map.get(startChar) - 1);
                    if (map.get(startChar) == 0) map.remove(startChar);
                    start++;
                }
                end++;
            }
        }


            return s.substring(maxStart, maxStart + maxLen);
        }

}
