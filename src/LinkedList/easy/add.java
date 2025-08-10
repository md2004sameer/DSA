package LinkedList.easy;

public class add {

    public static Node addAtBegin(Node head, int data) {
        Node newNode = new Node(data);
        if(head == null){
             return newNode;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static Node addAtEnd(Node head , int data){
        Node newNode = new Node(data);

        if(head == null) return newNode;

        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    public static Node addBefore(Node head , Node target,  int data){
        Node newNode  = new Node(data);
        if(head == null) return null; // if list is empty, return null

        // if head is target itself , insert before it
        if(head == target) {
            newNode.next = head;
            return newNode;
        }

        Node curr = head;

        while(curr != null && curr.next != target ){ // it stop just before the target node and perform 
            curr = curr.next;
        }
        if(curr == null) return head; // target not found

        // insert before target.
        curr.next = newNode;  // we just break it in b/w 
        newNode.next = target; // newNode next element is connect with target node 
    
        return head;
    }

    public static  Node addAfter(Node head ,Node target , int data){
        if(head == null || target == null  ) return head;

        Node newNode = new Node(data);

        newNode.next = target.next; // preverse the next pointer address
        target.next = newNode;  // now insert it 


        
        return head;

    } 

    public static void  print(Node head){
        Node curr = head;

        while(curr != null){
            System.out.print(curr.data+" -> ");
            curr = curr.next;
        }
        System.out.print("null");
    }
    public static void main(String args[]){

        Node head = null;
        head = addAtBegin(head , 1);
        head = addAtEnd(head , 2);
        head = addAtEnd(head , 3);
        head = addAtEnd(head , 4);
        head = addAtEnd(head , 5);
        print(head);
    }

    
}
            