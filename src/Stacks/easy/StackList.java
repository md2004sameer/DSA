package Stacks.easy;

import java.util.ArrayList;

public class StackList {
    private ArrayList<Integer> stack;

    public StackList() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
    }

    public int pop() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception("stack underflow");
        }
        return stack.remove(stack.size() - 1);
    }

    public int peek() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception("stack underflow");
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
