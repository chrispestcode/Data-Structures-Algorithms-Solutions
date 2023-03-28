package Easy;

public class ReverseString {
        public void reverseString(char[] s) {
            int i = 0, j = s.length -1;
            char placeholder;
            while(i <= j){
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++; j--;
            }
            return;
        }
    }

/*
https://leetcode.com/problems/reverse-string

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Runtime > 100% Space > 99%
 */