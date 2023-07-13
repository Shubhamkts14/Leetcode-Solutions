class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(course).add(prerequisiteCourse);
        }

        boolean[] visited = new boolean[numCourses];

        boolean[] recursionStack = new boolean[numCourses];
        

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, visited, recursionStack)) {
                return false;
            }
        }
        
        return true; 
    }
    
    private boolean hasCycle(int course, List<List<Integer>> graph, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[course]) {
            return true; 
        }
        
        if (visited[course]) {
            return false; 
        }
        
        visited[course] = true;
        recursionStack[course] = true;
        
        for (int prerequisite : graph.get(course)) {
            if (hasCycle(prerequisite, graph, visited, recursionStack)) {
                return true;
            }
        }
        
        recursionStack[course] = false;
        
        return false; 
    
    }
}