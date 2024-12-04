package graphs;

public class NumberEnclaves {
    class Solution {
        int m;
        int n;
        int[][] grid;
        public int numEnclaves(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            this.grid = grid;
    
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(i == 0 || j == 0 || i == m - 1 || j == n - 1){
                        if(grid[i][j] == 1){
                            mark(i, j);
                        }
                    }
                }
            }
            int count = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1) count++;
                }
            }
    
            return count;
        }
    
        public void mark(int row, int col){
            if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != 1){
                return;
            }
    
            grid[row][col] = -1;
            mark(row - 1, col);
            mark(row, col - 1);
            mark(row + 1, col);
            mark(row, col + 1);
        }
    }
}
