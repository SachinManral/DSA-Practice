class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        return helper(n-1, m-1, word1, word2);

    }

    public int helper(int i, int j, String s1, String s2){
        if(i<0 && j<0) return 0;

        if(i<0 && j>=0) return j+1;
        if(j<0 && i>=0) return i+1;

        if(s1.charAt(i)==s2.charAt(j)) return helper(i-1, j-1, s1, s2);

        else {
            int inst = helper(i, j-1, s1, s2);
            int dlt = helper(i-1, j, s1, s2);
            int rplc = helper(i-1, j-1, s1, s2);
            return 1 + Math.min(inst, Math.min(dlt, rplc));
        }
    }
}
