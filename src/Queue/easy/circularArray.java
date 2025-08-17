package Queue.easy;

/*
 *  Approach -> the thing is circular array is act as ring.
 */

public class circularArray {
    int []arr;
    int front ,rear , size , cap;
    public circularArray(int cap){
        this.cap = cap;
        arr = new int[cap];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull(){
        return cap == size;
    }


    public void enqueue(int val ){
        if(isFull()) {
            System.out.println("Queue is Full.");
            return;
        }
        arr[rear] = val;
        rear = ( rear + 1 ) % cap;
        size++;
    }


    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return -1;
        }
        int val = arr[front];
        front = ( front + 1 ) % cap;
        size--;
        return val;
    }



    
}
