package Queue.easy;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class LLQueue {
    private Node head = null;
    private Node rear = null;

    // Insert element at rear
    public void enqueue(int val) {
        Node newNode = new Node(val);
        if (head == null && rear == null) { // Queue empty
            head = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Remove element from front
    public int dequeue() {
        if (head == null) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = head.val;
        head = head.next;
        if (head == null) rear = null; // queue becomes empty
        return val;
    }

    // Peek element at front
    public int peek() {
        if (head == null) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return head.val;
    }

    // Print queue
    public void print() {
        Node curr = head;
        System.out.print("Queue: ");
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
