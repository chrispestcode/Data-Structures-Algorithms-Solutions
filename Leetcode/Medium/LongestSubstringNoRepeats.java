class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 ) return 0;
        if(s.length() == 1) return 1;
        Set<Character> seen = new HashSet<>();
        int l = 0, r = 1;
        seen.add(s.charAt(0));
        int max = r - l ;
        while(l <= r && r < s.length()) {
            Character nextChar = s.charAt(r);
            if(seen.contains(nextChar)) {
                if(r - l > max) max = r - l;
                seen.remove(s.charAt(l));
                l++;
            } else {
                seen.add(s.charAt(r));
                r++;
            }
        }
        if( r - l > max) max = r - l;
        return max;
    }
}