import java.util.*;

public class bipartite {
    public static boolean isBipartite(List<List<Integer>> graph){
        int n = graph.size();
        int[] color = new int[n];
        for(int s = 0 ; s<n ; s++){
            if(color[s] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            color[s] = 1;
            while(!queue.isEmpty()){
                int node = queue.poll();
                for(int neigh : graph.get(node)){
                    if(color[neigh] == 0){
                        color[neigh] = -color[s];
                        queue.add(neigh);
                    }else if(color[neigh] == color[s]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i< 4 ; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).addAll(Arrays.asList(1, 3));
        graph.get(1).addAll(Arrays.asList(0, 2));
        graph.get(2).addAll(Arrays.asList(1, 3));
        graph.get(3).addAll(Arrays.asList(0, 2));

        System.out.println("Is the graph bipartite? " + isBipartite(graph));
    }
}
