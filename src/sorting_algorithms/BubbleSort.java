package sorting_algorithms;

import static sorting_algorithms.Utils.*;

public class BubbleSort {
    /*

    - Sorts elements by comparing the adjacent elements
    and re-arranging them if they are in wrong order.

    - Swap adjacent elements if they are in wrong order

    - After every iteration, the highest element moves at the end of array
        that's why "arr.length -i -1" in the second loop

     */
    static void bubbleSort(int[] arr) {
        for (int i=0; i< arr.length -1; i++) {
            for (int j=0; j< arr.length -i -1; j++) {
                if(arr[j]>arr[j+1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};

        printArray(arr, "Array - ");
        bubbleSort(arr);
        printArray(arr, "Sorted Array - ");
    }
}