class Solution {
   int[] delRow = {-1, 0, 1, 0};
   int[] delCol = {0, -1, 0, 1};

    private void dfs(int row, int col, int[][] grid, boolean[][] visited,List<String> path, int baseRow, int baseCol) {
        
        int n = grid.length;
        int m = grid[0].length;

        path.add((row - baseRow) + "," + (col - baseCol));

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && !visited[nRow][nCol]) {
                visited[nRow][nCol] = true;
                dfs(nRow, nCol, grid, visited, path, baseRow, baseCol);
            }
        }
    }
    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        Set<List<String>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    List<String> path = new ArrayList<>();
                    dfs(i, j, grid, visited, path, i, j);
                    st.add(path);
                }
            }
        }

        return st.size();
    }
}