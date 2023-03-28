import java.util.*;
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        char [] secretChar = secret.toCharArray();
        char [] guessChar = guess.toCharArray();
        for(int i = 0; i < secretChar.length; i++) {
            if(secretChar[i] == guessChar[i]) {
                bulls++;
            }
        }
        Arrays.sort(secretChar);
        Arrays.sort(guessChar);
        int i = 0, j = 0;
        while(i < secretChar.length && j < guessChar.length) {
            if(secretChar[i] == guessChar[j] ) {
                cows++;
                i++; j++;
            }
            else if(secretChar[i] < guessChar[j]) {
                i++;
            }
            else if(secretChar[i] > guessChar[j]) {
                j++;
            }
        }
        String res = bulls + "A" + (cows-bulls) + "B";
        return res;
    }
}

/**
 * https://leetcode.com/problems/bulls-and-cows
 *
 * You are playing the Bulls and Cows game with your friend.
 *
 * You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:
 *
 * The number of "bulls", which are digits in the guess that are in the correct position.
 * The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
 * Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.
 *
 * The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
 *
 *
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 * Output: "1A3B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1807"
 *   |
 * "7810"
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1123"        "1123"
 *   |      or     |
 * "0111"        "0111"
 * Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
 *
 * Runtime > 60%  Space > 100%
 */
