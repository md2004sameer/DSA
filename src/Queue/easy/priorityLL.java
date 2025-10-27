package Queue.easy;

class PriorityNode {
    int val;
    int priority;
    PriorityNode next;

    public PriorityNode(int val, int priority) {
        this.val = val;
        this.priority = priority;
        this.next = null;
    }
}

public class priorityLL {

    PriorityNode front = null;  // points to highest priority element
    PriorityNode rear = null;   // optional, can be used if needed

    // Insert element in proper position based on priority
    public void enqueue(int val, int priority) {
        PriorityNode newNode = new PriorityNode(val, priority);

        if (front == null || priority > front.priority) {
            // insert at front if list empty or new node has higher priority
            newNode.next = front;
            front = newNode;
        } else {
            PriorityNode current = front;
            while (current.next != null && current.next.priority >= priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Remove element with highest priority
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = front.val;
        front = front.next;
        return val;
    }

    // Peek at highest priority element
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.val;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
