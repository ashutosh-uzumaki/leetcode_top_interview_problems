package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BFS {
    class Solution {
    // Function to return Breadth First Traversal of given graph.
    ArrayList<ArrayList<Integer>> adj;
    ArrayList<Integer> res;
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        this.adj = adj;
        res = new ArrayList<>();
        boolean[] visited = new boolean[V];
        bfsHelper(0, visited);
        return res;
    }
    
    public void bfsHelper(int V, boolean[] visited){
        Queue<Integer> node = new ArrayDeque<>();
        node.add(V);
        visited[V] = true;
        res.add(V);
        while(!node.isEmpty()){
            int currV = node.poll();
            for(int nbr: adj.get(currV)){
                if(!visited[nbr]){
                    res.add(nbr);
                    node.add(nbr);
                    visited[nbr] = true;
                }
            }
        }
    }
    
}
}
