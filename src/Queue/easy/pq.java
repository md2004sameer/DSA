package Queue.easy;
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class pq {
    static class Element{
        int val;
        int priority;
        public Element(int val , int priority){
            this.val = val;
            this.priority = priority;
        }
    }
    
    static class priorityQueue{
        Element arr[];
        int size;
        int cap;
        public priorityQueue(int cap){
            arr = new Element[cap];
            this.cap = cap;
            this.size =0;
        }
        
        public void add(int val , int priority){
            if(size == cap){
                System.out.println("Queue is full");
                return;
            }
            arr[size++] = new Element(val , priority);
        }
        
        public Element get(){
            if(size == 0) return null;
            Element min = arr[0];
            for(int i = 0; i< size;i++){
                if(arr[i].priority < min.priority){
                    min = arr[i];
                }
            }
            return min;
        }
        
        void print(){
            for(int i = 0; i< size;i++){
                System.out.print("[ val : "+arr[i].val+",  priority : "+ arr[i].priority +" ]");
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        priorityQueue pq = new priorityQueue(10);
        pq.add(5,1);
        pq.add(6,2);
        pq.add(5,3);
        pq.add(9,9);
        pq.print();
        
        
    }
}