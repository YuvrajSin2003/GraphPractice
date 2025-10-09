import java.util.ArrayList;

class DFSGraph {

    private int vertices; // number of vertices
    private ArrayList<Integer>[] adjList; // adjacency list

    // Constructor to initialize the graph
    DFSGraph(int v) {
        vertices = v;
        adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // Function to add edges (Undirected graph)
    void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    // DFS utility function (recursive)
    void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        // Visit all unvisited neighbors
        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // DFS traversal from a given node
    void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        System.out.println("DFS starting from vertex " + startVertex + ":");
        dfsUtil(startVertex, visited);
        System.out.println();
    }

    // Main method to test the DFS
    public static void main(String[] args) {
        DFSGraph graph = new DFSGraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.dfs(0);
    }
}
