class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int max=0;
        int sum=0;
        Set<Character> set = new HashSet<>();

        for(int j=0; j<s.length(); j++){
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            max = Math.max(max, j-i+1);
        }
        return max;
    }
}
