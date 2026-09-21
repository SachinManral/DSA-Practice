// class Solution {
//     public int minDistance(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();

//         return helper(n-1, m-1, word1, word2);

//     }

//     public int helper(int i, int j, String s1, String s2){
//         if(i<0 && j<0) return 0;

//         if(i<0 && j>=0) return j+1;
//         if(j<0 && i>=0) return i+1;

//         if(s1.charAt(i)==s2.charAt(j)) return helper(i-1, j-1, s1, s2);

//         else {
//             int inst = helper(i, j-1, s1, s2);
//             int dlt = helper(i-1, j, s1, s2);
//             int rplc = helper(i-1, j-1, s1, s2);
//             return 1 + Math.min(inst, Math.min(dlt, rplc));
//         }
//     }
// }






// class Solution {
//     public int minDistance(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();
//         Integer[][] dp = new Integer[n+1][m+1];
//         return helper(n-1, m-1, word1, word2, dp);

//     }

//     public int helper(int i, int j, String s1, String s2, Integer[][] dp){
//         if(i<0 && j<0) return 0;
//         if(i<0 && j>=0) return j+1;
//         if(j<0 && i>=0) return i+1;
//         if(dp[i][j] != null) return dp[i][j];

//         if(s1.charAt(i)==s2.charAt(j)) return helper(i-1, j-1, s1, s2, dp);

//         else {
//             int inst = helper(i, j-1, s1, s2, dp);
//             int dlt = helper(i-1, j, s1, s2, dp);
//             int rplc = helper(i-1, j-1, s1, s2, dp);
//             return 1 + Math.min(inst, Math.min(dlt, rplc));
//         }
//     }
// }







// class Solution {
//     public int minDistance(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();
//         int[][] dp = new int[n+1][m+1];
//         dp[0][0] = 0;

//         for(int i=1; i<=n; i++){
//             dp[i][0] = i;
//         }

//         for(int j=1; j<=m; j++){
//             dp[0][j] = j;
//         }

//         for(int i=1; i<=n; i++){
//             for(int j=1; j<=m; j++){
//                 if(word1.charAt(i-1)==word2.charAt(j-1)){
//                     dp[i][j] = dp[i-1][j-1];
//                 }else {
//                     int inst = dp[i][j-1];
//                     int dlt = dp[i-1][j];
//                     int rplc = dp[i-1][j-1];
//                     dp[i][j] = 1+Math.min(inst, Math.min(dlt, rplc));
//                 }
//             }
//         }
//         return dp[n][m];
//     }
// }








class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()<word2.length()) return minDistance(word2, word1);

        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int i=0; i<=m; i++) prev[i]=i;

        for(int i=1; i<=n; i++){
            curr[0] = i;
            for(int j=1; j<=m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] = prev[j-1]; 
                }else {
                    int inst = curr[j-1];
                    int dlt = prev[j];
                    int rplc = prev[j-1];
                    curr[j] =1+Math.min(inst, Math.min(dlt, rplc));
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[m];
    }
}