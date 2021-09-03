/*
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/


Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
 

Follow up: Can you solve it in O(n) time complexity?




*/

class Solution {
    /*
        1. sort the array
        2. get first mismatched integer from LHS
        3. get first mismatched integer from RHS
    */
    
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int a[] = new int[n];
        for(int i=0;i<n;i++) a[i] = nums[i];
        Arrays.sort(nums);
        int i=0, j=n-1;
        boolean left = false, right= false;
        while(i<j && !(left && right)) {
            if(a[i]==nums[i]) i++;
            else left = true;
            if(a[j]==nums[j]) j--;
            else right = true;            
        }
        if(i==j) return 0;
        return j-i+1;
    }
}
