import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TakeKLeftRight {
    public static void main(String[] args) {
    }

    static class CharFrequency {
        public int freq;
        private char ch;
        CharFrequency(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public int getFreq() {
            return freq;
        }
    }
    public int takeCharacters(String s, int k) {
        Queue<CharFrequency> freq = new PriorityQueue<>(Comparator.comparing(CharFrequency::getFreq, (v1,v2) -> {
         return v1-v2;
        }));

        for(int i = 0; i < k ; i++) {
            
        }
        return 0;
    }
}
