package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class ZeroOneMatrix {
    class Triplet{
    int i;
    int j;
    int dist;

    Triplet(int i, int j, int dist){
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] distances = new int[m][n];

        Queue<Triplet> q = new ArrayDeque<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    visited[i][j] = true;
                    q.add(new Triplet(i, j, 0));
                }
            }
        }
        int[] dirR = {-1, 0, 1, 0};
        int[] dirC = {0, -1, 0, 1};
        while(!q.isEmpty()) {
            Triplet x = q.poll();
            int row = x.i;
            int col = x.j;
            int distance = x.dist;
            for(int i=0; i<4; i++){
                int nrow = row + dirR[i];
                int ncol = col + dirC[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == false){
                    distances[nrow][ncol] = distance+1;
                    visited[nrow][ncol] = true;
                    q.add(new Triplet(nrow, ncol, distance + 1));
                }
            }
        }

        return distances;
    }
}
}
