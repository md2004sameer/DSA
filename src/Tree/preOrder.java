package Tree;

public class preOrder {
    /*
     * the approach of pre order is root -> left -> right
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
        System.out.print(node.val+" ");
        helper(node.left);
        helper(node.right);
    }
    
}
