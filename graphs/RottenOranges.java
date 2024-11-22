package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    class Triplet{
    int i;
    int j;
    int time;

    Triplet(int i, int j, int time){
        this.i = i;
        this.j = j;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Triplet> nodes = new ArrayDeque<>();
        int cntFresh = 0;
        int rotCnt = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 2){
                    nodes.add(new Triplet(i, j, 0));
                    visited[i][j] = 1;
                }
                if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }

        int maxTime = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!nodes.isEmpty()){
            Triplet curr = nodes.poll();
            int row = curr.i;
            int col = curr.j;
            int time = curr.time;
            maxTime = Math.max(time, maxTime);

            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    nodes.add(new Triplet(nrow, ncol, time + 1));
                    visited[nrow][ncol] = 1;
                    grid[nrow][ncol] = 2;
                    rotCnt++;
                }
            }
        }
        System.out.println(rotCnt+" "+cntFresh);
        if(rotCnt != cntFresh){
            return -1;
        }

        return maxTime;
    }
}
}
