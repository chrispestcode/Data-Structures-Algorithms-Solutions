import java.util.*;
public class CourseSchedule {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if(prerequisites.length < 2) return true;
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            for(int i = 0; i < prerequisites.length; i++){
                List<Integer> val = adjList.getOrDefault(prerequisites[i][1], new ArrayList<Integer>());
                val.add(prerequisites[i][0]);
                adjList.put(prerequisites[i][1],val);
            }
            Set<Integer> visited = new HashSet<>();
            Set<Integer> ancestors = new HashSet<>();

            for(Integer vertex: adjList.keySet()){
                if(!visited.contains(vertex)) {
                    if(isCycle(adjList, visited, ancestors, vertex)){
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean isCycle(Map<Integer, List<Integer>> adjList, Set<Integer> visited, Set<Integer> ancestors, int current) {
            visited.add(current);
            ancestors.add(current);
            if(adjList.get(current) == null) {
                ancestors.remove(current);
                return false;
            }
            for(Integer u: adjList.get(current)){
                if(!visited.contains(u)){
                    if(isCycle(adjList, visited, ancestors, u)){
                        return true;
                    }
                }
                else if(ancestors.contains(u)) {
                    return true;
                }
                else{}
            }
            ancestors.remove(current);
            return false;
        }
    }

/**
 * https://leetcode.com/problems/course-schedule
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first
 *  if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 * Runtime: > 64%  Space: 100%
 */
