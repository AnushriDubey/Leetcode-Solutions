/*
https://leetcode.com/problems/maximum-length-of-repeated-subarray/

Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

 

Example 1:

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].
Example 2:

Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 100

*/


class Solution {
    /*
    // O(n^2) solution
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, max =0;
        for(int i=0;i<n1;i++) {
            for(int j=0;j<n2;j++) {
                if(nums1[i]==nums2[j]) {
                    int k1 = i, k2 = j;
                    while(k1<n1 && k2<n2 && nums1[k1]==nums2[k2]) {
                        k1++;
                        k2++;
                    }
                    max = Math.max(max,k1-i);
                }
            }
        }
        return max;
    }
    */
    
    
    // idea of longest common substring
    
    public int commonSubarray(int a1[], int a2[], int i, int j, int max) {
        if(i>=a1.length || j>=a2.length) return max;
        if(a1[i]==a2[j]) max = commonSubarray(a1,a2,i+1,j+1, max+1);
        return Math.max(max, Math.max(commonSubarray(a1,a2,i+1,j, 0),commonSubarray(a1,a2,i,j+1, 0)));
    }
    
    static int dp[][];
    public int commonSubarrayDp(int a1[], int a2[]) {
        int max = 0;
        for(int i=1;i<a1.length+1;i++) {
            for(int j=1;j<a2.length+1;j++) {
                if(a1[i-1]==a2[j-1]) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, max =0;
        dp = new int[n1+1][n2+1];
        return commonSubarrayDp(nums1, nums2);
    }
}
