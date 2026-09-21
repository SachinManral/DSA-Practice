class Solution {
    int[] rank, parent;
    int components;
    public int countComponents(int n, int[][] edges) {
        components=n;
        rank = new int[n];
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i]=i;
        
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        // for(int[] e:edges){
        //     int u = e[0];
        //     int v = e[1];

        //     adj.get(u).add(v);
        //     adj.get(v).add(u);
        // }

        for(int[] e:edges){
            union(e[0], e[1]);
        }
        return components;
    }

    public int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px==py) return;

        if(rank[px]>rank[py]) parent[py]=px;
        else if(rank[py]>rank[px]) parent[px]=py;
        else{
            parent[px]=py;
            rank[py]++;
        }
        components--;
    }
}
