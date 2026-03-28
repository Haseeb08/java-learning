package data_structures.linkedlists.singlelinkedlist;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();

        System.out.println("--- Testing Insertions ---");
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        System.out.print("After insertFirst (1,2,3): ");
        list.display();

        list.insertLast(4);
        list.insertLast(5);
        System.out.print("After insertLast (4,5): ");
        list.display();

        // Testing the corrected insertAt logic
        System.out.println("\n--- Testing InsertAt ---");
        list.insertAt(100, 0); // Insert at Start
        list.insertAt(200, 6); // Insert at End (index == size)
        list.insertAt(50, 3);  // Insert in Middle
        list.display();

        System.out.println("\n--- Testing Deletions ---");
        System.out.println("Deleted First: " + list.deleteFirst());
        list.display();

        System.out.println("Deleted Last: " + list.deleteLast());
        list.display();

        System.out.println("Deleted at Index 2: " + list.deleteAt(2));
        list.display();

        System.out.println("\n--- Testing Search ---");
        int searchVal = 50;
        if (list.findNodeWithValue(searchVal) != null) {
            System.out.println("Value " + searchVal + " found in list.");
        } else {
            System.out.println("Value " + searchVal + " not found.");
        }

        // Final State Check
        System.out.println("\n--- Final List State ---");
        list.display();
    }
}