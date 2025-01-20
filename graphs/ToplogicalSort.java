package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ToplogicalSort {
    class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int n = adj.size();
        int[] indegrees = new int[n];
        for(int i=0; i<n; i++){
            for(int node: adj.get(i)){
                indegrees[node]+=1;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> topoOrder = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            topoOrder.add(curr);
            
            for(int node: adj.get(curr)){
                indegrees[node]-=1;
                if(indegrees[node] == 0){
                    q.add(node);
                }
            }
        }
        
        return topoOrder;
    }
}
}
