package LinkedList.easy;

public class Middle {
    //leetcode 876

    public static boolean middle(Node head){

        Node slow = head;
        Node fast = head;

        // using flyod cycle detection method 
        // where are two pointer one move a step ahead , other move twice of of prev.

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }


        return false;
    }
    
}
