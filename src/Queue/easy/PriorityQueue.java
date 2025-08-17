package Queue.easy;


class Element{
    int val;
    int priority;

    public Element(int val , int priority){
        this.val= val;
        this.priority = priority;
    }
}

public class PriorityQueue {

    Element[] arr;
    int cap , size ;

    public PriorityQueue(int cap){
        arr= new Element[cap];
        this.cap = cap;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    public boolean isFull(){
        return size == cap;
    }

    public void enqueue(int val , int priority){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        arr[size]= new Element(val, priority);
        size++;
        
    }

    public Element dequeue(){ // pop element  with higest 
        if(isEmpty()){
            System.out.println("Queue is Empty.");
            return null;
        }
        int maxIdx = 0;
        for(int i = 0 ;i < size;i++){
            if(arr[i].priority > arr[maxIdx].priority){
                maxIdx = i;
            }
        }
        Element ans = arr[maxIdx];


        for(int i = maxIdx;i<size;i++ ){
            arr[i] = arr[i+1];
        }
        size--;
        return ans;

    }



    
}
