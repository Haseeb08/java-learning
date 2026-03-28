package data_structures.arrays.sliding_window.fixed_size;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArraySum {

    // Optimized - Sliding Window - O(n) time
    // Keep a window of size k and slide it forward by 1 each time
    private static int maxSumSlidingWindow(int[] arr, int k) {
        int windowSum = 0;
        int maxSum = 0;

        // First k elements sum
        for (int i = 0; i < k; i++) {
            windowSum+=arr[i];
        }
        maxSum = windowSum;

        // Slide window from k to n-1

        for (int i = k; i < arr.length; i++) {
            // add incoming element to windowSum
            windowSum = windowSum + arr[i];

            // subtract outgoing element from windowSum
            windowSum = windowSum - arr[i-k];

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    private static List<Integer> findSumOfEachWindow(int[] arr, int k) {
        // Can also do in above way
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        int windowSum = 0;


        while (end < arr.length) {
            windowSum+=arr[end];
            if (end - start + 1 < k) {
                end++;
            } else if (end - start + 1 == k) {
                result.add(windowSum);

                windowSum = windowSum - arr[start];

                start++;
                end++;
            }
        }

        return result;
    }

    private static List<Integer> findProductOfEachWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        int windowProduct = 1;


        while (end < arr.length) {
            windowProduct = windowProduct * arr[end];
            if (end - start + 1 < k) {
                end++;
            } else if (end - start + 1 == k) {
                result.add(windowProduct);

                windowProduct = windowProduct / arr[start];

                start++;
                end++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        // op - 9 - [5,1,3]

        System.out.println("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nSubarray Size (k): " + k);

        System.out.println("\nBrute Force Max Sum: " + maxSumBruteForce(arr, k));
        System.out.println("\nSliding Window Max Sum: " + maxSumSlidingWindow(arr, k));
        System.out.println("\nSum of each Sliding Window : "+ findSumOfEachWindow(arr,k));
        System.out.println("\nProduct of each Sliding Window : "+ findProductOfEachWindow(arr,k));
    }

    // Brute Force - O(n*k) time
    // Try all subarrays of size k
    public static int maxSumBruteForce(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
