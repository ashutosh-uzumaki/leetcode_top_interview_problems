package graphs;

import java.util.ArrayList;

public class DFS {
    

class Solution {
     ArrayList<Integer> dfs = new ArrayList<>();
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        helper(0, adj, visited);
        return dfs;
    }
    
    public void helper(int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        if(visited[V] == true){
            return;
        }
        
        visited[V] = true;
        dfs.add(V);
        for(int nbr: adj.get(V)){
            if(!visited[nbr]){
                helper(nbr, adj, visited);
            }
        }
    }
}
}
