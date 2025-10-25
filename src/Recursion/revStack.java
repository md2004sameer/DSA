package Recursion;
import java.util.*;
public class revStack {
    static void helper(Stack<Integer> st ){
        if(st.isEmpty()) return;

        int top = st.pop();
        helper(st);
        insertAtBottom(st, top);

    }
    static void insertAtBottom(Stack<Integer> st , int val){
        if(st.isEmpty()){
            st.push(val);
            return;
        }
        int top = st.pop();
        insertAtBottom(st , val);
        st.push(top);

    }
     public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        helper(st);
        System.out.println(st); // [1, 2, 3, 4] reversed -> [4, 3, 2, 1]
    }
}
