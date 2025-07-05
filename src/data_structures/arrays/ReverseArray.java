package data_structures.arrays;

import java.util.Arrays;

public class ReverseArray {

    private static int[] reverseByBruteForce(int[] arr) {
        /*
         * Brute Force
         *
         * Reverses the array by creating a new reversed array (Brute Force).
         *
         * Time Complexity: O(n)
         * Space Complexity: O(n)
         *
         */
        int n = arr.length;
        int[] reversedArray = new int[n];

        for (int i = 0; i < n; i++) {
            reversedArray[i] = arr[n - i -1];
        }
        return reversedArray;
    }

    private static void reverseByTwoPointer(int[] arr) {
        /*
         * 
         *   Reverses in-place using two-pointer technique.
         * 
         * Time Complexity: O(n) ---- O(n/2) = O(n)
         * Space Complexity: O(1)
         * 
         */
        int left = 0;
        int right = arr.length -1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Original array: " + Arrays.toString(arr));

        // reverse by brute force
        int[] reversedBrute = reverseByBruteForce(arr);
        System.out.println("Reversed by brute force (new array): " + Arrays.toString(reversedBrute));

        // reverse in-place by two pointer
        reverseByTwoPointer(arr);
        System.out.println("Reversed in-place by two pointer: " + Arrays.toString(arr));

        // reset array for next method
        arr = new int[]{1, 2, 3, 4, 5};

        // reverse by internal method
        // By using streams collections, we will cover later

    }
}
