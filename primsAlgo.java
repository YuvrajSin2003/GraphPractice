// Use to find MST 
// steps;
// 1.Start with any node
// 2.Pick the minimum
// 3.use priority queue

import java.util.*;

public class primsAlgo {
    static class Pair{
        int node;
        int weight;
        Pair(int node , int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int spanningTree(int V, int[][] edges){
        // Adjancey List
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i<V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int u = e[0] , v = e[1] , w=e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u , w));
        }
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.offer(new Pair(0,0));
        int mstWeight = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.weight;
            if(visited[node]) continue;
            visited[node] = true;
            mstWeight += wt;
            for(Pair neigh : adj.get(node)){
                if(!visited[neigh.node]){
                    pq.offer(new Pair(neigh.node , neigh.weight));
                }
            }
        }
        return mstWeight;
    }
   public static void main(String[] args) {
        
        int V = 5;  
        int[][] edges = {
            {0, 1, 2},
            {0, 3, 6},
            {1, 2, 3},
            {1, 3, 8},
            {1, 4, 5},
            {2, 4, 7},
            {3, 4, 9}
        };

        primsAlgo obj = new primsAlgo();
        int result = obj.spanningTree(V, edges);

        System.out.println("Weight of Minimum Spanning Tree: " + result);
    }
}
