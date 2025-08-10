package LinkedList.easy;

public class remove {

    // leetcode - 203

    public static Node removeData(Node head ,int val){

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;

        while(curr != null){
            if(curr.data != val){
                prev = curr;
            }else{
                prev.next = curr.next; // delete the node 
            }
            curr = curr.next;
        }

        return dummy.next;
    }
    
}
