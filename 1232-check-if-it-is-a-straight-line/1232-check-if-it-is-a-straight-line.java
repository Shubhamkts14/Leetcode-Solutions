class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true; // If there are 2 or fewer points, they always form a straight line.
        }
        
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            
            if ((y1 - y0) * (x - x0) != (x1 - x0) * (y - y0)) {
                return false; // Points are not on the same line.
            }
        }
        
        return true; // All points are on the same line.
    }
}