package Tree;

public class kthSmallest {
    static int cnt = 0;
    static int ans;
    static void helper(TreeNode root , int k ){
        if(root == null) return ;
        helper(root.left , k);
        cnt ++;
        if(cnt == k){ 
            ans = root.val;
        }
        helper(root.right , k);
    }
    /*
     * traverse into the left most of treenode , as bst is left < root < right 
     * after rreacing the smallest point then move k step and return using if statement.
     */
}
