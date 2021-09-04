/*
https://leetcode.com/problems/subsets-ii/

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10



*/

class Solution {
    /*
    backtracking.
    
    */
    
    HashSet<List<Integer>> ls;
    public void powerSet(int[] nums, int i, List<Integer> tmp) {
        if(i==nums.length) ls.add(new ArrayList(tmp));
        else {
            tmp.add(nums[i]);
            powerSet(nums,i+1,tmp);
            //backtracking
            tmp.remove(tmp.size()-1);
            powerSet(nums,i+1,tmp);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ls = new HashSet<>();
        powerSet(nums, 0, new ArrayList<>());
        return new ArrayList<>(ls);
    }
}
