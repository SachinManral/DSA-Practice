class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    int n, m;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int maxArea = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    int area = dfs(i, j, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int r, int c, int[][] grid){
        if(r<0 || c<0 || r>=n || c>=m || grid[r][c]==0) return 0;

        grid[r][c] = 0;
        int area = 1;
        for(int i=0; i<4; i++){
            area += dfs(r+dr[i], c+dc[i], grid);
        }
        return area;
    }
}
