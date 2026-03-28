# Circular Linked List (CLL)

A **Circular Linked List (CLL)** is a variation of a linked list where:
- The **last node points back to the first node (head)**
- There is **no `null` at the end**
- It forms a **closed loop**

---

## ❓ Why and When to Use

### ✅ Why
- Allows **continuous traversal** without resetting to head

### 📌 When
- When multiple entities share resources in a **round-robin** manner
- When traversal can start from **any node**
- When implementing **circular buffers** or streaming systems

---

## 🚀 Use Cases

- **Operating Systems** → Round-robin CPU scheduling
- **Multiplayer Games** → Player turn rotation
- **Media Players** → "Repeat All" playlist
- **Circular Buffers** → Keyboard/input buffering

---

## ⚖️ Comparison: SLL vs DLL vs CLL

| Feature        | Singly Linked List (SLL) | Doubly Linked List (DLL) | Circular Linked List (CLL) |
|----------------|--------------------------|---------------------------|-----------------------------|
| Termination    | Ends at `null`           | Ends at `null`            | Ends at head (loop)         |
| Navigation     | Forward only             | Forward & Backward        | Forward (continuous)        |
| Memory         | Low (1 pointer)          | High (2 pointers)         | Low (1 pointer)             |
| Last Node      | Points to `null`         | Points to `null`          | Points to head              |

---

## 🔧 CLL Operations (Using Tail Pointer)

| Operation           | Time Complexity | Notes                                                                 |
|--------------------|----------------|-----------------------------------------------------------------------|
| Access / Search     | O(n)           | Traverse entire loop                                                  |
| Insert (Start)      | O(1)           | New node → `tail.next`, then update `tail.next`                       |
| Insert (End)        | O(1)           | Same as start, then move `tail` to new node                           |
| Delete              | O(n)           | Need previous node to bypass target                                   |

---

## ⚠️ Important Points

- **Tail Pointer Optimization**  
  Maintaining only a `tail` pointer is efficient:
    - `tail` → last node
    - `tail.next` → head  
      → Gives O(1) access to both ends

- **Infinite Loop Risk**  
  Avoid `while (temp != null)`  
  Use:
    - `do-while` loop OR
    - Stop when you reach the **starting node again**

- **Single Node Case**
    - `node.next = node` (points to itself)
    - Handle carefully during deletion

- **No Nulls**  
  Ideal for systems requiring **continuous looping** without boundary checks

---

## 🧠 Common Interview Questions

1. **Split a CLL**
    - Divide into two equal circular lists

2. **Check if List is Circular**
    - Use Floyd’s Cycle Detection

3. **Josephus Problem**
    - Elimination problem solved efficiently using CLL

4. **Convert SLL → CLL**
    - Traverse to last node and link it to head → O(n)

---

## 🖼️ Visualization (Conceptual)
10 → 20 → 30 → 40 
<br>
^───────────┘