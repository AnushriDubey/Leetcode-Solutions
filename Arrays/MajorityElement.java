/*
https://leetcode.com/problems/majority-element/

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-231 <= nums[i] <= 231 - 1
 

Follow-up: Could you solve the problem in linear time and in O(1) space?



*/


class Solution {
    /*
    as per the description majority element exists so need for further check.
    */
    public int majorityElement(int[] nums) {
        int cnt = 1, curr = nums[0], n = nums.length;
        
        for(int i=1;i<n;i++) {
            if(nums[i]==curr) cnt += 1;
            else if(cnt>0) cnt -= 1;
            else if(cnt == 0) {
                curr = nums[i];
                cnt = 1;
            }
        }
        return curr;
    }
}
