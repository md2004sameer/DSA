package LinkedList.easy;

public class removeDuplicate {

    // leetcode 83
    // remove duplicate from sorted list.

    public static Node remove(Node head){

        Node curr = head;
        while(curr != null && curr.next != null){
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }

        }



        return head;
    }
    
}
