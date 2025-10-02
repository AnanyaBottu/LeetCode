
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        if (n == 0 || m == 0)
            return;

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && board[i][j] == 'O') {
                    q.add(new Pair(i, j));
                    board[i][j] = 'T';
                }
            }
        }

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            Pair V = q.remove();
            for (int i = 0; i < 4; i++) {
                int nRow = V.row + delRow[i];
                int nCol = V.column + delCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && board[nRow][nCol] == 'O') {
                    q.add(new Pair(nRow, nCol));
                    board[nRow][nCol] = 'T';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'T')
                    board[i][j] = 'O';
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
