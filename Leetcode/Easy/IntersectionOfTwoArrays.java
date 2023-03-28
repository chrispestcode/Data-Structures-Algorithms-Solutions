package Easy;

import java.util.*;
public class IntersectionOfTwoArrays {
        public int[] intersection(int[] nums1, int[] nums2) {
            if(nums1.length <= 0 || nums2.length <= 0){
                return new int[0];
            }
            Arrays.sort(nums2);
            Set<Integer> ans = new HashSet<>();
            for(int i = 0; i < nums1.length; i++){
                if(ans.contains(nums1[i])){
                    continue;
                }
                binarySearch(nums2, nums1[i], ans, 0, nums2.length-1);
            }
            int[] res = new int[ans.size()];
            int i = 0;
            for(Integer j: ans){
                res[i] = j;
                i++;
            }
            return res;
        }

        public void binarySearch(int[] nums, int target, Set<Integer> ans, int start, int end){
            int midpoint = start + (end-start)/2;

            if(start > end) {
                return;
            }
            if(target == nums[midpoint]) {
                ans.add(target);
                return;
            }
            else if(target > nums[midpoint]){
                binarySearch(nums, target, ans, midpoint+1, end);
            }
            else{
                binarySearch(nums, target, ans, start, midpoint-1);
            }
        }
    }

/*
https://leetcode.com/problems/intersection-of-two-arrays/

Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique and you may return the result in any order.


Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

Runtime > 50% Space > 100%
 */