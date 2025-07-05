# 📘 Sliding Window Technique – Master Reference

## 🔍 When to Use Sliding Window
Use the **sliding window** technique when a problem:
- Involves **arrays** or **strings**
- Asks about **contiguous subarrays or substrings**
- Requires **processing every window** of size `k` or **finding optimal** (max/min/longest/shortest) windows

---

## 🏱 Types of Sliding Window

| Type             | Description                                    | Examples                                                  |
|------------------|------------------------------------------------|-----------------------------------------------------------|
| **Fixed Size**    | Window of size `k`                             | First negative in every window, max sum of size `k`       |
| **Variable Size** | Window that grows/shrinks based on condition  | Longest substring with `k` unique characters, min window sum ≥ `x` |

---

## 🔁 General Pattern – Fixed Size Sliding Window

```java
int start = 0, end = 0;

while (end < n) {
        // Step 1: Include arr[end] in current window
        // Any logic related to arr[end]

        if (end - start + 1 < k) {
// Step 2: Window is not yet of size k
end++;
        } else if (end - start + 1 == k) {
// Step 3: Window has hit size k
// Do the required calculation for this window (e.g., store result)

// Step 4: Before sliding the window, update state if needed
// (e.g., remove arr[start] if it's part of the result)

// Step 5: Slide the window forward
start++;
end++;
        }
        }

```

Rough - 
```commandline
    while(end < n) {
        
        calculations :  related to end/current element
        
        if ( < k) {
            end++;
        } 
        
        else if ( == k ) {
            ans <-- calculations
            
            // prepare for slide, often needed to remove stuff related to start and increase end++
            start++
            end++ // if req
        }
    
    }
```
### ✅ Example Use Cases:
- First negative in every window
- Max element in every window of size `k`
- Max sum of subarray of size `k`

---

## 🔁 General Pattern – Variable Size Sliding Window

```java
int start = 0, end = 0;
int windowSum = 0;

while (end < n) {
    // Step 1: Expand the window
    windowSum += arr[end];

    // Step 2: While condition is violated, shrink the window
    while (windowSum > target) {
        windowSum -= arr[start];
        start++;
    }

    // Step 3: Check if current window is valid
    // Possibly update answer: minLen = Math.min(minLen, end - start + 1)

    end++;
}
```
rough - 
```commandline
while (end < s.length()) {
    // 1. Expand the window (include s[end])
    add s[end] to map or set;

    // 2. Check if the current window is valid
    if (condition is satisfied, like map.size() < k) {
        end++;
    }
    // 3. If window is valid and exactly meets requirement
    else if (condition is exactly met, like map.size() == k) {
        update answer (like maxLen);
        end++;
    }
    // 4. If window is invalid (constraint broken)
    else {
        while (window is invalid) {
            shrink from the start;
            update map/set;
            start++;
        }
        end++; // Continue expanding
    }
}

```

### ✅ Example Use Cases:
- Smallest subarray with sum ≥ `x`
- Longest substring with at most `k` distinct characters
- Substring with at most `k` zeros

---

## 🧠 Key Takeaways (Sticky Notes 🗘)

- `end - start + 1` gives current window size
- Condition to expand window: `end - start + 1 < k`
- Condition to process window: `end - start + 1 == k`
- Before moving `start++`, check if `arr[start]` needs to be removed from current window state
- Sliding window helps bring **O(n * k)** brute force to **O(n)** in many problems
- Use **deque** when you need to track first/maximum/minimum element efficientlyl

---

## 🧪 Quick Problem Practice Checklist

| Problem                                               | Type          |
|--------------------------------------------------------|---------------|
| First Negative Number in Every Window of Size K        | Fixed Size    |
| Maximum Sum Subarray of Size K                         | Fixed Size    |
| Maximum of All Subarrays of Size K                     | Fixed Size + Deque |
| Smallest Subarray with Sum ≥ X                         | Variable Size |
| Longest Substring with K Distinct Characters           | Variable Size |
| Count Occurrences of Anagrams                          | Fixed Size + Map |
| Longest Substring with All Unique Characters           | Variable Size |