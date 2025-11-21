import java.util.*;

public class kahnTopoSort {

    public List<Integer> kahn(int numNode, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numNode; i++) {
            adj.add(new ArrayList<>());
        }

        int[] in = new int[numNode];

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            in[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numNode; i++) {
            if (in[i] == 0) q.offer(i);
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            topo.add(curr);

            for (int nei : adj.get(curr)) {
                in[nei]--;
                if (in[nei] == 0)
                    q.offer(nei);
            }
        }

        if (topo.size() != numNode)
            throw new RuntimeException("Cycle detected");

        return topo;
    }

    public static void main(String[] args) {
        kahnTopoSort k = new kahnTopoSort();
        int[][] edges = {{0,1},{1,2},{0,2}};
        System.out.println(k.kahn(3, edges));
    }
}
