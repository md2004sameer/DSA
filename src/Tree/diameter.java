package Tree;

public class diameter {
    static class TreeNode{
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
    public static void main(String [] args){
        TreeNode root = new TreeNode(10) ;
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(3);
        root.left.left.left.left = new TreeNode(2);
        root.left.left.left.left.left = new TreeNode(1);
        root.right = new TreeNode(16);
        root.right.right = new TreeNode(17);
          
        
       
       int log =  dia(root);
       System.out.println("the diameter of a binary search tree is : "+log +":"+ans);
       
      // System.out.println("the diameter of a binary search tree is : "+helper(root));
    }
    
}
