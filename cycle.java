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

