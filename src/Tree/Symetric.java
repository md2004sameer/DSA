package Tree;

public class Symetric {
    static boolean helper(TreeNode p , TreeNode q){
        if(p  ==null && q == null) return true;
        if(p  ==null || q == null) return false;

        if(p.val != q.val) return false;

        return helper(p.left , q.right )&& 
               helper(p.right , p.left);
     }
    
}
