package LinkedList.medium;
public class reverse2 {

    public static Node reverse(Node head, int left, int right) {
        if (head == null || left == right) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        // 1. Move `prev` to the node before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 2. Reverse from `left` to `right`
        Node curr = prev.next;
        Node next = null;
        Node tail = curr; // this will become the tail of the reversed section

        for (int i = 0; i < right - left + 1; i++) {
            next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }

        // 3. Connect the tail of reversed section to the remainder
        tail.next = curr;

        return dummy.next;
    }
}
