class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] freq = new int[256];
        for(char ch:t.toCharArray()){
            freq[ch]++;
        }

        int i=0, j=0;
        int stIdx=-1;
        int cnt=0;
        int minLen=Integer.MAX_VALUE;

        while(j<n){
            if(freq[s.charAt(j)]>0){
                cnt++;
            }
            freq[s.charAt(j)]--;

            while(cnt==m){
                if(j-i+1<minLen){
                    minLen = j-i+1;
                    stIdx=i;
                }
                freq[s.charAt(i)]++;
                if(freq[s.charAt(i)]>0){
                    cnt--;
                }
                i++;
            }
            j++;
        }
        return stIdx==-1?"":s.substring(stIdx, minLen+stIdx);
    }
}
