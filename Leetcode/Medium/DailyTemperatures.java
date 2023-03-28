public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if (T.length < 1 || T == null) return T;
        int[] prevTemp = new int[T.length];
        prevTemp[T.length - 1] = 0;

        //My solution: Runtime > 5% Space > 100%
        // brute force:
        // for(int i = 0; i < T.length; i++){
        //     for(int j = i+1; j < T.length; j++){
        //         if(T[i] < T[j]){
        //             prevTemp[i] = j-i;
        //             break;
        //         }
        //         else if(j == T.length-1){
        //             prevTemp[i] = 0;
        //             break;
        //         }
        //     }
        // }

        //Alt Solution: Runtime > 100% Space > 100%
        for (int i = T.length - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                prevTemp[i] = 1;
            } else {
                for (int j = i + 1; ; j = j + prevTemp[j]) {
                    if (T[i] < T[j]) {
                        prevTemp[i] = j - i;
                        break;
                    }
                    if (prevTemp[j] == 0) {
                        prevTemp[i] = 0;
                        break;
                    }
                }
            }
        }
        return prevTemp;
    }
}
/**
 * https://leetcode.com/problems/daily-temperatures
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 */