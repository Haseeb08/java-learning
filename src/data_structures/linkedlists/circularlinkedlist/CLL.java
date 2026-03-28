package data_structures.linkedlists.circularlinkedlist;

/**
 * Circular Linked List Implementation.
 * In this version, we only track the 'tail' to gain O(1) access to both
 * the last element and the first element (tail.next).
 */
public class CLL {

    private Node tail;
    private int size;

    public CLL() {
        this.tail = null;
        this.size = 0;
    }

    /**
     * Inserts a value at the "beginning" (immediately after tail).
     * Time Complexity: O(1)
     */
    public void insert(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            tail = newNode;
            newNode.next = tail; // Points to itself
        } else {
            newNode.next = tail.next; // New node points to the old head
            tail.next = newNode;      // Tail now points to the new head
        }
        size++;
    }

    /**
     * Inserts a value at the end.
     * Logic is identical to insert(), but we move the tail pointer forward.
     * Time Complexity: O(1)
     */
    public void insertLast(int val) {
        insert(val);   // Insert at head
        tail = tail.next; // Move tail to the new node, making it the 'last' node
    }

    /**
     * Deletes a node with a specific value.
     * Time Complexity: O(n)
     */
    public void delete(int val) {
        if (tail == null) return;

        Node curr = tail.next; // Start at the head
        Node prev = tail;

        // Special case: Only one node in the list
        if (curr == tail && curr.value == val) {
            tail = null;
            size = 0;
            return;
        }

        // Traverse the circle
        do {
            if (curr.value == val) {
                prev.next = curr.next;
                if (curr == tail) {
                    tail = prev; // Update tail if the last node was deleted
                }
                size--;
                break;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);
    }

    public void display() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = tail.next; // Start at head
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != tail.next);

        System.out.println("HEAD (Size: " + size + ")");
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}