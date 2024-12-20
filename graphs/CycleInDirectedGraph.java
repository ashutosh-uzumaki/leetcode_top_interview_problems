package graphs;

import java.util.ArrayList;

public class CycleInDirectedGraph {
    class Solution {
    // Function to detect cycle in a directed graph.
    int[] visited;
    ArrayList<ArrayList<Integer>> adj;
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        this.visited = new int[V];
        this.adj = adj;
        
        for(int i=0; i<V; i++){
            if(visited[i] == 0 && checkCycle(i) == true){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean checkCycle(int src){
        if(visited[src] == 1) return true;
        if(visited[src] == 2) return false;
        
        visited[src] = 1;
        for(int nbr: adj.get(src)){
            if(checkCycle(nbr) == true){
                return true;
            }
        }
        
        visited[src] = 2;
        return false;
    }
}
}
