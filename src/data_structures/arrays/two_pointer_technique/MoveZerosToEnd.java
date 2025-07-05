package data_structures.arrays.two_pointer_technique;

import java.util.Arrays;

public class MoveZerosToEnd {

    /**
     * ✅ Optimized: Two-pointer technique
     * Moves all non-zero elements to the front, fills remaining with 0s.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     */
    private static void moveZerosToEnd(int[] arr) {
        // Pointer to place the next non-zero element
        int lastNonZeroIndex = 0;

        // Move non-zero elements forward
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[lastNonZeroIndex++] = arr[i];
            }
        }

        // Fill the rest with zeros
        while (lastNonZeroIndex < arr.length) {
            arr[lastNonZeroIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        // Example:
        // Input:  [0, 0, 0, 3, 12]
        // Output: [3, 12, 0, 0, 0]

        int[] arr = new int[]{0, 0, 0, 3, 12};
        System.out.println("Input Array  - " + Arrays.toString(arr));

        moveZerosToEnd(arr);
        System.out.println("Updated Array - " + Arrays.toString(arr));
    }

    /**
     * 💡 Brute Force:
     * Create a new array, copy non-zero elements, and fill the rest with 0s.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] moveZerosBruteForce(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int index = 0;

        // Copy non-zero elements
        for (int num : arr) {
            if (num != 0) result[index++] = num;
        }

        // Remaining positions in result[] are already 0 by default
        return result;
    }

    /**
     * 🔄 Swap-based Optimized:
     * Swap non-zero elements with zero positions using One pointers.
     * Avoids unnecessary writes if elements are already in place.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void moveZerosSwap(int[] arr) {
        int j = 0; // Pointer to track position to swap with

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                // Swap only when needed (i != j)
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }
}
