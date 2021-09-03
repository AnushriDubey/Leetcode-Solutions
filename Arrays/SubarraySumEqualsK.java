/*
https://leetcode.com/problems/subarray-sum-equals-k/

Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107

*/


class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length, cnt =0, ssf = 0; // sum so far.
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0;i<n;i++) {
            ssf += nums[i];
            int diff = ssf-k;
            if(ssf == k) cnt += 1; // sum from [0..i] == k
            if(hm.containsKey(diff)) cnt += hm.get(diff); // subarray present in array with sum == k
            hm.put(ssf, hm.getOrDefault(ssf, 0)+1);
        }
        return cnt;
    }
}
