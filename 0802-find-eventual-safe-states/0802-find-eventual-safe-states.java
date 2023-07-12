class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, colors))
                result.add(i);
        }

        return result;
    }

    private boolean dfs(int node, int[][] graph, int[] colors) {
        if (colors[node] != 0) {
            
            return colors[node] == 1;
        }

        colors[node] = 2; 

        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, graph, colors))
                return false;
        }

        colors[node] = 1; 
        return true;
    }
}