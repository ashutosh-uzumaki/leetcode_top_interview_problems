package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DetectCycleInUndirectedBFS {
    class Pair{
    int source;
    int parent;
    
    Pair(int source, int parent){
        this.source = source;
        this.parent = parent;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    boolean[] visited;
    ArrayList<ArrayList<Integer>> adj;
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V = adj.size();
        visited = new boolean[V];
        this.adj = adj;
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(hasCycle(i, -1)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean hasCycle(int source, int parent){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(source, parent));
        visited[source] = true;
        while(!q.isEmpty()){
            Pair root = q.poll();
            
            for(Integer nbr: adj.get(root.source)){
                if(!visited[nbr]){
                    visited[nbr] = true;
                    q.add(new Pair(nbr, root.source));
                }else if(nbr != root.parent){
                    return true;
                }
            }
        }
        
        return false;
    }
}
}
