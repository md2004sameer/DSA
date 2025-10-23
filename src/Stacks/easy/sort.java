package Stacks.easy;

import java.util.Stack;
public class sort {
    static void helper(Stack<Integer> st ){
        if(st.isEmpty() ){
            return;
        }
        int top = st.pop();
        helper(st);
        insert(st, top);
    }
    static void insert(Stack<Integer> st , int val){
        if(st.isEmpty() || st.peek() < val){
            st.push(val);
            return;
        }
        int top = st.pop();
        insert(st , val);
        st.push(top);

    }


    public static void main(String [] args){
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(3);
        st.push(7);
        st.push(9);
        st.push(1);
        System.out.println("Stack before  ");
        System.out.println(st);
        helper(st);
        System.out.println("Stack after  ");
        System.out.print(st);

    }
    
}
