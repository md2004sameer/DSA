package LinkedList.easy;

public class Palindrome {

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle
        Node mid = getMid(head);

        // Step 2: Reverse the second half
        Node secondHalf = reverse(mid);

        // Step 3: Compare first and second half
        Node firstHalf = head;
        Node secondHalfCurr = secondHalf;

        while (secondHalfCurr != null) {
            if (firstHalf.data != secondHalfCurr.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalfCurr = secondHalfCurr.next;
        }
        return true;
    }

    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // middle node
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
