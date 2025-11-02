package Tree;

public class kthLevel {

    public static void helper(TreeNode root , int k){
        if(root == null) return;

        if(k == 1 ){
            System.out.println(root.val);
            return;
        }
       helper(root.left , k-1);
       helper(root.right , k-1);

    }
    
}
