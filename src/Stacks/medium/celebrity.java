package Stacks.medium;

import java.util.Stack;

public class celebrity {

    public int findCeleb(int[][] arr , int n) {

        Stack<Integer> stack = new Stack<>();

        // Push all people
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Eliminate non-celebrities
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (arr[a][b] == 1) {
                // a knows b → a not celeb
                stack.push(b);
            } else {
                // a doesn't know b → b not celeb
                stack.push(a);
            }
        }

        // Remaining candidate
        int candidate = stack.pop();

        // Verify candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (arr[candidate][i] == 1 || arr[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }
}
