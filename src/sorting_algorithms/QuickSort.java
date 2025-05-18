package sorting_algorithms;

import static sorting_algorithms.Utils.printArray;

public class QuickSort {
    /*
        "Divide and conquer using a pivot."

        - Step 1: Pick a pivot (first element)
        - Step 2: Partition the array:
            - Elements smaller <--- pivot ---> elements larger
            - Use two pointers (i from left, j from right)
            - Move 'i' until you find a number > pivot
            - Move 'j' until you find a number < pivot
            - If i < j → swap(arr[i], arr[j])
            - Repeat until i and j cross

        - Step 3: Swap pivot with arr[j] (final position for pivot)

        - Now, pivot is at correct place.

        - Step 4: Recursively apply quickSort to:
            - Left side (low to j-1)
            - Right side (j+1 to high)

        - Base case: stop when low >= high
    */
    static void quickSort(int[] arr) {
        qS(arr, 0, arr.length-1);
    }

    private static void qS(int[] arr, int low, int high) {
        if(low < high) {
            int partitionIndex = getPartition(arr, low, high);
            qS(arr, low, partitionIndex-1);
            qS(arr, partitionIndex+1, high);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int getPartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i < j) {

            while (arr[i] <= pivot && i < high) i++;
            while (arr[j] > pivot && j > low) j--;

            if (i < j) swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};

        printArray(arr, "Array - ");
        quickSort(arr);
        printArray(arr, "Sorted Array - ");
    }
}
