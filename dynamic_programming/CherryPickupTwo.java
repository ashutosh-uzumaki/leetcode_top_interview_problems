package dynamic_programming;

public class CherryPickupTwo {
    class Solution {
        int rows;
        int cols;
        public int cherryPickup(int[][] grid) {
            rows = grid.length;
            cols = grid[0].length;
            return helper(0, 0, cols-1, grid);
        }
    
        public int helper(int row, int aliceCol, int bobCol, int[][] grid){
            if(aliceCol < 0 || aliceCol >= cols || bobCol < 0 || bobCol >= cols){
                return (int)(-1e8);
            }
    
            if(row == rows - 1){
                if(aliceCol == bobCol){
                    return grid[row][aliceCol];
                }
                return grid[row][aliceCol] + grid[row][bobCol];
            }
    
            int maximumScore = 0;
            for(int aliceJ = -1; aliceJ <= 1; aliceJ++){
                for(int bobJ = -1; bobJ <= 1; bobJ++){
                    int currScore = 0;
                    if(aliceCol == bobCol){
                        currScore = grid[row][aliceCol];
                    }else{
                        currScore = grid[row][aliceCol] + grid[row][bobCol];
                    }
                    currScore += helper(row + 1, aliceCol + aliceJ, bobCol + bobJ,  grid);
                    maximumScore = Math.max(currScore, maximumScore);
                }
            }
            return maximumScore;
        }
    }
}

    // ALICE AND BOB NEED TO MOVE SIMULTANEOUSLY. THEY START ON THE SAME ROW
