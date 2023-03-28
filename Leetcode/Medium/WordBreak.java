import java.util.*;
public class WordBreak {
    //FOR DP Problems: keep track of seen values to avoid timing out
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>();
        Map<String, Boolean> seen = new HashMap<>();
        for(String x: wordDict) {
            wordDictSet.add(x);
        }
        if(wordDictSet.contains(s)) {
            return true;
        }
        return canBeSegemented(0, 1, s.length(), wordDictSet,s,seen);
    }

    public boolean canBeSegemented(int start, int pivot, int end, Set<String> wordDict, String s, Map<String, Boolean> map)     {
        String curr = s.substring(start, end);
        if(pivot >= end){
            return false;
        }
        else if(wordDict.contains(curr)){
            return true;
        }
        else if(map.containsKey(curr)) {
            return map.get(curr);
        }
        else {
            while(pivot < end) {
                if(wordDict.contains(s.substring(start,pivot))){
                    if(wordDict.contains(s.substring(pivot,end))){
                        return true;
                    }
                    else if(canBeSegemented(pivot, pivot+1, end, wordDict, s, map)){
                        map.put(s, true);
                        return true;
                    }
                    else{
                    }
                }
                pivot++;
            }
            map.put(curr, false);
            return false;
        }
    }
}

/**
 * https://leetcode.com/problems/word-break/
 *
 *  Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 *  sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 * Runtime > 59% Space > 100%
 */