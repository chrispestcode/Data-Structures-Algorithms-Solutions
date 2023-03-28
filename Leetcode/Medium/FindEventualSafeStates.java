import java.util.*;
public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> ancestors = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> safeNodes = new HashSet<>();
        for(int i = 0; i < graph.length; i++) {
            safeNodes.add(i);
        }
        for(int i = 0; i < graph.length; i++) {
            if(!visited.contains(i)){ //0
                if(!isNodeSafe(graph, visited, ancestors, i, safeNodes)){
                    safeNodes.remove(i);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(Integer x : safeNodes) {
            ans.add(x);
        }
        Collections.sort(ans);
        return ans;
    }
    //  1 2 3 4 5 6
    public boolean isNodeSafe(int[][] graph, Set<Integer> visited, Set<Integer> ancestors, int current, Set<Integer> safeNodes) {
        visited.add(current); //[0,1,2,3]
        ancestors.add(current); //[0,1,3]


        for(int i = 0; i < graph[current].length; i++) {
            if(!visited.contains(graph[current][i])){ // 1  //3
                if(!isNodeSafe(graph, visited, ancestors, graph[current][i], safeNodes)){
                    safeNodes.remove(graph[current][i]);
                    return false;
                }
            }
            else if (ancestors.contains(graph[current][i])) {
                //this is a cycle. remove the current node
                safeNodes.remove(graph[current][i]);
                return false;
            }
            else{}
        }
        ancestors.remove(current);
        if(graph[current].length == 0) {
            return true; //return @ 5
        }

        return true;
    }
}

/*
https://leetcode.com/problems/find-eventual-safe-states/

There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.



Example 1:

Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
Example 2:

Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.


Constraints:

n == graph.length
1 <= n <= 104
0 <= graph[i].length <= n
0 <= graph[i][j] <= n - 1
graph[i] is sorted in a strictly increasing order.
The graph may contain self-loops.
The number of edges in the graph will be in the range [1, 4 * 104].

Runtime > 30% Space > 100%
 */