package Tree;

import java.util.*;



class Pair {
    int hd;
    TreeNode node;
    public Pair(int hd, TreeNode node) {
        this.hd = hd;
        this.node = node;
    }
}

public class bottomView {
    public static ArrayList<Integer> helper(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>(); // use TreeMap for sorted order

        q.offer(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int hd = curr.hd;

            // update each time for bottom view
            map.put(hd, node.val);

            if (node.left != null)
                q.offer(new Pair(hd - 1, node.left));
            if (node.right != null)
                q.offer(new Pair(hd + 1, node.right));
        }

        // collect bottom view nodes from left to right
        for (int val : map.values())
            res.add(val);

        return res;
    }
}