package algorithms.base.leetcode;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {

        int length = edges.length;
        int[] parent = new int[length + 1];
        int[] rank = new int[length + 1];
        for (int i = 1; i < length + 1; i++) {
            parent[i] = i;
            rank[i] = i;
        }


        int[] result = new int[2];
        for (int[] edge : edges) {
            int p = find(edge[0], parent);
            int q = find(edge[1], parent);
            if (p == q) {
                result = edge;
            } else {
                union(p, q, parent, rank);
            }
        }
        return result;
    }

    public int find(int n, int[] parent) {
        if (n != parent[n]) {
            return find(parent[n], parent);
        }
        return n;
    }

    public void union(int rootP, int rootQ, int[] parent, int[] rank) {
        if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else {
            parent[rootP] = rootQ;
            rank[rootP]++;
        }
    }
}
