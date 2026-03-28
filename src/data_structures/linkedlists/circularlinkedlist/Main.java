package data_structures.linkedlists.circularlinkedlist;

public class Main {
    public static void main(String[] args) {
        data_structures.linkedlists.circularlinkedlist.CLL list = new CLL();

        System.out.println("=== Phase 1: Circular Insertions ===");
        // insert() typically adds after the tail (at the 'head' position)
        list.insert(10);
        list.insert(20);
        list.insert(30);

        // insertLast() adds at the end and updates the tail pointer
        list.insertLast(40);
        list.insertLast(50);

        System.out.print("Current Circular List: ");
        list.display();
        // Expected: 30 -> 20 -> 10 -> 40 -> 50 -> HEAD

        System.out.println("\n=== Phase 2: Deletion Logic ===");
        System.out.println("Deleting 30 (The Head)...");
        list.delete(30);
        list.display();

        System.out.println("Deleting 50 (The Tail)...");
        list.delete(50);
        list.display();

        System.out.println("Deleting 10 (Middle Node)...");
        list.delete(10);
        list.display();

        System.out.println("\n=== Phase 3: Edge Cases ===");
        System.out.println("Deleting remaining nodes...");
        list.delete(20);
        list.delete(40);
        list.display(); // Should show "List is empty"

        System.out.println("\n=== Phase 4: Restarting List ===");
        list.insert(100);
        list.display();
    }
}