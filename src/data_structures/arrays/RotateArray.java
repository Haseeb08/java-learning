package data_structures.arrays;

import java.util.Arrays;

public class RotateArray {

    private static void rotateBruteForce(int[] arr1, int k) {
        /*
         * Brute force
         *
         * Rotate by K = k times rotate by 1
         *
         * Time complexity - O(n x k)
         * Space complexity - O(1)
         *
         */
        int n = arr1.length;

        while (k > 0) {
            int lastElement = arr1[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                arr1[i + 1] = arr1[i];
            }
            arr1[0] = lastElement;

            k--;
        }
    }

    private static void rotateUsingTempArray(int[] arr2, int k) {
        /*
         * Rotates the array to the right by k steps using a temporary array.
         *
         * - Create a temporary array of same size.
         * - Place each element of the original array at its new index: (i + k) % n
         * - Copy the contents of the temp array back into the original array.
         *
         * Time Complexity: O(n)
         * Space Complexity: O(n)
         *
         */

        int n = arr2.length;
        k = k % n;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[( i + k ) % n] = arr2[i];
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = temp[i];
        }
    }

    private static void rotateByReversing(int[] arr3, int k) {
        /*
         * Rotates the array to the right by k steps using the reversal algorithm.
         *
         * - Reverse the whole array.
         * - Reverse the first k elements.
         * - Reverse the remaining n-k elements.
         *
         * Example : [1,2,3,4,5,6,7], k=3
         * Step 1: Reverse whole array -> [7,6,5,4,3,2,1]
         * Step 2: Reverse first k=3 -> [5,6,7,4,3,2,1]
         * Step 3: Reverse rest -> [5,6,7,1,2,3,4]
         *
         * Time Complexity: O(n)
         * Space Complexity: O(1)
         *
         */
        int n = arr3.length;
        k = k % n;

        reverse(arr3, 0, n-1);
        reverse(arr3, 0, k-1);
        reverse(arr3, k, n-1);
    }

    private static void reverse(int[] arr, int low, int high) {
        while (low<high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        System.out.println("Original: " + Arrays.toString(arr));

        int[] arr1 = arr.clone();
        rotateBruteForce(arr1, k);
        System.out.println("Brute Force: " + Arrays.toString(arr1));

        int[] arr2 = arr.clone();
        rotateUsingTempArray(arr2, k);
        System.out.println("Using Temp Array: " + Arrays.toString(arr2));

        int[] arr3 = arr.clone();
        rotateByReversing(arr3, k);
        System.out.println("By Reversing: " + Arrays.toString(arr3));
    }
}
