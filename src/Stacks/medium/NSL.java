package Stacks.medium;
import java.util.Stack;
import java.util.Vector;

public class NSL {

    public Vector<Integer> helper(int[]arr){

        Stack<Integer> stack = new Stack<>();
        Vector<Integer> vt = new Vector<>();
       

        for(int i = 0;i< arr.length ;i++){

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

        
        return vt;
    }
    
}
