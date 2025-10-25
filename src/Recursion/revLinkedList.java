package Recursion;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
        this.next = null;
    }
}
public class revLinkedList {
    static void helper(Node head){
        if(head == null) return;
        helper(head.next);
        System.out.print(head.val+" ");

    }
     public static void main(String[] args){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;

        helper(a);
    }
}
