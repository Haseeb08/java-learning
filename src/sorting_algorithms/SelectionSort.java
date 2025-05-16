package sorting_algorithms;

import static sorting_algorithms.Utils.printArray;

public class SelectionSort {
    /*
        "Take one card at a time and insert it where it belongs."

        - Loop through array (1 -> n-1) (Assume first element is already sorted)

        - Store current element as key (key = arr[i])

        - Compare with elements in the sorted part (j = i-1 to 0)

        - SHIFTING elements one position to the right if they're greater than key

        - Insert the key at the correct position (arr[j+1] = key)

        - Repeat for all elements

    */
    static void selectionSort(int[] arr) {
        int minIndex;
        int n = arr.length;
        for (int i=0; i< n - 1; i++) {
            minIndex = i;

            // find smallest element in array (i+1 -> n)
            for (int j=i+1; j< n; j++) {
                if(arr[j]<arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                // swap
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};

        printArray(arr, "Array - ");
        selectionSort(arr);
        printArray(arr, "Sorted Array - ");
    }
}
