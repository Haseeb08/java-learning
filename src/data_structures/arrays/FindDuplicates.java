package data_structures.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class FindDuplicates {

    private static int findDuplicateByBruteForce(int[] arr) {
        /*
         *      Brute Force
         *
         * Compares every pair of elements in the array to detect duplicates.
         *
         *
         * Time Complexity: O(n²) — nested loops over the array
         * Space Complexity: O(1) — no extra space used
         *
         */
        int n = arr.length;

        for (int i=0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i]==arr[j]) return arr[i];
            }
        }
        return -1;
    }

    private static int findDuplicateBySorting(int[] arr) {
        /*
         *      By Sorting
         *
         * First sort the array then check adjacent element is equal
         * loop i -> n-1
         *
         * Time Complexity: O(n log n) — due to sorting
         * Space Complexity: O(1) or O(n) depending on sorting algorithm used
         *
         */
        Arrays.sort(arr);

        for (int i = 0; i < arr.length -1; i++) {
            if(arr[i]==arr[i+1]) return arr[i];
        }

        return -1;
    }

    private static int findDuplicateByHashing(int[] arr) {
        /*
         * By using Hashing technique: HashSet
         *
         * loop over array element
         * Check Set contains the element ? return element : add(element)
         *
         * Time Complexity: O(n)
         * Space Complexity: O(n)
         *
         */
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3};

        System.out.println("Array: " + Arrays.toString(arr));

        int duplicateElement = findDuplicateByBruteForce(arr);
        System.out.println("Brute force - "+ duplicateElement);

        duplicateElement = findDuplicateBySorting(arr);
        System.out.println("By Sorting - "+ duplicateElement);

        duplicateElement = findDuplicateByHashing(arr);
        System.out.println("Hashing duplicate: " + duplicateElement);

    }
}
