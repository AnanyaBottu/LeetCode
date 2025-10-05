class Solution {
    private boolean dfs(int i, List<Integer> adj[], boolean[] visited, int prev) {
        visited[i] = true;

        for (int node : adj[i]) {
            if (!visited[node]) {
                if (dfs(node, adj, visited, i)) {
                    return true;
                }
            } else if (node != prev) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, List<Integer> adj[]) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

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