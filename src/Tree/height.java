package Tree;

public class height {
    class TreeNode{
        int val;
        TreeNode left ;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            left = right = null;
        }
    }

    public static int helper(TreeNode node){
        if(node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        return Math.max(left , right )+1;
    }
}
