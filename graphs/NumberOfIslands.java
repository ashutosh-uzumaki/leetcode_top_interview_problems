package graphs;

public class NumberOfIslands {
    class Solution {
        int m;
        int n;
        char[][] grid;
        boolean[][] visited;
        public int numIslands(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            this.grid = grid;
            visited = new boolean[m][n];
    
            int numberOfIslands = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j] && grid[i][j] != '0'){
                        helper(i, j);
                        numberOfIslands++;
                    }
                }
            }
            return numberOfIslands;
        }
    
        public void helper(int row, int col){
            if(row < 0 || col < 0 || row >= m || col >= n || this.grid[row][col] == '0' || visited[row][col] == true){
                return;
            }
    
            visited[row][col] = true;
            helper(row, col+1);
            helper(row, col-1);
            helper(row+1, col);
            helper(row-1, col);
        }
    }
}
