package Queue.easy;

class ArrayQueue {
    int [] queue;
    int front ;
    int rear;
    int size;
    public ArrayQueue(int cap){
        queue = new int [cap];
        front = 0;
        rear =0 ;
        size = cap;
         
    }

    public void enqueue(int val) throws Exception{
        if(rear == size -1){
            throw new Exception("Queue is full");
        }
        queue[rear++] = val;
    }

    public int dequeue() throws Exception{
        if(rear == front) throw new Exception("Queue is Empty");

        int val = queue[front++];
        return val;
    }

    public int peek() throws Exception{
        if(rear == size -1 ) throw new Exception("Queue is Empty");
        
        return queue[front];
    }

    public void print(){
        for(int i = front; i < rear;i++ ){
            System.out.print(queue[i]+" -> ");
        }
         System.out.print("null");
    }


    
}
class Main{
    public static void main(String args[]) throws Exception{
        ArrayQueue q = new ArrayQueue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
       // q.dequeue();
        q.print();
        System.out.println();

        q.enqueue(4);
        q.print();


        
    }
}
