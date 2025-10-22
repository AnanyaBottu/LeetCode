import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
  public int spanningTree(int V, List<List<List<Integer>>> adj) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]));
    int visited[] = new int[V];
    int sum = 0;
    ArrayList<int[]> MST = new ArrayList<>();

    pq.add(new int[] { 0, 0, -1 });
    while (!pq.isEmpty()) {
      int[] top = pq.poll();
      int weight = top[0];
      int node = top[1];
      int parent = top[2];

      if (parent != -1)
        MST.add(new int[] { node, parent });

      if (visited[node] == 0) {
        visited[node] = 1;
        sum += weight;
        for (List<Integer> it : adj.get(node)) {
          int ver = it.get(0);
          int wt = it.get(1);
          pq.add(new int[] { wt, ver, node });
        }
      }

    }

    return sum;
  }
}

public class prims {
  public static void main(String[] args) {
    int V = 4;
    List<List<Integer>> edges = Arrays.asList(
        Arrays.asList(0, 1, 1),
        Arrays.asList(1, 2, 2),
        Arrays.asList(2, 3, 3),
        Arrays.asList(0, 3, 4));
    List<List<List<Integer>>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
    for (List<Integer> it : edges) {
      int u = it.get(0);
      int v = it.get(1);
      int wt = it.get(2);

      adj.get(u).add(Arrays.asList(v, wt));
      adj.get(v).add(Arrays.asList(u, wt));
    }

    Solution sol = new Solution();
    int ans = sol.spanningTree(V, adj);

    System.out.println("The sum of weights of edges in MST is: " + ans);
  }
}
