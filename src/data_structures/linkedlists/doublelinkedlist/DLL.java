package data_structures.linkedlists.doublelinkedlist;

/**
 * Implementation of a Doubly Linked List.
 * Provides O(1) insertion/deletion at both ends.
 */
public class DLL {

    private Node head;
    private Node tail;
    private int size;

    public DLL() {
        this.size = 0;
    }

    /**
     * Inserts a new value at the beginning of the list.
     * Time Complexity: O(1)
     */
    public void insertFirst(int val) {
        Node newNode = new Node(val);

        // Point new node's next to current head
        newNode.next = head;
        newNode.prev = null;

        if (head != null) {
            // If list wasn't empty, link current head back to new node
            head.prev = newNode;
        } else {
            // If list was empty, the new node is also the tail
            tail = newNode;
        }

        head = newNode;
        size++;
    }

    /**
     * Inserts a new value at the end of the list.
     * Time Complexity: O(1) - due to tail pointer.
     */
    public void insertLast(int val) {
        // If list is empty, redirect to insertFirst
        if (tail == null) {
            insertFirst(val);
            return;
        }

        Node newNode = new Node(val);

        // Link new node to current tail
        newNode.prev = tail;
        tail.next = newNode;

        // Update tail to be the new node
        tail = newNode;
        size++;
    }

    /**
     * Inserts value at a specific index.
     * Time Complexity: O(n/2) -> O(n)
     */
    public void insertAt(int value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }

        // Get the node currently at the insertion index
        Node nextNode = getNode(index);
        Node prevNode = nextNode.prev;

        // Create new node and link it bidirectionally to neighbors
        Node newNode = new Node(value, nextNode, prevNode);

        prevNode.next = newNode;
        nextNode.prev = newNode;

        size++;
    }

    /**
     * Removes the first node.
     * Time Complexity: O(1)
     */
    public int deleteFirst() {
        if (head == null) return -1;

        int val = head.value;
        head = head.next;

        if (head != null) {
            // New head has no previous node
            head.prev = null;
        } else {
            // List is now empty
            tail = null;
        }

        size--;
        return val;
    }

    /**
     * Removes the last node.
     * Time Complexity: O(1) - Major advantage of DLL over SLL.
     */
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        int val = tail.value;

        // Move tail back one step
        tail = tail.prev;
        // Break the link to the old tail to allow Garbage Collection
        tail.next = null;

        size--;
        return val;
    }

    /**
     * Helper to find a node at a specific index.
     * Optimization: Checks if index is closer to head or tail.
     */
    public Node getNode(int index) {
        if (index < 0 || index >= size) return null;

        Node temp;
        // If index is in the first half, crawl forward from head
        if (index < size / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        // If index is in the second half, crawl backward from tail
        else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " <=> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void displayReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.value + " <=> ");
            temp = temp.prev;
        }
        System.out.println("START");
    }

    public Node find(int val) {
        Node temp = head;
        while(temp != null) {
            if(temp.value == val) {
                return temp;
            } else {
                temp=temp.next;
            }
        }
        return null;
    }

    /**
     * Static inner class
     * Static means it doesn't hold a reference to the outer DLL class,
     * saving a few bytes of memory per node.
     */
    class Node {
        int value;
        Node next;
        Node prev;

        private Node(int value) {
            this.value = value;
        }

        private Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}