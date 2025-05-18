package searching_alogorithms;

import java.util.Arrays;

public class LinearSearch {


    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int target = 8;

        System.out.println("Array - " + Arrays.toString(arr));
        System.out.println("Target - " + target);

        int index = linearSearch(arr, target);

        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index - " + index );
        }
    }

    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }

        return -1;
    }
}
