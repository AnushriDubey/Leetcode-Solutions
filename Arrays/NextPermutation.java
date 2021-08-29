/*
https://leetcode.com/problems/next-permutation/

mplement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100


1. find the minIndex
2. if(min element present) look for max element in the right of that.
3. swap these two elements and sort the right minI subarray

*/


class Solution {
    public void nextPermutation(int[] nums) {
        int minI = -1, maxI = -1, n = nums.length;
        for(int i=n-1;i>0;i--) {
            if(nums[i]>nums[i-1]) {
                minI = i-1;
                break;
            }
        }
        if(minI == -1) {
            int s=0, e=n-1;
            while(s<e) {
                int t = nums[s];
                nums[s] = nums[e];
                nums[e] = t;
                s++;
                e--;
            }
        }
        else {
            for(int i = minI+1;i<n;i++) {
                if(nums[minI]<nums[i]) maxI = i; // consider the Right most value as that will be the least one from the concept of minIndex.
            }
            int t = nums[minI];
            nums[minI] = nums[maxI];
            nums[maxI] = t;
            Arrays.sort(nums, minI+1, n);
        }
        //return nums;
    }
}
