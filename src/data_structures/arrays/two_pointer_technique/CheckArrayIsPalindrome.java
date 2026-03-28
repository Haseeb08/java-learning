package data_structures.arrays.two_pointer_technique;

import java.util.Arrays;

public class CheckArrayIsPalindrome {

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,1};
        System.out.println("Array - "+ Arrays.toString(arr));

        boolean isPalindrome = checkIsPalindrome(arr);
        System.out.println("Array is palindrome - "+ isPalindrome);
    }

    // Two Pointers Approach
    private static boolean checkIsPalindrome(int[] arr) {
        if (arr.length==0) return false;
        if (arr.length==1) return true;

        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            if (arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    /* Other ways to solve

    1. Reverse the array into a new array then compare both
    2. Recursion.

    */
    private static boolean checkIsPalindromeRecursive(int[] arr, int left, int right) {
        if (left >= right) return true;
        if (arr[left] != arr[right]) return false;
     return checkIsPalindromeRecursive(arr, left + 1, right -1);
    }
}
