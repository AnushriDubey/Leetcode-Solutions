/*

https://leetcode.com/problems/product-of-array-except-self/

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int p = 1, n = nums.length, cnt = 0;
        for(int i=0;i<n;i++) {
            if(nums[i]==0) cnt++;
            else p *= nums[i];
        } 
        for(int i=0;i<n;i++) {
            if(cnt >=2) nums[i]=0;
            else if(cnt == 1) {
                if(nums[i]!= 0) nums[i]=0;
                else nums[i]=p;
            } 
            else if(cnt==0) {
                nums[i]=p/nums[i];
            }
        }
        return nums;
    }
}
