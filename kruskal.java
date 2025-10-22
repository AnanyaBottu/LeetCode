import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class DisjointSet {
  int[] rank;
  int[] parent;
  int[] size;

  public DisjointSet(int n) {
    this.rank = new int[n + 1];
    this.parent = new int[n + 1];
    this.size = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      rank[i] = 0;
      parent[i] = i;
      size[i] = 1;
    }

  }

  public int findParent(int node) {
    if (parent[node] == node)
      return parent[node];
    else {
      int ultimateParent = findParent(parent[node]);
      parent[node] = ultimateParent;
    }
    return parent[node];
  }

  public boolean find(int u, int v) {
    if (findParent(u) == findParent(v))
      return true;
    return false;
  }

  public void unionBySize(int u, int v) {
    int ultU = findParent(u);
    int ultV = findParent(v);
    if (ultU == ultV)
      return;
    if (size[ultU] < size[ultV])
      parent[ultV] = ultU;
    else if (size[ultV] < size[ultU])
      parent[ultU] = ultV;
    else {
      parent[ultV] = ultU;// v is getting attached to u ie U becomes parent of V
      int sizeU = size[ultU];
      size[ultU] = sizeU + size[ultV];
    }

  }
}

class Solution {
  public int spanningTree(int V, List<List<List<Integer>>> adj) {
    List<int[]> edges = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      for (List<Integer> it : adj.get(i)) {
        int v = it.get(0);
        int wt = it.get(1);
        int u = i;
        edges.add(new int[] { wt, u, v });
      }
    }
    DisjointSet ds = new DisjointSet(V);
    edges.sort(Comparator.comparingInt(o -> o[0]));

    int sum = 0;

    for (int[] it : edges) {
      int wt = it[0];
      int u = it[1];
      int v = it[2];

      if (ds.findParent(u) != ds.findParent(v)) {
        sum += wt;
        ds.unionBySize(u, v);
      }
    }

    return sum;
  }
}

public class kruskal {
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