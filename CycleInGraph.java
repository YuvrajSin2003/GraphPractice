import java.util.*;

public class CycleInGraph {

    // **************  UNDIRECTED GRAPH CYCLE DETECTION  *****************
s
    boolean dfsUndirected(int node, int parent, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true; 

        for (int neigh : adj.get(node)) { 
            if (!vis[neigh]) {
                if (dfsUndirected(neigh, node, vis, adj))
                    return true;
            }
            else if (neigh != parent) {
                return true;
            }
        }
        return false;
    }

    boolean isCycleUndirected(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            // run DFS for every unvisited component
            if (!vis[i] && dfsUndirected(i, -1, vis, adj))
                return true;
        }

        // ✅ FIX #2: Added missing return false
        return false;
    }

    // **************  DIRECTED GRAPH CYCLE DETECTION  *******************

    boolean dfsDirected(int node, boolean[] vis, boolean[] path, List<List<Integer>> adj) {
        vis[node] = true;
        path[node] = true; 

        for (int neigh : adj.get(node)) {
            
            if (!vis[neigh]) {
                if (dfsDirected(neigh, vis, path, adj))
                    return true;
            }
            else if (path[neigh]) {
                return true;
            }
        }

        path[node] = false;
        return false;
    }
    boolean isCycleDirected(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfsDirected(i, vis, path, adj))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        CycleInGraph graph = new CycleInGraph();

        int V1 = 5;
        List<List<Integer>> adjUndirected = new ArrayList<>();
        for (int i = 0; i < V1; i++) adjUndirected.add(new ArrayList<>());

        // Create undirected edges
        adjUndirected.get(0).add(1);
        adjUndirected.get(1).add(0);

        adjUndirected.get(1).add(2);
        adjUndirected.get(2).add(1);

        adjUndirected.get(2).add(3);
        adjUndirected.get(3).add(2);

        adjUndirected.get(3).add(4);
        adjUndirected.get(4).add(3);

        adjUndirected.get(4).add(0); // closes the cycle

        System.out.println("===== Undirected Graph Test =====");
        if (graph.isCycleUndirected(V1, adjUndirected))
            System.out.println("Graph contains a cycle.");
        else
            System.out.println("Graph does not contain a cycle.");


        // ----------------- DIRECTED GRAPH TEST -----------------
        int V2 = 4;
        List<List<Integer>> adjDirected = new ArrayList<>();
        for (int i = 0; i < V2; i++) adjDirected.add(new ArrayList<>());

        // Create directed edges
        adjDirected.get(0).add(1);
        adjDirected.get(1).add(2);
        adjDirected.get(2).add(0); // creates a directed cycle 0→1→2→0
        adjDirected.get(2).add(3);

        System.out.println("\n===== Directed Graph Test =====");
        if (graph.isCycleDirected(V2, adjDirected))
            System.out.println("Directed graph contains a cycle.");
        else
            System.out.println("Directed graph does not contain a cycle.");
    }
}
