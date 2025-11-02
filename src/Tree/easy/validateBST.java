package Tree;

public class validateBST {
    static boolean helper(TreeNode root ,long min , long max ){
        if(root == null) return true ;

        if(root.val <= min || root.val >= max){
            return false;
        }

        return helper(root.left , min , root.val) &&
               helper(root.right , root.val , max);


    }

    /*
     *  to validate the bst ( binary search tree )
     *  left < root < right 
     *  hyptothesis  - we ensure the that either the 
     *                 value of min is less than min
     *                 else greater than max in theses case return false.
     *                 do the recursion call again and again for other cases.
     */
}
