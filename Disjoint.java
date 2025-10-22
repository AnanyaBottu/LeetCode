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

  public void unionByRank(int u, int v) {
    int ultU = findParent(u);
    int ultV = findParent(v);
    if (ultU == ultV)
      return;
    if (rank[ultU] < rank[ultV])
      parent[ultV] = ultU;
    else if (rank[ultV] < rank[ultU])
      parent[ultU] = ultV;
    else {
      parent[ultV] = ultU;// v is getting attached to u ie U becomes parent of V
      int rankU = rank[ultU];
      rank[ultU] = rankU + 1;
    }
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

public class Disjoint {
  public static void main(String[] args) {
    // Disjoint Data structure
    DisjointSet ds = new DisjointSet(7);
    ds.unionByRank(1, 2);
    ds.unionByRank(2, 3);
    ds.unionByRank(4, 5);
    ds.unionByRank(6, 7);
    ds.unionByRank(5, 6);

    if (ds.find(3, 7))
      System.out.println("They belong to the same components.");
    else
      System.out.println("They do not belong to the same components.");

    ds.unionByRank(3, 7);

    if (ds.find(3, 7))
      System.out.println("They belong to the same components.");
    else
      System.out.println("They do not belong to the same components.");
  }
}
