package graphs;

import java.util.ArrayList;

public class DetectCycleInUndirectedDFS {
    class Solution {
    boolean[] visited;
    ArrayList<ArrayList<Integer>> adj;
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        this.adj = adj;
        int V = this.adj.size();
        visited = new boolean[V];
        for(int i = 0; i<V; i++){
            if(!visited[i]){
                if(detectCycle(i, -1)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean detectCycle(int src, int par){
        visited[src] = true;
        
        for(int nbr: adj.get(src)){
            if(nbr == par){
                continue;
            }
            
            if(visited[nbr]){
                return true;
            }
            
            if(detectCycle(nbr, src)){
                return true;
            }
        }
        
        return false;
    }
}
}
