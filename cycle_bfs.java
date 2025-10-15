class Solution {
  public boolean isCycle(int V, List<Integer>[] adj) {
    boolean[] visited = new boolean[V];
    Arrays.fill(visited, false);
    for (int i = 0; i < V; i++) {
      if (visited[i] == false) {
        if (bfs(adj, visited, i, V) == true)
          return true;

      }
    }
    return false;

  }

  public boolean bfs(List<Integer>[] adj, boolean[] visited, int start, int V) {
    visited[start] = true;
    Queue<Pair> q = new LinkedList<>();
    q.offer(new Pair(start, -1));
    while (!q.isEmpty()) {
      Pair popped = q.poll();

      for (int adjNode : adj[popped.node]) {
        if (visited[adjNode] == false) {
          visited[adjNode] = true;
          q.add(new Pair(adjNode, popped.node));
        } else if (popped.prev != adjNode)
          return true;
      }
    }
    return false;
  }
}

class Pair {
  int node;
  int prev;

  Pair(int n, int p) {
    this.node = n;
    this.prev = p;
  }
}