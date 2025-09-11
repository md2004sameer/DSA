package Tree;

public class diameter {
    class TreeNode{
        int val;
        TreeNode left ;
        TreeNode right ;
         public TreeNode(int val){
            this.val = val;
            left = right = null;
         }
    }
    static int ans =0;

    public static int helper(TreeNode node){
        if(node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);
        int curr = left + right;
        ans=  Math.max(ans, curr);// update the max dia in global var
        return Math.max(left, right)+1; // return the curr height 
    }
    public static int dia(TreeNode node){
        helper(node);
        return ans;  // return global that we updated for longer
    }
    
}
