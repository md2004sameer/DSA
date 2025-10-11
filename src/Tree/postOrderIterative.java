package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class postOrderIterative {

    public static ArrayList<Integer>  helper(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
     

        st1.push(root);

        while(!st1.isEmpty()){
            TreeNode pop = st1.pop();
            st2.push(pop);

            if(pop.left != null) st1.push(pop.left);
            if(pop.right != null ) st1.push(pop.right);
            
        }
        while(!st2.isEmpty()){
            res.add(st2.pop().val);
        }
        return res;
        
    }
    
}
