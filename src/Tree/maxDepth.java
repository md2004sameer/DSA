package Tree;

public class maxDepth {
    // depth meaning, its height
    static int  helper(TreeNode root){
        if(root == null ) return 0;
        
        int  left = helper(root.left);
        int  right = helper(root.right);

        return Math.max(left , right);
        

    }
    
}
