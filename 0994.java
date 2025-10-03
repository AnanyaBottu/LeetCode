class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int time = 0;
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int tmax = 0;
        while (!q.isEmpty()) {
            Pair node = q.poll();
            int[] delRow = { -1, 0, 1, 0 };
            int[] delCol = { 0, -1, 0, 1 };
            for (int i = 0; i < 4; i++) {
                int nRow = node.row + delRow[i];
                int nCol = node.column + delCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0
                        && grid[nRow][nCol] == 1) {
                    visited[nRow][nCol] = 2;
                    // grid[nRow][nCol]=2;
                    q.add(new Pair(nRow, nCol, node.time + 1));
                    tmax = Math.max(tmax, node.time + 1);

                }
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    return -1;
                }
            }
        }
        return tmax;
    }
}

class Pair {
    int row;
    int column;
    int time;

    Pair(int r, int c, int t) {
        this.row = r;
        this.column = c;
        this.time = t;
    }
}
