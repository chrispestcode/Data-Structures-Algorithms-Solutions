package Easy;

class ValidPalindrome {
    public static boolean isDigitOrLetter(char a){
        return Character.isDigit(a) || Character.isLetter(a);
    }

    public boolean isPalindrome(String s) {
        if (s.trim() == "") return true;
        char [] sArr = s.toCharArray();
        int i = 0, j = sArr.length-1;
        while(i < j) {
            while(i < sArr.length-1 &&  (sArr[i] == ' ' || !isDigitOrLetter(sArr[i]))
            ) {
                i++;
            }
            while( j > 0 && (sArr[j] == ' ' || !isDigitOrLetter(sArr[j]))
            ) {
                j--;
            }
            sArr[i] = Character.toLowerCase(sArr[i]);
            sArr[j] = Character.toLowerCase(sArr[j]);
            if(sArr[i] != sArr[j] && isDigitOrLetter(sArr[j])
                    && isDigitOrLetter(sArr[i])) return false;
            i++; j--;
        }
        return true;
    }
}

/**
 * https://leetcode.com/problems/valid-palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters
 * and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 *
 * Runtime: > 97%  Space: > 100%
 */