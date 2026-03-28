package data_structures.linkedlists.singlelinkedlist;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    // O(1) complexity
    public void insertFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;

        if (tail == null) { // If it was the first node ever added
            tail = head;
        }
        size++;
    }

    // O(1) complexity because we maintain a tail pointer
    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insertAt(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) { // Corrected: Inserting at the very end
            insertLast(value);
            return;
        }
        if (index > size || index < 0) {
            System.out.println("Invalid Index");
            return;
        }

        // Navigate to the node right before the insertion point
        Node temp = getNode(index - 1);

        // Use the constructor Node(val, next) to link in one step
        Node newNode = new Node(value, temp.next);
        temp.next = newNode;
        size++;
    }

    // O(1) complexity
    public int deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }
        int val = head.value;
        head = head.next;

        if (head == null) { // If list became empty after deletion
            tail = null;
        }
        size--;
        return val;
    }

    // O(n) complexity because we must find the second-to-last node
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = getNode(size - 2);
        int val = tail.value;

        tail = secondLast;
        tail.next = null; // Break the link to the old tail
        size--;
        return val;
    }

    public int deleteAt(int index) {
        if (index == 0) return deleteFirst();
        if (index == size - 1) return deleteLast();
        if (index >= size || index < 0) return -1;

        Node prevNode = getNode(index - 1);
        int val = prevNode.next.value;

        // Bypass the target node
        prevNode.next = prevNode.next.next;
        size--;
        return val;
    }

    // Helper to get node at specific index - O(n)
    public Node getNode(int index) {
        if (index < 0 || index >= size) return null;

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Node findNodeWithValue(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) return node;
            node = node.next;
        }
        return null;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("END (Size: " + size + ")");
    }

    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}