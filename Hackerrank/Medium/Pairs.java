/*
    12/10/2022

    Pairs

    Given an array of integers and a target value, determine the number of pairs of array elements
        that have a difference equal to the target value.

    Search/Sorting
        -unsorted array
           2 <= n <= 10^5, where n is # if values in array.
           0 < k < 10^9, where k is the target value.
           0 < arr[i]  < 2^31 -1
           each arr[i] will be unique.

    Approach:
        1) One pass through array using a set. If the result of (a-b) or (b-a) is seen, then we increment counter.

    Timeline:
        5:30 Implemented solution. 1/18 test cases failed.
                n = 99998
                k = 793735
                Did a custom test case as well that included max ar[i] values.
        TIMED OUT [20:00]

    Big O Analysis
        Time: O(n)
        Space: O(n)

    Discussion:
        Space vs Time problem:
            (Sort for better time) nlog(n)  + (then calculate on head and tail ends for target value) n
                    using o(1) space

            or use Set (in this problem)
                Space for O(n)
                Time for O(n).

            Space costs are cheaper than time costs in large scale problems. Opt for current solution.

        Failing test case:
            Simple mistake but was the main problem. We're looking for difference, I was overcounting.
                Initially, the set up was looking for 3 values:
                    c-a ? count++ (not valid because we're looking fopr the following two values)
                    a-c ? count++
                    c+a ? count++
                (c-a) was the first condition I wrote and caused for a longer debug. Be careful with naming.
                The variable could be named *diff* for better readability.
 */


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        Set<Integer> existingNums = new HashSet<>();
        int count = 0;
        for(int i = 0; i < arr.size(); i++) {
            if(existingNums.contains(k + arr.get(i))){
                count++;
            }
            if(existingNums.contains(arr.get(i) - k)){
                count++;
            }
            existingNums.add(arr.get(i));
        }
        System.out.println(" COUNT: " + count);
        return count;
    }

}

public class Pairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
