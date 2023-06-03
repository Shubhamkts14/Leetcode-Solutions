import java.util.*;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Create an adjacency list to represent the tree structure
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adjList.get(manager[i]).add(i);
            }
        }
        
        return dfs(adjList, informTime, headID);
    }
    
    private int dfs(List<List<Integer>> adjList, int[] informTime, int curEmployee) {
        int maxTime = 0;
        
        for (int subordinate : adjList.get(curEmployee)) {
            int time = dfs(adjList, informTime, subordinate);
            maxTime = Math.max(maxTime, time);
        }
        
        return maxTime + informTime[curEmployee];
    }
}
