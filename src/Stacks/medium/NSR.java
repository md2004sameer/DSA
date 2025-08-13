package Stacks.medium;

import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class NSR {
    public static Vector<Integer> helper(int []arr){

        Stack<Integer> stack = new Stack<>();

        Vector<Integer> vt = new Vector<>();

        for(int i = arr.length - 1; i>= 0 ;i--){
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                vt.add(-1);

            }else{
                vt.add(stack.peek());
            }
            stack.push(arr[i]);
        }
        Collections.reverse(vt);

        return vt;
         

    }
    
}
