package data_structures.linkedlists.doublelinkedlist;

public class Main {
    public static void main(String[] args) {
        DLL list = new DLL();

        System.out.println("=== Phase 1: Basic Insertions ===");
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertLast(30);
        list.insertLast(40);

        System.out.print("Forward:  ");
        list.display();        // Expected: 20 <=> 10 <=> 30 <=> 40 <=> END
        System.out.print("Backward: ");
        list.displayReverse(); // Expected: 40 <=> 30 <=> 10 <=> 20 <=> START

        System.out.println("\n=== Phase 2: Positional Insertion ===");
        // Inserting 25 at index 2 (between 10 and 30)
        list.insertAt(25, 2);
        list.display();

        System.out.println("\n=== Phase 3: Deletions ===");
        System.out.println("Removing First: " + list.deleteFirst()); // Removes 20
        System.out.println("Removing Last:  " + list.deleteLast());  // Removes 40
        list.display();

        System.out.println("\n=== Phase 4: Search & Optimization Check ===");
        // This will trigger the 'second-half' optimization in your getNode method
        int valToFind = 25;
        DLL.Node found = list.find(valToFind);

        if (found != null) {
            System.out.println("Node with value " + valToFind + " located.");
            // Verification of bidirectional link
            if (found.next != null) System.out.println("Next node: " + found.next.value);
            if (found.prev != null) System.out.println("Prev node: " + found.prev.value);
        }

        System.out.println("\n=== Phase 5: Edge Case Handling ===");
        list.deleteFirst();
        list.deleteFirst();
        list.deleteFirst(); // List should be empty now
        System.out.print("Empty List: ");
        list.display();

        // Ensure system doesn't crash on empty delete
        System.out.println("Deleting from empty: " + list.deleteFirst());
    }
}