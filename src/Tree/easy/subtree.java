package Tree;

public class subtree {
    /*
     * using the identical logic , once if the val of p and q are same 
     * then we check that now onwards wheather the subtree is identical
     * if it is then it is subtree 
     * else not
     */

    class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
            left = right = null;
        }
    }

    // check whether two trees are identical
    public static boolean helper(TreeNode p , TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        boolean left = helper(p.left , q.left);
        boolean right = helper(p.right , q.right);

        return left && right && p.val == q.val;
    }

    // check whether q is a subtree of p
    public static boolean subTree(TreeNode p , TreeNode q){
        if(q == null) return true;   // empty tree is always a subtree
        if(p == null) return false;  // big tree is empty but q is not

        if(helper(p, q)) return true; // if identical starting from this node
        return subTree(p.left, q) || subTree(p.right, q); // search in children
    }
}
