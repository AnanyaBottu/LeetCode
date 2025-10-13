class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean[] check = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfs(i, graph, visited, pathVisited, check);
        }
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i]) temp.add(i);
        }
        return temp;   
    }
    public boolean dfs(int node, int[][]adj, boolean[] visited,boolean[] pathVisited, boolean[] check) {
        visited[node] = true;
        pathVisited[node] = true;
        check[node] = false;
        
        for (int it : adj[node]) {
            if (!visited[it]) {
                if (dfs(it, adj, visited, pathVisited, check)) {
                    return true;
                }
            }
            else if (pathVisited[it]) {
                return true;
            }
        }
        check[node] = true;
        pathVisited[node] = false;
        return false;
    }
}
