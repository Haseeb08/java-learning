package data_structures.arrays.sliding_window.fixed_size;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: First Negative Number in Every Window of Size K
 *
 * Given an array and a window size `k`, find the first negative number in every
 * contiguous subarray (window) of size `k`.
 *
 * Example:
 * Input:  [12, -1, -7, 8, 15, 30, 16, 28], k = 3
 * Output: [-1, -1, -7, 0, 0, 0]
 */
public class FirstNegativeInWindow {

    /**
     * Solves the problem using the Sliding Window technique with Deque.
     *
     * Key Ideas:
     * - Maintain a Deque of negative numbers within the current window.
     * - At each window slide, remove the elements that go out of the window.
     * - The front of the deque always holds the first negative number.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(k) for deque
     */
    private static String firstNegativeSlidingWindow(int[] arr, int k) {
        int n = arr.length;

        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        int start = 0;
        int end = 0;

        while (end < n) {
            // Step 1: Add current element to deque if it is negative
            if (arr[end] < 0) {
                deque.addLast(arr[end]);
            }

            // Step 2: Expand the window until it reaches size k
            if (end - start + 1 < k) {
                end++;
            }
            // Step 3: When window hits size k
            else if (end - start + 1 == k) {
                // Add the first negative number from the deque (if available)
                if (!deque.isEmpty()) {
                    result.add(deque.peekFirst());
                } else {
                    result.add(0); // No negative in the window
                }

                // Step 4: Remove the element going out of the window from deque
                if (!deque.isEmpty() && deque.peekFirst() == arr[start]) {
                    deque.pollFirst();
                }

                // Slide the window forward
                start++;
                end++;
            }
        }

        return result.toString();
    }

    /**
     * Solves the problem using the Brute Force approach.
     *
     * Time Complexity: O(n * k)
     * Space Complexity: O(1) (excluding result)
     */
    private static String firstNegativeBruteForce(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= arr.length - k; i++) {
            boolean foundNegative = false;

            // Look at each element in the current window
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    result.add(arr[j]);
                    foundNegative = true;
                    break;
                }
            }

            if (!foundNegative) {
                result.add(0);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example Test Case
        int[] arr = {12, -1, -7, 8, 15, 30, 16, 28};
        int k = 3;

        System.out.println("Brute Force:        " + firstNegativeBruteForce(arr, k));
        System.out.println("Sliding Window:     " + firstNegativeSlidingWindow(arr, k));
    }
}
