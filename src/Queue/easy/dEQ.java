package Queue.easy;

public class dEQ {
    int arr[];
    int front , rear , size ;
    int cap;

    public dEQ(int cap){
        this.cap= cap;
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        arr = new int[cap];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == cap;
    }


    public void addFront(int val){

        if(isFull()){
            System.out.println("Queue is Full.");
            return;
        }
        
        front = (front - 1 + cap) % cap; // Move front backward by 1 in a circular manner. 
                                        // '+ cap' ensures no negative index before modulo.
                                       // increase the idx first, to avoid overwrite that curr value.
        arr[front] = val;
        size++;
        
    }

    public void addRear(int val){
        if(isFull()){
            System.out.println("Queue is Full.");
            return;
        }
        arr[rear] = val;
        rear = (rear + 1 ) % cap;
        size++;

    }

    public int popFront(){
        if(isEmpty()){
            System.out.println("Queue is Empty.");
            return -1;
        }
        int val = arr[front];
        front =( front + 1)  % cap; // move forward
        size--;
        return val;

    }

    public int popRear() {
    if(isEmpty()) {
        System.out.println("Queue is Empty.");
        return -1;
    }
    rear = (rear - 1 + cap) % cap; // move rear backward to the last element
    int val = arr[rear];           // now rear points to the last element
    size--;
    return val;
}

    
}
