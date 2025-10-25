package Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class lowestCommonAncestor {
    
    
    static TreeNode findLCAWithNodes(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            return findLCAWithNodes(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return findLCAWithNodes(root.right, p, q);
        }

        return root;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create a sample BST:
        //       6
        //      / \
        //     2   8
        //    / \ / \
        //   0  4 7  9
        
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        
        
        
        // Test with nodes
        TreeNode p = root.left; // node with value 2
        TreeNode q = root.left.right; // node with value 4
        TreeNode lca2 = findLCAWithNodes(root, p, q);
        System.out.println("LCA of nodes 2 and 4: " + (lca2 != null ? lca2.val : "null"));
    }
}