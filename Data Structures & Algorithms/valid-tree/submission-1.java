class Solution {
    static int[] rank;
    static int[] parent;
    static int component;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        component = n;
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int j = 0; j < edges.length; j++) {
            int p_x = find(edges[j][0], parent);
            int p_y = find(edges[j][1], parent);

            if (p_y == p_x) return false; 
            if (rank[p_x] < rank[p_y]) {
                parent[p_x] = p_y;
                component--;
            } else if (rank[p_x] > rank[p_y]) {
                parent[p_y] = p_x;
                component--;
            } else {
                parent[p_x] = p_y;
                rank[p_y]++;
                component--;
            }
        }
        return (component > 1) ? false : true;
    }

    public int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }
}