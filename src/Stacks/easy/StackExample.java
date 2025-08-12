package Stacks.easy;
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st.pop());  // 30
        System.out.println(st.peek()); // 20
        System.out.println(st.size()); // 2
    }
}
