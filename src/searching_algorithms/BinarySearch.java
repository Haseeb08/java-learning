package searching_algorithms;

import java.util.Arrays;

public class BinarySearch {

    private static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;

        if (target == arr[mid]) return mid;
        else if (target < arr[mid]) return binarySearchRecursive(arr, target, low, mid - 1);
        else return binarySearchRecursive(arr, target, mid + 1, high);
    }

    private static int binarySearchIterative(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == arr[mid]) return mid;
            else if (target < arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    // Util - Reusable method to print result
    private static void printResult(int index, String method) {
        System.out.println("\n--- " + method + " Binary Search ---");
        if (index == -1) {
            System.out.println("Element not found (" + method + ")");
        } else {
            System.out.println("Element found at index - " + index + " (" + method + ")");
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int target = 8;

        System.out.println("Array - " + Arrays.toString(arr));
        System.out.println("Target - " + target);

        int recursiveIndex = binarySearchRecursive(arr, target, 0, arr.length - 1);
        int iterativeIndex = binarySearchIterative(arr, target, 0, arr.length - 1);

        printResult(recursiveIndex, "Recursive");
        printResult(iterativeIndex, "Iterative");
    }
}
