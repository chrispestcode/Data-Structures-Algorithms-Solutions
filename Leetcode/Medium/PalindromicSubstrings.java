import java.util.*;
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count1 = recursiveSearch(s,false);
        int count2 = recursiveSearch(s, true);
        return count1+count2;
    }

    public static int recursiveSearch(String s, Boolean evenMode) {

        Map<String, Integer> seen = new HashMap<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            int r = i;
            int l = r;
            if(evenMode) {
                r++;
            }
            while(r < s.length() && l >= 0 && s.charAt(r)==s.charAt(l)) {
                count++;
                r++;
                l--;
            }
        }
        //keep going as long as it matches
        //call to pivot left
        //call to pivot right
        return count;
    }
}

/*
https://leetcode.com/problems/palindromic-substrings/

Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Runtime > 97%  Space > 100%
 */