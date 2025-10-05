class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inColor = image[sr][sc];

        if (inColor == color)
            return image;

        int[][] answer = image;
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        dfs(answer, image, sr, sc, delRow, delCol, color, inColor);
        return answer;

    }

    public void dfs(int[][] ans, int[][] image, int row, int column, int[] delRow, int[] delCol, int nColor,
            int inColor) {
        ans[row][column] = nColor;
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = column + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && ans[nrow][ncol] == inColor) {
                dfs(ans, image, nrow, ncol, delRow, delCol, nColor, inColor);
            }
        }

    }
}
