# Arrays - Notes

## 1. Internal Structure
- Arrays in Java are **contiguous memory blocks**.
- Elements are stored in adjacent memory locations.
- Each element can be accessed in O(1) time using index.

## 2. Memory and Resizing
- Arrays in Java are **fixed-size**.
- Resizing requires creating a new larger array and copying all elements.
- For dynamic resizing, use ArrayList (handled internally).

## 3. Time Complexities
- Access (Read): O(1)
- Update: O(1)
- Insert at end (if space available): O(1)
- Insert at middle/start: O(n)
- Delete: O(n)
- Resize (copy to new array): O(n)

## 4. Common topics and Techniques

### a. Rotate Array
- Right/Left rotate elements by `k` positions.
- Use reversal algorithm or extra space.

### b. Reverse Array
- Two-pointer approach: swap from both ends.

### c. Find Duplicates
- Use HashSet or frequency array.
- Variants: print all duplicates, find one duplicate, etc.

### d. Two-Pointer Technique
- Use two indices to traverse from both ends or sides.
- Examples: pair sum, reverse, remove duplicates, etc.

## 5. Best Practices
- Always validate array bounds.
- Prefer enhanced `for-each` loop for read-only traversal.
- Use utility methods from `Arrays` class (like `Arrays.sort`, `Arrays.copyOf`, etc.).

## 5. Important Array Methods (from `java.util.Arrays`)

import java.util.Arrays;

// Sorts the array in ascending order
Arrays.sort(arr);

// Returns a string representation of the array
Arrays.toString(arr);

// Compares two arrays for equality
Arrays.equals(arr1, arr2);

// Returns a copy of the original array with the specified length
Arrays.copyOf(arr, newLength);

// Copies a range of elements into a new array
Arrays.copyOfRange(arr, start, end);

// Fills the array with a specified value
Arrays.fill(arr, value);

// Searches for key in a sorted array using binary search
Arrays.binarySearch(arr, key);

// Converts the array to a Stream (Java 8+)
Arrays.stream(arr);

// Clones the array
 arr.clone();

## 6. Interview Tips
- Know how to rotate in-place vs with extra space.
- Be ready to solve variants of two-sum, reverse, etc.
- Time/space tradeoffs: brute-force vs optimized approaches.
- Carefully handle edge cases: empty array, single element, k > n.

