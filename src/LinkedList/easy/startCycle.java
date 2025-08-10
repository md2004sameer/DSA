package LinkedList.easy;

class startCycle{

    // leetcode 141
    public Node detectCycle(Node head) {
        if (head == null) return null;

        Node slow = head, fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Find start of cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // start node of cycle
            }
        }
        return null; // no cycle
    }

}