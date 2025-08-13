package Stacks.easy;

public class StackArray {

    private int[] stack;
    private int top;
    private int capacity;

    public StackArray(int size){
        stack = new int[size];
        top = -1;
        capacity = size;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int val){
        if(top == capacity-1){
            System.out.println("stack is full.");
            return;
        }
        stack[++top] = val;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("stack is empty ! stack underflow");
            return -1;
        }
        return stack[top--];

    }

    public int peek(){
        if(isEmpty()){
            System.out.println("stack underflow.");
            return -1;
        }
        return stack[top];
    }
    

    


    
}
