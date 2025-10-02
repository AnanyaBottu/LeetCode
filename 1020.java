class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][]answer=new int[n][m];
        bfs(answer,grid);

        int counter=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && answer[i][j]==0)counter++;
            }
        }
        return counter;
    }
    public void bfs(int[][]answer,int[][]grid){
        int n=grid.length;
        int m=grid[0].length;

        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 ||j==m-1) && grid[i][j]==1){
                    q.add(new Pair(i,j));
                    answer[i][j]=1;
                }
            }
        }
        while(!q.isEmpty()){
            Pair V=q.remove();
            int[] delRow={-1,0,1,0};
            int[] delCol={0,1,0,-1};

            for(int i=0;i<4;i++){
                int nRow=V.row+delRow[i];
                int nCol=V.column+delCol[i];

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1 && answer[nRow][nCol]==0){
                    q.add(new Pair(nRow,nCol));
                    answer[nRow][nCol]=1;
                }
            }

        }

    }
}
class Pair{
    int row;
    int column;
    Pair(int r, int c){
        this.row=r;
        this.column=c;
    }
}