# Doubly Linked List (DLL)

A **Doubly Linked List (DLL)** is a type of linked list where each node contains:
- A **data field**
- A pointer to the **next node**
- A pointer to the **previous node**

---

## ❓ Why and When to Use

### ✅ Why
- Enables **bi-directional traversal** (forward & backward)

### 📌 When
- When you need **O(1) deletion given a node reference**
- When frequent access to the **previous node** is required
- When implementing advanced structures like:
    - **LRU Cache**
    - **Deque (Double-ended queue)**

---

## 🚀 Use Cases

- **Browser History** → Navigate back and forward
- **Music Players** → Next/Previous song
- **Undo/Redo Systems** → State navigation
- **Operating Systems** → Process scheduling queues

---

## ⚖️ Comparison: Singly vs Doubly Linked List

| Feature              | Singly Linked List (SLL)       | Doubly Linked List (DLL)        |
|---------------------|--------------------------------|---------------------------------|
| Pointers            | One (`next`)                   | Two (`next`, `prev`)            |
| Memory              | Lower                          | Higher (extra pointer)          |
| Traversal           | Forward only                   | Forward & Backward              |
| Delete Last         | O(n)                           | O(1) (using `tail.prev`)        |
| Complexity          | Simple                         | More complex                    |

---

## 🔧 DLL Operations

| Operation              | Time Complexity | Space Complexity | Notes                                      |
|------------------------|----------------|------------------|--------------------------------------------|
| Access                 | O(n)           | O(1)             | Requires traversal                         |
| Search                 | O(n)           | O(1)             | Can optimize with bidirectional traversal  |
| Insert (Start)         | O(1)           | O(1)             | Update `head` and `head.prev`              |
| Insert (End)           | O(1)           | O(1)             | Use `tail`                                 |
| Insert (Middle)        | O(n)           | O(1)             | Search + pointer updates                   |
| Delete (Start/End)     | O(1)           | O(1)             | Direct pointer updates                     |

---

## ⚠️ Important Points

- **Memory Overhead**  
  Each node uses ~33–50% more memory than SLL (extra pointer)

- **Four-Pointer Rule**  
  While inserting/deleting in middle, update:
    - Previous node's `next`
    - Next node's `prev`
    - New node's `prev`
    - New node's `next`

- **Bidirectional Optimization**  
  If index is in second half → start from **tail** instead of head

- **Null Constraints**
    - `head.prev = null`
    - `tail.next = null`

---

## 🧠 Common Interview Questions

1. **Reverse a DLL**
    - Swap `next` and `prev` for each node

2. **LRU Cache Implementation**
    - DLL + HashMap → O(1) insert, delete, access

3. **Find Pairs with Given Sum**
    - Use **two pointers** (head + tail) → O(n)

4. **Flatten Multilevel DLL**
    - Merge child lists into a single-level list

---

## 🖼️ Visualization (Conceptual)
NULL ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → NULL