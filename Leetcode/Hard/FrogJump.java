import java.util.*;
public class FrogJump {
        class Tuple {
            int index;
            int k;
            public Tuple (int index, int k) {
                this.index = index;
                this.k = k;
            }

            @Override
            public int hashCode(){
                int hash = 31;
                return 11* hash * (11 * hash + index) + k;
            }

            @Override
            public boolean equals(Object o) {
                if(this == o) return true;
                if(!(o instanceof Tuple)) return false;
                if(((Tuple)o).index == this.index && ((Tuple)o).k == this.k) {
                    return true;
                }
                return false;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        Set visited = new HashSet<>();
        public boolean canCross(int[] stones) {
            for(int i = 0; i< stones.length; i++) {
                map.put(stones[i],i);
            }
            return canJump(stones,0,1,1,visited);
        }

        public boolean canJump(int[]stones, int i, int k, int nextStone, Set<Tuple> visited) {
            if(!map.containsKey(nextStone) || k == 0 || visited.contains(new Tuple(i,k))) {
                return false;
            }
            visited.add(new Tuple(i,k));
            i = map.get(nextStone);
            if(nextStone==stones[stones.length-1]) return true;
            if(nextStone > stones[stones.length-1]) return false;
            return canJump(stones,i,k-1,nextStone+k-1,visited) || canJump(stones,i,k,nextStone+k,visited)
                    || canJump(stones,i,k+1,nextStone+k+1,visited);
        }
    }

/*

https://leetcode.com/problems/frog-jump/

A frog is crossing a river. The river is divided into some number of units, and at each unit,
  there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by
 landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units.
The frog can only jump in the forward direction.



Example 1:

Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone,
then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
Example 2:

Input: stones = [0,1,2,3,4,8,9,11]
Output: false
Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.

Runtime > 91%  Space > 83%
 */