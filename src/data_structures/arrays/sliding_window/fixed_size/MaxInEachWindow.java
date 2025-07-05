package data_structures.arrays.sliding_window.fixed_size;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxInEachWindow {

    private static List<Integer> findMaxInWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // Stores indices of potential max elements

        int start = 0, end = 0;
        int n = arr.length;

        while (end < n) {

            // Remove all elements smaller than current from the back of the deque
//            This ensures that the maximum value in the current window is always at the front of the deque (deque.peekFirst()).
//            If arr[end] is greater than or equal to the elements at the back of deque,
//            those elements can never be maximum in the current or future windows — so we remove them.

            while (!deque.isEmpty() && arr[end] >= arr[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add current index
            deque.addLast(end);

            // Expand window
            if (end - start + 1 < k) {
                end++;
            } else if (end - start + 1 == k) {
                // Front of deque is the largest in the window
                result.add(arr[deque.peekFirst()]);

                // Remove index if it's out of the window
                if (deque.peekFirst() == start) {
                    deque.pollFirst();
                }

                // Slide the window
                start++;
                end++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(findMaxInWindowBruteF(arr, k)); // Output: [3, 3, 5, 5, 6, 7]
        System.out.println(findMaxInWindow(arr, k)); // Output: [3, 3, 5, 5, 6, 7]
    }

    // Brute force using sliding window with start and end
    private static List<Integer> findMaxInWindowBruteF(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;

        int start = 0;
        int end = 0;

        while (end < n) {
            // Expand the window until it hits size k
            if (end - start + 1 < k) {
                end++;
            }
            // When window size is k
            else if (end - start + 1 == k) {
                // Calculate max in the current window
                int max = Integer.MIN_VALUE;
                for (int i = start; i <= end; i++) {
                    max = Math.max(max, arr[i]);
                }
                result.add(max);

                // Slide the window
                start++;
                end++;
            }
        }

        return result;
    }
}
