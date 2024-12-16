package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
    class Solution {

    int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<List<String>> set = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (!visited[row][col] && grid[row][col] == 1) {
                    List<String> islands = new ArrayList<>();
                    dfs(row, col, islands, visited, grid, row, col);
                    set.add(islands);
                }
            }
        }
        
        return set.size();
    }
    
    void dfs(int row, int col, List<String> islands, boolean[][] visited, int[][] grid, int baseRow, int baseCol) {
        visited[row][col] = true;
        
        // Add the relative position
        islands.add((row - baseRow) + " " + (col - baseCol));
        
        // Direction vectors for movement
        int[] dirRow = {-1, 0, 1, 0};
        int[] dirCol = {0, -1, 0, 1};
        
        for (int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];
            
            // Boundary check and other conditions
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                && !visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                dfs(newRow, newCol, islands, visited, grid, baseRow, baseCol);
            }
        }
    }
}

}
