package Tree;

public class inOrder {
    /*
     * the approach of pre order is left - root - right
     */

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            left = right = null;
        }
        

    }

    public static void helper(TreeNode node){
        if(node == null) return;
        
        helper(node.left);
        System.out.print(node.val+" ");
        helper(node.right);
    }
    
}

    
