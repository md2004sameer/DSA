package Queue.easy;

class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class dEQLL {

    Node front = null;
    Node rear = null;

    // Check if deque is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Add element at front
    public void addFront(int val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    // Add element at rear
    public void addRear(int val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
    }

    // Remove element from front
    public int popFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        int val = front.val;
        if (front == rear) {  // only one element
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        return val;
    }

    // Remove element from rear
    public int popRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        int val = rear.val;
        if (front == rear) {  // only one element
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        return val;
    }
}
