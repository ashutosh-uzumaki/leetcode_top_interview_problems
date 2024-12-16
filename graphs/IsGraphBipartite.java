package graphs;

public class IsGraphBipartite {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int v = graph.length;
            int[] colorCode = new int[v];
            
            for(int i=0; i<v; i++){
                if(colorCode[i] == 0){
                    if(dfs(i, colorCode, graph, 1) == false){
                        return false;
                    }
                }
            }
    
            return true;
        }
    
        private boolean dfs(int node, int[] colorCode, int[][] graph, int color){
            if(colorCode[node] != 0){
                return colorCode[node] == color;
            }
    
            colorCode[node] = color;
            for(int neighbor: graph[node]){
                if(dfs(neighbor, colorCode, graph, -color) == false){
                    return false;
                }
            }
    
            return true;
        }
    }
}
