class Solution {
     public int countNegatives(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            int left = 0;
            int right = columns - 1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (grid[i][mid] < 0) {
                    count += right - mid + 1;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        return count;
    }
}