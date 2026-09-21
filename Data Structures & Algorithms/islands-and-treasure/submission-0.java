class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int land = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==INF){
                    land++;
                }else if(grid[i][j]==0){
                    q.offer(new int[]{i, j, 0});
                }
            }
        }
        if(land==0) return;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dis = curr[2];

            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==INF){
                    grid[nr][nc] = dis+1;
                    land--;
                    q.offer(new int[]{nr, nc, dis+1});
                }
            }
        }
    }
}
