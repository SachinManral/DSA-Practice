class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxx = 0;
        for(int i=0; i<heights.length; i++){
            int minn = heights[i];
            for(int j=i; j<heights.length; j++){
                minn= Math.min(minn, heights[j]);
                maxx = Math.max(maxx, minn*(j-i+1));
                
            }
        }
        return maxx;
    }
}
