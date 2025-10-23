package Stacks.easy;
import java.util.Stack;
public class delMid {
    static void helper(Stack<Integer> st, int curr , int mid ){
        if(st.isEmpty() ) return ;

        int top = st.pop();

        if(curr == mid ){
            System.out.println(top +" is deleted.");
            return;
        }

        helper(st , curr +1 , mid);
        st.push(top);



    }
    static int count(Stack<Integer> st){
        if(st.isEmpty() ) return 0;
        int top = st.pop();
        int cnt = 1 + count(st);
        st.push(top);
        return cnt;
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
        int mid  = count(st);
        helper(st, 0, mid/2);
        System.out.println("Stack after  ");
        System.out.print(st);

    }

    
}
