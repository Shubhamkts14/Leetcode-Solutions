class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // Initialize parent array for union-find algorithm
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // Sort edges by increasing weight
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));

        int numQueries = queries.length;
        int[][] queryIdx = new int[numQueries][2];
        for (int i = 0; i < numQueries; i++) {
            queryIdx[i] = new int[]{i, queries[i][2]};
        }
        Arrays.sort(queryIdx, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Initialize answer array
        boolean[] answer = new boolean[numQueries];
        
        // Perform union-find algorithm for each query
        int edgeIdx = 0;
        for (int[] q : queryIdx) {
            int i = q[0];
            int p = queries[i][0];
            int r = queries[i][1];
            int limit = queries[i][2];
            
            // Process edges until either p and q are in the same component or no more edges can be used
            while (edgeIdx < edgeList.length && edgeList[edgeIdx][2] < limit) {
                int u = edgeList[edgeIdx][0];
                int v = edgeList[edgeIdx][1];
                union(parent, u, v);
                edgeIdx++;
            }
            
            answer[i] = find(parent, p) == find(parent, r);
        }
        
        return answer;
    }
    
    // Find the parent of a node using the union-find algorithm
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    
    // Merge two components using the union-find algorithm
    private void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        parent[py] = px;
    }
}
