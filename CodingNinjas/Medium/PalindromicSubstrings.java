class PalindoromicSubstrings {
    // Find the total number of palindromic substrings in str.
    // Time: O(n^2) Space: O(1)
    // Discussion: Possible trade space for time for better solution. Also, try memoization
    // https://www.codingninjas.com/codestudio/problems/palindromic-substrings_630404?topList=top-string-coding-interview-questions&leftPanelTab=3
    
    public static int palindromicSubstrings(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            count = count + countSubstrings(str, true, i) + countSubstrings(str, false, i);
        }
        return count;
    }

    public static int countSubstrings(String str, boolean evenMode, int i) {
        int count = 0;
        int j = i, k = i;
        if(evenMode) k++;
        while(j >= 0 && k < str.length()){
//                 System.out.println("Comparing: " +
//                                   str.charAt(j) + " and "  + str.charAt(k) + " For " + str.substring(j, k+1));
            if(str.charAt(j) != str.charAt(k)) {
                break;
            }
            count++;
            j--;
            k++;
        }
        //System.out.println("====CASE COMPLETE=====");
        return count;
    }
}
