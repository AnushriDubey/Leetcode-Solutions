/*

https://leetcode.com/problems/trapping-rain-water/


Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105


Description:

idea here is get max seen so far on both side of number.
    and sum += Math.min(leftMax, rightMax) - height of present tower.
  sum amount of water will be stored.
  
*/

class Solution {
  
    public int trap(int[] height) {
        int n= height.length, lMax = 0, rMax = 0, lM[] = new int[n], sum=0;
        for(int i=0;i<n;i++) {
            lMax = Math.max(lMax, height[i]);
            lM[i] = lMax;
        }
        for(int i=n-1;i>=0;i--) {
            rMax = Math.max(rMax, height[i]);
            sum += Math.min(rMax, lM[i])-height[i];
        }
        return sum;
    }
}
