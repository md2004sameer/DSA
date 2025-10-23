package LinkedList.easy;

public class delete extends add {

    public Node delBegin(Node head ){
        if(head == null) return null; // if head is null return null.

        Node del = head;
        System.out.println("deleted node : "+del.data);
        head = head.next; // else move a pointer to next , without storing it any where in this way we lost it.

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

        System.out.println(target.data+" : is deleted.");

        return head;
    }
    public static Node delAfter(Node head , Node target ){
        if(head == null || head.next == target) return head;

        Node curr = head;

        while (curr.next != target){ // place your pointer just before target element.
            curr = curr.next;
        }
        curr = curr.next.next; // and just move the pointer twice skipping the pointer.
        return head;
    }

    public static void main(String [] args){
        Node head = null;
        head = addAtBegin(head , 1);
        head = addAtBegin(head , 3);
        head = addAtBegin(head , 5);
        head = addAtBegin(head , 7);
        head = addAtBegin(head , 9);
        print(head);
        Node target = new Node(9);
        head = delBefore(head , target);
        print(head);

    }
    
}
