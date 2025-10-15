public class bfsCode{
    public static void bfs(int str , List<List<Integer>> graph){
        int n = graph.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[str] = true;
        queue.add(str);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neigh : graph.get(node)){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    queue.add(neigh);
                }
            }
        }
    }
}