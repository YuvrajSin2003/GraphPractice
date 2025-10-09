import java.util.*;
class bfs{  
    private int vertices;
    private LinkedList<Integer>[] adjList;

    bfs(int v){
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    void edge(int src , int dest){
        adjList[src].add(dest);
        adjList[dest].add(src);
    }
    void bfs(int startVertices){
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertices] = true;
        queue.add(startVertices);
        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");
            for(int neighbour : adjList[current]){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        System.out.println();

    }
    public static void main(String[] args) {
        bfs graph = new bfs(5);
        graph.edge(0, 1);
        graph.edge(0, 4);
        graph.edge(1, 2);
        graph.edge(1, 3);
        graph.edge(1, 4);
        graph.edge(2, 3);
        graph.edge(3, 4);
        System.out.println("BFS starting from vertex 0:");
        graph.bfs(0);
    }
}
