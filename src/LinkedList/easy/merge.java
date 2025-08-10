package LinkedList.easy;

public class merge {

    // leetcode - 21

    public static Node mergeSorted(Node l1 , Node l2){

        Node dummy = new Node(0);

        Node l3 = dummy;

        while(l1 != null && l2 != null){

            if(l1.data < l2.data){
                l3.next = l1;
                l1 = l1.next;
            }else{
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;

        }
        if(l1 != null) l3.next = l1;
        if(l2 != null) l3.next = l2;

        return dummy.next;
    }
    
}
