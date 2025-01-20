package graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleI {
    class Graph{
    int n;
    List<Integer>[] adj;

    Graph(int n){
        this.n = n;
        adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int src, int dest){
        adj[src].add(dest);
    }
}
class Solution {
    public boolean canFinish(int V, int[][] edges) { 
        Graph g = new Graph(V);

        for(int[] edge: edges){
            g.addEdge(edge[1], edge[0]);
        }
        int[] incoming = new int[V];
        for(int[] edge: edges){
            incoming[edge[0]]++;
        }

        int[] topo = new int[V];
        int push = 0, pop = 0;

        for(int i=0; i<V; i++){
            if(incoming[i] == 0){
                topo[push++] = i;
            }
        }

        while(pop < push && push < V){
            int src = topo[pop++];

            for(int nbr: g.adj[src]){
                incoming[nbr]--;
                if(incoming[nbr] == 0){
                    topo[push++] = nbr;
                }
            }
        }

        return push == V;
    }
}
}
