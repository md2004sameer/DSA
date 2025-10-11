package Tree;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val ; 
    TreeNode left ;
    TreeNode right ;

    public TreeNode() {}
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class leftView {

    public static ArrayList<Integer> helper(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null ) return res;

        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i< size;i++){
                TreeNode curr = q.poll();
                if(i == 0 ) res.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null ) q.offer(curr.right);
            }
        }
        return res;
    }
    
}

