package Stacks.easy;

class Node{
    int data ;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class StackLinkedList {

    private static Node top ;

    public StackLinkedList(){
        top = null;
    }

    public static void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public static int pop(){
        int val = top.data;
        top = top.next;
        return val;
    }

    public static int peek(){
        if(top!= null) return top.data;
        return -1;
    }
    

    
}
