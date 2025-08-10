package LinkedList.easy;

public class delete {

    public Node delBegin(Node head ){
        if(head == null) return null;

        head = head.next;

        return head;
    }

    public static Node delEnd(Node head){
        if(head == null ||head.next == null ) return null; // empty or single node

        Node curr = head;
        while(curr.next.next != null){   // go to second last node 
            curr = curr.next;
        }
        curr.next = null;    // set next pointer to null
        return head;
    }

    public static Node delBefore(Node head , Node target){
        if(head == null || head == null || head.next == target) return head; // do nothing for edge cases

        Node curr = head;

        while(curr.next.next != target){
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return head;
    }
    
}
