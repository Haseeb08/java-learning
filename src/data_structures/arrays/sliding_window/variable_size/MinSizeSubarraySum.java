package data_structures.arrays.sliding_window.variable_size;

/**
 * Problem: Given an array of positive integers and a target sum,
 * find the minimal length of a contiguous subarray of which the sum is
 * greater than or equal to the target. If no such subarray exists, return 0.
 *
 * Example:
 * Input: target = 7, arr = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length of 2.
 */
public class MinSizeSubarraySum {

    /**
     * Sliding Window Optimized Approach
     * -----------------------------------
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * This uses a dynamic window which expands with the end pointer and shrinks
     * from the start whenever the window sum becomes greater than or equal to the target.
     *
     * This avoids checking every possible subarray like the brute force method.
     */
    private static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            windowSum += nums[end]; // Expand the window by including nums[end]

            // Shrink the window as small as possible while the condition is still met
            while (windowSum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                windowSum -= nums[start]; // Shrink from left
                start++;
            }
        }

        // If no subarray found, return 0
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    /**
     * Brute Force Approach
     * ----------------------
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * This approach checks all possible subarrays starting at each index,
     * and stops early if a valid subarray (sum >= target) is found.
     * Not suitable for large inputs but easy to understand.
     */
    public static int minSubArrayLenBruteForce(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;

        for (int start = 0; start < nums.length; start++) {
            int sum = 0;

            for (int end = start; end < nums.length; end++) {
                sum += nums[end];

                if (sum >= target) {
                    minLen = Math.min(minLen, end - start + 1);
                    break; // No need to continue this inner loop
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        System.out.println("Target: " + target);
        System.out.print("Input Array: ");
        for (int num : nums) System.out.print(num + " ");
        System.out.println();

        int len1 = minSubArrayLenBruteForce(target, nums);
        System.out.println("Brute Force - Minimum Subarray Length: " + len1);

        int len2 = minSubArrayLen(target, nums);
        System.out.println("Sliding Window - Minimum Subarray Length: " + len2);
    }
}
