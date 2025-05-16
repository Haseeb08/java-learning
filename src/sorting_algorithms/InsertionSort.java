package sorting_algorithms;

import static sorting_algorithms.Utils.*;

public class InsertionSort {
    /*
       "Take one card at a time and insert it where it belongs."

       - Loop through array (1 -> n-1) (Assume first element is already sorted)

       - Store current element as key (key = arr[i])

       - Compare with elements in the sorted part (j = i-1 to 0)

       - SHIFTING elements one position to the right if they're greater than key

       - Insert the key at the correct position (arr[j+1] = key)

       - Repeat for all elements

   */
    static void insertionSort(int[] arr) {
        for(int i =1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];

            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};

        printArray(arr, "Array - ");
        insertionSort(arr);
        printArray(arr, "Sorted Array - ");
    }
}
