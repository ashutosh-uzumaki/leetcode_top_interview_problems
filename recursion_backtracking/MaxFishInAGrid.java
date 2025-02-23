public class MaxFishInAGrid {
    class Solution {
        int rows;
        int cols;
        int[][] grid;
        public int findMaxFish(int[][] grid) {
            rows = grid.length;
            cols = grid[0].length;
            this.grid = grid;
            boolean[][] visited = new boolean[rows][cols];
            int maxFish = 0;
            for(int row=0; row<rows; row++){
                for(int col=0; col<cols; col++){
                    if(grid[row][col] != 0){
                        maxFish = Math.max(maxFish, helper(row, col, visited));
                    }
                }
            }
            return maxFish;
        }
    
        public int helper(int row, int col, boolean[][] visited){
            if(row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] == true){
                return 0;
            }
            if(grid[row][col] == 0){
                return 0;
            }
    
            visited[row][col] = true;
    
            int fish = grid[row][col];
            fish += helper(row, col-1, visited);
            fish += helper(row, col+1, visited);
            fish += helper(row-1, col, visited);
            fish += helper(row+1, col, visited);
    
            return fish;
        }
    }
}
