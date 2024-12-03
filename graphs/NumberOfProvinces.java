package graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    class Graph{
    int V;
    List<Integer>[] adj;

    Graph(int V){
        this.V = V;
        adj = new ArrayList[V];
        for(int i=0; i<V; i++){
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    void dfs(int src, boolean[] visited){
        if(visited[src]){
            return;
        }
        visited[src] = true;
        for(int nbr: adj[src]){
            if(!visited[nbr]){
                dfs(nbr, visited);
            }
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        Graph g = new Graph(size);
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(isConnected[i][j] == 1){
                    g.addEdge(i, j);
                }
            }
        }

        boolean[] visited = new boolean[size];
        int count = 0;

        for(int i = 0; i<size; i++){
            if(!visited[i]){
                count++;
                g.dfs(i, visited);
            }
        }


        return count;
    }
}
}
