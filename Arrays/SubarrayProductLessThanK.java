/*
https://leetcode.com/problems/subarray-product-less-than-k/

Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106


*/


class Solution {
    /*
    Because of only positive numbers we can use sliding window concept.
    */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0,j=0, n = nums.length, psf = 1, cnt = 0;
        
        while(j<n) {
            psf *= nums[j];
            if(psf<k) cnt += (j-i+1);
            else {
                while(i<n && psf>=k) {
                    psf /= nums[i];
                    i++;
                }
                if(psf<k) cnt += (j-i+1);
            }
            j++;
            //System.out.println(cnt);
        }
        return cnt;
    }
}
