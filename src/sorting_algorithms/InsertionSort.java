package sorting_algorithms;

import static sorting_algorithms.Utils.*;

public class InsertionSort {

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
