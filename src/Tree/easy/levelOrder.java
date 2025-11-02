package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class levelOrder {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            left = right = null;
        }
    }
    public static ArrayList<Integer> helper(TreeNode node){
        ArrayList<Integer> arr = new ArrayList<>();
        if(node == null){
            return arr;
        }
        Queue<TreeNode> q = new LinkedList<>();
        

        q.add(node);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            arr.add(curr.val);

            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }

        }
        return arr;
    }
}
