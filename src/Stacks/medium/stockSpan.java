package Stacks.medium;

import java.util.*;

public class stockSpan {

    public static Vector<Integer> helper(int arr[]) {

        Stack<Integer> stack = new Stack<>(); // will store indices
        Vector<Integer> nglIndex = new Vector<>(); // nearest greater left indices

        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nglIndex.add(-1); // no greater on left
            } else {
                nglIndex.add(stack.peek()); // index of nearest greater
            }

            stack.push(i);
        }

        // Now subtract index of NGL from current index to get span
        Vector<Integer> span = new Vector<>();
        for (int i = 0; i < arr.length; i++) {
            span.add(i - nglIndex.get(i));
        }

        return span;
    }

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        Vector<Integer> ans = helper(arr);

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
