import java.util.*;

class Solution {
  public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        Comparator.comparingInt((int[] a) -> a[0])
            .thenComparingInt(a -> a[1]));

    int[] dist = new int[V];
    Arrays.fill(dist, (int) 1e9);

    dist[S] = 0;
    pq.add(new int[] { 0, S });

    while (!pq.isEmpty()) {
      int[] top = pq.poll();
      int distance = top[0];
      int node = top[1];

      for (ArrayList<Integer> it : adj.get(node)) {
        int adjNode = it.get(0);
        int edgeWeight = it.get(1);

        if (distance + edgeWeight < dist[adjNode]) {
          dist[adjNode] = distance + edgeWeight;
          pq.add(new int[] { dist[adjNode], adjNode });
        }
      }
    }
    return dist;
  }
}

public class Dijkstra {
  public static void main(String[] args) {

    int V = 2, S = 0;
    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
    ArrayList<ArrayList<Integer>> node0 = new ArrayList<>();
    node0.add(new ArrayList<>(Arrays.asList(1, 9)));
    adj.add(node0);

    ArrayList<ArrayList<Integer>> node1 = new ArrayList<>();
    node1.add(new ArrayList<>(Arrays.asList(0, 9)));
    adj.add(node1);
    Solution sol = new Solution();
    int[] ans = sol.dijkstra(V, adj, S);
    System.out.print("The shortest distance of nodes from the source node is: ");
    for (int i = 0; i < V; i++) {
      System.out.print(ans[i] + " ");
    }
    System.out.println();
  }
}