package Queue.easy;



public class circularLL {

    private static Node front = null;
    private static Node rear = null;

    public void enqueue(int val){
        Node newNode = new Node(val);

        if(front == null){
            front = newNode;
            rear = newNode;
            rear.next = front;  // circular link 
        }else{
            rear.next = newNode;
            rear = newNode;
            rear.next = front; // maintain circualr link
        }
    }


    public int dequeue(){
        if(front == null){
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = front.val;

        if(front == rear ){ // only one element
            front = null;
            rear = null;
            
        }
        else{
            front = front.next;
            rear.next = front;  // maintain circualr link

        }
        return val;
    }
    
}
