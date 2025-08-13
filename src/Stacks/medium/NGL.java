package Stacks.medium;
import java.util.Stack;
import java.util.Vector;
public class NGL {

    // Approach: stack me daalo, jab tk chhota ya barabar mile tab tk nikalo
    public Vector<Integer> fun(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        Vector<Integer> vt = new Vector<>();

        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                vt.add(-1);
            } else {
                vt.add(stack.peek());
            }
            stack.push(arr[i]);
        }
        return vt;
    }
    public static void main(String[] args) {
        NGL obj = new NGL();
        int[] arr = {1, 3, 2, 4};
        Vector<Integer> ans = obj.fun(arr);

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
