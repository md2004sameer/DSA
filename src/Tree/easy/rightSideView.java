package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class rightSideView {

    public static ArrayList<Integer> helper(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null ) return res;

        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i< size;i++){
                TreeNode curr = q.poll();
                if(i == size -1 ) res.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null ) q.offer(curr.right);
            }
        }
        return res;
    }
    
}
