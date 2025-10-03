class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

       int[][] visited=new int[n][m];
       int[][] answer=new int[n][m];

       Queue <Pair> q=new LinkedList<>();
       for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j,0));
                    answer[i][j]=0;
                }
            }
       }
       while(!q.isEmpty()){
        Pair node=q.poll();
        visited[node.row][node.column]=1;
        answer[node.row][node.column]=node.step;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nRow=node.row+delRow[i];
            int nCol=node.column+delCol[i];
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m &&  mat[nRow][nCol]==1 && visited[nRow][nCol]==0){
                q.offer(new Pair(nRow,nCol,node.step+1));
                visited[nRow][nCol]=1;
            }
        }
       }
       return answer;
    }
}
class Pair{
    int row;
    int column;
    int step;
    Pair(int r ,int c,int s){
        this.row=r;
        this.column=c;
        this.step=s;
    }
}