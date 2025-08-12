package Stacks.easy;
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeueStack {

    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();

        dq.push(10);
        dq.push(20);
        dq.push(30);

        System.out.println(dq.pop());  // 30
        System.out.println(dq.peek()); // 20
        System.out.println(dq.size()); // 2
    }
}
