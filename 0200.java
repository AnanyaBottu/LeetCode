class Solution {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int counter = 0;
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    counter++;
                    bfs(i, j, grid, visited);
                }
            }
        }
        return counter;
    }

    public void bfs(int row, int col, char[][] grid, int[][] visited) {
        visited[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(row, col));

        while (!q.isEmpty()) {
            Pair V = q.pop();
            int[] delRow = { -1, 0, 1, 0 };
            int[] delCol = { 0, 1, 0, -1 };
            for (int k = 0; k < 4; k++) {
                int newRow = V.row + delRow[k];
                int newCol = V.column + delCol[k];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visited[newRow][newCol] == 0
                        && grid[newRow][newCol] == '1') {
                    visited[newRow][newCol] = 1;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}

class Pair {
    int row;
    int column;

    Pair(int r, int c) {
        this.row = r;
        this.column = c;
    }
}
