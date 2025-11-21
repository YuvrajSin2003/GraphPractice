import java.util.*;

public class TopologicalSorting {

    void dfsTopo(int node, boolean[] vis, Stack<Integer> stack, List<List<Integer>> adj) {
        vis[node] = true;
        for (int neigh : adj.get(node)) {
            if (!vis[node]) {
                dfsTopo(node, vis, stack, adj);
            }
        }
        stack.push(node);
    }

    List<Integer> topoSortDFS(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsTopo(i, vis, stack, adj);
            }
        }
        List<Integer> list = new ArrayList<>();

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        TopologicalSorting graph = new TopologicalSorting();
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> topoDFS = graph.topoSortDFS(V, adj);
        System.out.println("Topological Order: " + topoDFS);
    }
}