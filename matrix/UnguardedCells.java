package matrix;

public class UnguardedCells {
    class Solution {
        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            int[][] grid = new int[m][n];
    
            for(int i=0; i<guards.length; i++){
                int k = guards[i][0];
                int j = guards[i][1];
    
                grid[k][j] = 2;
            }
    
            for(int i=0; i<walls.length; i++){
                int k = walls[i][0];
                int j = walls[i][1];
    
                grid[k][j] = 3;
            }
    
            for(int i=0; i<guards.length; i++){
                int k = guards[i][0];
                int j = guards[i][1];
    
                markGuarded(k, j, grid);
            }
    
            int count = 0;
    
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(grid[i][j] == 0){
                        count++;
                    }
                }
            }
    
            return count;
        }
    
        public void markGuarded(int row, int col, int[][] grid){
            for(int j = col + 1; j < grid[0].length; j++){
                if(grid[row][j] == 2 || grid[row][j] == 3){
                    break;
                }
                grid[row][j] = 1;
            }
    
            for(int j = col - 1; j >= 0; j--){
                if(grid[row][j] == 2 || grid[row][j] == 3){
                    break;
                }
                grid[row][j] = 1;
            }
    
            for(int i = row - 1; i >= 0; i--){
                if(grid[i][col] == 2 || grid[i][col] == 3){
                    break;
                }
                grid[i][col] = 1;
            }
    
            for(int i=row + 1; i < grid.length; i++){
                if(grid[i][col] == 2 || grid[i][col] == 3){
                    break;
                }
                grid[i][col] = 1;
            }
        }
    } 
}
