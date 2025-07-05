package data_structures.arrays.two_pointer_technique;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * 👣 Two Pointer Technique
     *
     * - SORTED ARRAY
     * - Sort the array first, then use two pointers from both ends.
     *
     * compare left+right = target
     *  - if sum < target then left++
     *  - if sum > target then right--
     *
     * - Time: O(n log n) due to sorting, Space: O(1)
     *
     * - Returns values, not indices. Doesn't work on unsorted input directly.
     *
     */
    public static int[] twoSumTwoPointer(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);  // Sort is required for two pointer technique.

        int left = 0, right = n - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1}; // Not found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 13;

        System.out.println("Input Array - " + Arrays.toString(nums));
        System.out.println("Two Sum target - " + target);

        int[] elements;

        // Brute Force
        elements = twoSumBruteForce(nums, target);
        System.out.println("Brute Force Result - " + Arrays.toString(elements));

        // Hash Map
        elements = twoSumHashMap(nums, target);
        System.out.println("HashMap Result - " + Arrays.toString(elements));

        // Two Pointer (on sorted array)
        elements = twoSumTwoPointer(nums, target);
        System.out.println("Two Pointer Result - " + Arrays.toString(elements));
    }

    /**
     * 🔁 Brute Force
     * - Try every pair (i, j) and check if nums[i] + nums[j] == target.
     * - Time: O(n^2), Space: O(1)
     * - Not efficient for large inputs, but easy to understand.
     */
    private static int[] twoSumBruteForce(int[] nums, int target) {
        int[] output = new int[]{-1, -1};

        for (int i = 0; i < nums.length -1 ; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    output[0] = nums[i];
                    output[1] = nums[j];
                    return output;
                }
            }
        }
        return output;
    }

    /**
     * 🧠 HashMap Approach
     *
     * - Store seen numbers and check if (target - num) exists.
     *
     * - Time: O(n), Space: O(n)
     *
     * - Efficient and works for unsorted arrays.
     *
     */
    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (hashMap.containsKey(complement)) {
                return new int[]{nums[i], complement};
            }

            hashMap.put(nums[i], i);
        }

        return new int[]{-1, -1}; // Not found
    }

}
