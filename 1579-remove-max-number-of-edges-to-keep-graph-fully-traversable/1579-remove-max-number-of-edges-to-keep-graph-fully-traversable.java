class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int result = 0;

        // Add edges that can be traversed by both Alice and Bob first
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!alice.union(edge[1]-1, edge[2]-1) || !bob.union(edge[1]-1, edge[2]-1)) {
                    // If the edge is not needed, increment result
                    result++;
                }
            }
        }

        // Add edges that can be traversed by Alice only
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!alice.union(edge[1]-1, edge[2]-1)) {
                    // If the edge is not needed, increment result
                    result++;
                }
            }
        }

        // Add edges that can be traversed by Bob only
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (!bob.union(edge[1]-1, edge[2]-1)) {
                    // If the edge is not needed, increment result
                    result++;
                }
            }
        }

        // Check if Alice and Bob can fully traverse the graph
        if (alice.getCount() != 1 || bob.getCount() != 1) {
            return -1;
        }

        return result;
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        }
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        count--;
        return true;
    }

    public int getCount() {
        return count;
    
    }
}