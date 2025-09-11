package Tree;

public class count {

    public static int helper(TreeNode node){
        if(node == null) return 0;
        int l = helper(node.left); // it traverse the left of root node and +1 as it move 
        int r = helper(node.right); // it traverse the right of root node 

        return l+r+1; // 1 represent the root
    }
    
}
