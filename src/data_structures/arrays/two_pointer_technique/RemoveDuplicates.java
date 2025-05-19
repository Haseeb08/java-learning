package data_structures.arrays.two_pointer_technique;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Remove duplicates from a sorted array.
 * - Optimized In-place (Two Pointer Technique)
 * - Brute Force (Extra array)
 * - Using HashSet (for unsorted arrays)
 */
public class RemoveDuplicates {

    /**
     * Optimized Approach using Two-Pointer Technique
     * ----------------------------------------------
     * Removes duplicates from a sorted array in-place and returns a new trimmed array.
     *
     * keep track of lastUniqueElementIndex.
     * - if current element is not equal to element at lastUniqueElementIndex
     * then increase lastUniqueElementIndex and add arr[i] to it.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) extra space (ignoring the returned array copy)
     *
     * @param arr Sorted integer array
     * @return New array with duplicates removed
     */
    public static int[] removeDupsOptimized(int[] arr) {
        if (arr.length == 0) return new int[]{};

        int indexOfLastUniqueElement = 0; // Index of last unique element

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[indexOfLastUniqueElement]) {
                indexOfLastUniqueElement++;
                arr[indexOfLastUniqueElement] = arr[i]; // Overwrite duplicate position
            }
        }
        return Arrays.copyOf(arr, indexOfLastUniqueElement + 1); // Return trimmed array
    }

    public static void main(String[] args) {
        // Example -
        // Input:  [1, 1, 2, 2, 3, 4, 4]
        // Output: [1, 2, 3, 4]

        int[] arr = {1, 1, 2, 2, 3, 4, 4};
        System.out.println("Input Array - " + Arrays.toString(arr));

        // Optimized
        int[] optimized = removeDupsOptimized(Arrays.copyOf(arr, arr.length));
        System.out.println("Optimized Output - " + Arrays.toString(optimized));

        // Brute Force
        int[] brute = removeDupsBruteForce(arr);
        System.out.println("Brute Force Output - " + Arrays.toString(brute));

        // Hashing (for unsorted arrays)
        int[] unsorted = {4, 2, 1, 2, 3, 4, 1};
        int len = removeDupsUsingSet(unsorted);
        System.out.println("Using HashSet Output - " + Arrays.toString(Arrays.copyOf(unsorted, len)));
    }

    /**
     * Brute Force Approach
     * --------------------
     * Assumes the array is sorted.
     * Comparing previous adjacent, Copies unique elements to a new array.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param arr Sorted input array
     * @return New array with duplicates removed
     */
    public static int[] removeDupsBruteForce(int[] arr) {
        int[] uniqueArry = new int[arr.length];
        int index = 1;

        uniqueArry[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                uniqueArry[index] = arr[i];
                index++;
            }
        }

        return Arrays.copyOf(uniqueArry, index);
    }

    /**
     * HashSet Approach (For Unsorted Arrays)
     * --------------------------------------
     * Keeps only unique elements using HashSet.
     * - if set contains then skip
     * - if set not contains then update arr[index++] = num
     *
     * Not suitable for maintaining original order or sorting.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param arr Unsorted array
     * @return Number of unique elements (array modified in-place for first 'n' elements)
     */
    public static int removeDupsUsingSet(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        int index = 0;

        for (int num : arr) {
            if (!seen.contains(num)) {
                seen.add(num);
                arr[index++] = num;
            }
        }

        return index; // Length of array with unique elements
    }
}
