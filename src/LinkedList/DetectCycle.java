package LinkedList;

public class DetectCycle {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to detect loop
    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        // Floyd's Cycle Detection Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Loop detected
            }
        }

        return false; // No loop
    }

    // Main method to test
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Uncomment below to create a cycle (loop back to node 2)
        // head.next.next.next.next.next = head.next;

        boolean result = hasCycle(head);
        System.out.println("Cycle detected? " + result);
    }
}
