package sorting_algorithms;

import static sorting_algorithms.Utils.printArray;

public class SelectionSort {
    /*
     "Find the smallest, put it first."

     - Loop through array (0 -> n-1) (Assuming minIndex is current index)

     - Pick the smallest in the remaining part (i+1 -> n) (Update minIndex)

     - Swap it to the front (If minIndex != i)

     - Repeat for the next index
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
