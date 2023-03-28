import java.util.ArrayList;
import java.util.List;

class PalindromePartitions {
    public List<List<String>> partition(String s) {
        List<List<String>> pals = new ArrayList<>();
        int l = s.length() / 2;
        int r = l;
        if(s.length() % 2 == 0 ) {
            l -= 1;
        }
        while(l >= 0 && r < s.length()) {
            checkPartition(s, l , r, false, pals);
            l--;
            r++;
        }
        return pals;
    }

    public void checkPartition(String s, int l, int r, boolean isPalindrome, List<List<String>> pals) {
        List<String> pal = new ArrayList<>();
        if(l > r || l < 0 || r >= s.length()) return;
        if(s.charAt(l) == s.charAt(r)) {
            //checkPartition
            pal.add(s.substring(l,r+1));
            checkPartition(s, l-1, r, true, pals);
            checkPartition(s, l, r+1, true, pals);
            checkPartition(s, l-1, r+1, true,pals);
        }
        pals.add(pal);
        return;
    }
}
