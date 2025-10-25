package Recursion;
import java.util.Stack;
public class insertBottom {
    static void helper(Stack<Integer> st, int val){
        if(st.isEmpty() ){
            st.push(val);
            return;
        }
        int top = st.pop();
        helper(st , val);
        st.push(top);
    }
}
