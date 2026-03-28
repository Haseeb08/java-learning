# Singly Linked List (SLL)

A **Singly Linked List (SLL)** is a linear data structure where each element (**node**) contains:
- A **data field**
- A **reference (pointer)** to the next node

Unlike arrays, elements are **not stored in contiguous memory locations**.

---

## ❓ Why and When to Use

### ✅ Why
- Dynamic size (can grow/shrink easily)
- No expensive resizing or copying like arrays

### 📌 When
- When the number of elements is **unknown beforehand**
- When you need **O(1) insertion/deletion at the beginning**
- When memory is **fragmented** (non-contiguous allocation works)

---

## 🚀 Use Cases

- **Stacks and Queues** → Only ends are manipulated
- **Image Viewer** → Navigate sequentially (next image)
- **Undo/Redo Functionality** → Track state changes
- **File System Management** → Disk block allocation (e.g., FAT)

---

## ⚖️ Comparison: Linked List vs Array List

| Feature                | Linked List                         | Array List                          |
|----------------------|------------------------------------|-------------------------------------|
| Access (Random)      | O(n) – Traverse from head          | O(1) – Index-based                  |
| Insert/Delete (Start)| O(1) – Pointer update              | O(n) – Shift elements               |
| Insert/Delete (End)  | O(1) with tail pointer             | O(1) amortized (resize possible)    |
| Memory Locality      | Poor (cache misses)                | Excellent (sequential access)       |
| Memory Overhead      | High (extra pointers)              | Low (only data stored)              |

---

## 🔧 Linked List Operations

| Operation            | Time Complexity | Space Complexity | Notes                          |
|---------------------|----------------|------------------|--------------------------------|
| Access              | O(n)           | O(1)             | No direct indexing             |
| Search              | O(n)           | O(1)             | Linear traversal               |
| Insert (Front)      | O(1)           | O(1)             | Update head                    |
| Insert (Last)       | O(1)           | O(1)             | Needs tail pointer             |
| Insert (Middle)     | O(n)           | O(1)             | Find position first            |
| Delete (Front)      | O(1)           | O(1)             | Move head → head.next          |
| Delete (Last)       | O(n)           | O(1)             | Find second last node          |

---

## ⚠️ Important Points

- **Tail Pointer Optimization**  
  Maintain a `tail` pointer → makes `insertLast` = O(1)

- **Sentinel (Dummy) Node**  
  Helps simplify edge cases (especially deletion)

- **No Backward Traversal**  
  Cannot move backwards in SLL

- **Head Safety**  
  Losing the head = losing the entire list (GC will clean it)

- **CPU Cache Issue**  
  Despite O(1) insertions, LLs are often slower than arrays due to **poor cache locality**

---

## 🧠 Common Interview Questions

1. **Cycle Detection**
    - Floyd’s Cycle Detection (Fast & Slow pointers)

2. **Middle of Linked List**
    - Single pass using Fast & Slow pointers

3. **Reverse Linked List (In-place)**
    - Change pointer directions without extra space

4. **Merge Two Sorted Lists**
    - Combine while maintaining sorted order

5. **Palindrome Check**
    - Check if list reads same forward & backward

6. **Remove Nth Node from End**
    - One-pass solution using two pointers

---

## 🖼️ Visualization (Conceptual)
Array:
[10][20][30][40] (contiguous memory)

Linked List:
10 → 20 → 30 → 40 → NULL (non-contiguous memory)