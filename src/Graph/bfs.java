package Graph;

import java.util.*;

public class bfs {

    public static ArrayList<Integer> helper(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        int size = adj.size();
        boolean[] visited = new boolean[size];
        Queue<Integer> q = new LinkedList<>();

        visited[0] = true;
        q.offer(0);

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for (int neighbour : adj.get(curr)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }
        return res;
    }
}