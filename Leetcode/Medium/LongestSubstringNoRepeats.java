/*
    12/19/2022

    #3 Longest Substring Without Repeating Characters
    https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/862339727/

    Substring matching
   – Given a string s, find the length of the longest
        substring without repeating characters.

    Approach:
    1) Iterate through the string, starting at the first character.
    2) Using a set, add characters if they haven't been seen.
    3a) Use while loop to iterate while the left boundary is less than or equal the right boundary
     and boundaries are within array bounds.
    3b) Increase the right boundary if the new character isn't in the set and add it to the set.
    4) If it is in the set, resolve maximum length, remove the left boundary's character,
        and increase the left boundary.
    5) Check again if the new right boundary character is in set.
    6) Continue until loop completes then do a final maximum length check and return.

    <Timeline>

    Big O Analysis
    Time: O(N) 39.28%
    Space: O(N) 35.8%

    Discussion:
        Understand this solution: 5ms runtime top %:
            class Solution {
                   public int lengthOfLongestSubstring(String s) {
                    final int n = s.length();
                    int len = 0;
                    int [] repeat = new int[128];
                    for (int c = 0, j = 0, i = 0; j < n; j++) {
                        c = s.charAt(j);
                        i = Math.max(repeat[c], i);
                        len = Math.max(len, j - i +1);
                        repeat[c] = j+1;
                    }
                    return len;
                }
                }

        Additional questions:
            https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
            https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
*/

import java.util.HashSet;
import java.util.Set;

class LongestSunstringNoRepeats {
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