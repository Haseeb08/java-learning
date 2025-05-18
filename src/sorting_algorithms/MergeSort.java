package sorting_algorithms;

import static sorting_algorithms.Utils.printArray;

public class MergeSort {
    /*
        "Divide the array, then conquer by merging."

        - Recursively divide the array into two halves until each part has only one element.
          (Base case: low >= high)

        - Merge the sorted halves:
            - Use two pointers to track left and right subarrays
            - Pick the smaller of the two and add it to a temporary array
            - When one side is exhausted, copy the rest of the other side

        - Copy the merged (sorted) temp array back to the original array.

         Repeat this divide & merge until the full array is sorted.
    */

    private static void ms(int[] arr, int low, int high) {
        if(low >= high) return;
        int mid = (low + high) / 2;
        ms(arr, low, mid);
        ms(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high-low + 1];
        int tempIndex = 0;
        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp[tempIndex] = arr[left];
                tempIndex++;
                left++;
            } else {
             temp[tempIndex] = arr[right];
             tempIndex++;
             right++;
            }
        }

        while (left <= mid) {
            temp[tempIndex] = arr[left];
            tempIndex++;
            left++;
        }
        while (right <= high) {
            temp[tempIndex] = arr[right];
            tempIndex++;
            right++;
        }

        // copy temp into arr
        for (int i = 0; i< temp.length; i++) arr[low+i] = temp[i];
    }

    private static void mergeSort(int[] arr) {
        ms(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};

        printArray(arr, "Array - ");
        mergeSort(arr);
        printArray(arr, "Sorted Array - ");
    }
}
