package graphs;
import java.util.*;

public class CountUnreachablePairsInUndirectedGraph {


class Graph {
    int v;
    ArrayList<Integer>[] adj;

    Graph(int v) {
        this.v = v;
        adj = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int src, int nbr) {
        adj[src].add(nbr);
        adj[nbr].add(src);
    }

    int dfs(int src, boolean[] visited) {
        if (visited[src]) {
            return 0;
        }

        visited[src] = true;
        int size = 1; // Start with 1, as 'src' itself is part of the component

        for (int nbr : adj[src]) {
            if (!visited[nbr]) {
                size += dfs(nbr, visited);
            }
        }

        return size;
    }
}

class Solution {
    public long countPairs(int n, int[][] edges) {
        Graph g = new Graph(n);

        // Add edges to the graph
        for (int[] edge : edges) {
            g.addEdge(edge[0], edge[1]);
        }

        boolean[] visited = new boolean[n];
        List<Integer> componentSizes = new ArrayList<>();

        // Find the sizes of all connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int componentSize = g.dfs(i, visited);
                componentSizes.add(componentSize);
            }
        }

        // Compute total possible pairs
        long totalPairs = (long) n * (n - 1) / 2;

        // Subtract pairs within each component
        for (int size : componentSizes) {
            totalPairs -= (long) size * (size - 1) / 2;
        }

        return totalPairs;
    }
}

}
