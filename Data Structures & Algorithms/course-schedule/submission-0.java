class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        int[] inDeg = new int[numCourses];

        for(int[] pre:prerequisites){
            int u = pre[0];
            int v = pre[1];

            inDeg[u]++;
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDeg[i]==0){
                q.offer(i);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            int cur = q.poll();
            list.add(cur);

            for(int ad:adj.get(cur)){
                inDeg[ad]--;
                if(inDeg[ad]==0) q.offer(ad);
            }
        }
        return list.size()==numCourses;
    }
}
