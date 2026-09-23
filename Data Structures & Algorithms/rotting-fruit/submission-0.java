class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i, j, 0});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0) return 0;
        int maxTime = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int t = cur[2];

            maxTime = Math.max(maxTime, t);

            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    fresh--;
                    q.offer(new int[]{nr, nc, t+1});
                }
            }
        }
        return fresh==0?maxTime:-1;
    }
}
