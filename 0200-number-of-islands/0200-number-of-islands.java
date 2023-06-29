class Solution {
   private static int dirs[][] = { {0,1}, {1,0}, {-1,0}, {0,-1} };
   public void bfs(int ro, int co, int[][] vis, char[][] grid){
       vis[ro][co] = 1;
       Queue<Pair<Integer, Integer>> q= new LinkedList<Pair<Integer, Integer>>();
       q.add(new Pair(ro, co));
       int n = grid.length;
       int m = grid[0].length;

       while(!q.isEmpty()){
           int row = q.peek().getKey();
           int col = q.peek().getValue();
           q.remove();

           for( int[] dir : dirs){
               int nrow = row + dir[0];
               int ncol = col + dir[1];
               if(nrow >=0 && nrow < n && ncol >= 0 && ncol<m 
                   && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                           vis[nrow][ncol] =1;
                           q.add(new Pair(nrow, ncol));
                   }
           }
       }
   }
   public int numIslands(char[][] grid) {
       int n = grid.length;
       int m= grid[0].length;

       int[][] vis= new int[n][m];
       int cnt = 0;
       for(int row=0;row<n;row++){
           for(int col=0; col<m;col++){
               if(vis[row][col]==0 && grid[row][col] == '1'){
                   cnt++;
                   bfs(row, col, vis, grid);
               }
           }
       }
       return cnt;
   }
}