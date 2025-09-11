package Tree;

public class identical {
    // if the tree is tree is same it means it is identical
    /*
     * in order to be tree to be identical 
     * there is 3 condn to satisfy 
     * left of root node must be same to right
     * right of root node must be same to left 
     * curr val of p and q must be same
     */

    public static boolean helper( TreeNode p , TreeNode q){

        if(p == null && q == null) return true; // if both are null 
        if(p == null || q == null) return false; // if one of them are null

        boolean left = helper( p.left , q.left);
        boolean right = helper( p.right , p.right );

        return left && right && p.val == q.val; // if all condn satisfy , it return true

    }
    
}
