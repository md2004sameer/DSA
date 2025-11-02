package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class topView {
    
    static class Pair {
        int hd;
        TreeNode node;
        public Pair(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static ArrayList<Integer> helper(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (root == null) return arr;

        Map<Integer, Integer> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int hd = curr.hd;
            TreeNode node = curr.node;

            if (!mp.containsKey(hd)) {
                mp.put(hd, node.val); // store only first node at each hd
            }
            if (node.left != null) {
                q.add(new Pair(hd - 1, node.left));
            }
            if (node.right != null) {
                q.add(new Pair(hd + 1, node.right));
            }
        }

        // collect values in order
        for (int val : mp.values()) {
            arr.add(val);
        }
        return arr;
    }
}
