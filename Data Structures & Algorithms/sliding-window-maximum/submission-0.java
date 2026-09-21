class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int i=0, j=0, ptr=0;
        int[] res = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();

        while(j<n){
            while(!dq.isEmpty() && dq.peekLast()<nums[j]){
                dq.pollLast();
            }

            dq.add(nums[j]);
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                res[ptr++] = dq.peek();

                if(nums[i]==dq.peek()){
                    dq.pollFirst();
                }
                i++;
                j++;
            }
        }
        return res;
    }
}
