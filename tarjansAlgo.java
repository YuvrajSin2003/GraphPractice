// Targan 's algorithm for find the bridge in the graph

import java.util.*;
public class tarjansAlgo {
    private int time;
    private int[] disc , low;
    private boolean[] visited;
    private List<List<Integer>> bridges;

    public List<List<Integer>> bridegs(int n ,  List<List<Integer>> connections){

        // Adjacency List
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i< n ; i++){
            graph.add(new ArrayList<>());
        }
        for(List<Integer> e : connections){
            int u = e.get(0) , v = e.get(1); 
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        time = 0;
        disc = new int[n];
        low =new int[n];
        visited = new boolean[n];
        bridges = new ArrayList<>();

        for(int i = 0 ; i<n ; i++){
            if(!visited[i]){
                dfs(i , -1 , graph);
            }
        }
        return bridges;
    }
    private void dfs(int u , int parent ,  List<List<Integer>> graph){
        visited[u] = true;
        disc[u] = low[u] = time++;

        for(int v : graph.get(u)){
            if(v == parent) continue;
            if(!visited[v]){
                dfs(v ,u , graph);
                low[u] = Math.min(low[u] , low[v]);

                if(low[v]> disc[u]){
                    bridges.add(Arrays.asList(u , v));
                }
            }else{
            low[u] = Math.min(low[u] , disc[v]);
        }
        }
    }

    public static void main(String[] args) {
        int n = 5;

        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        connections.add(Arrays.asList(3, 4));

         tarjansAlgo obj = new tarjansAlgo();

        // ✅ CALL METHOD THROUGH OBJECT
        List<List<Integer>> result = obj.bridegs(n, connections);
       
        System.out.println("Bridges in the graph:");
        for (List<Integer> bridge : result) {
            System.out.println(bridge.get(0) + " - " + bridge.get(1));
        }
    }
}
