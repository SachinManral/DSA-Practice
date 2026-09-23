class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    int n,m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int islands =0;
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c]=='1'){
                    dfs(r, c, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(int r, int c, char[][] grid){
        if(r<0 || c<0 || r>=n || c>=m || grid[r][c]=='0') return;

        grid[r][c]='0';
        for(int i=0; i<4; i++){
            dfs(r+dr[i], c+dc[i], grid);
        }
    }
}
