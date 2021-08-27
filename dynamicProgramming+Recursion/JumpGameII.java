/*
https://leetcode.com/problems/jump-game-ii/


Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000

Description idea here:
Can solve this problem by using recursion in which will try to find min number of jumps to get to destination from this point.
  Dynamic programming dp[i] will store number of jumps required to get to destination.
  

*/


class Solution {
    
  
    // Recursion.
    public static int minJumpsRec(int a[], int i) {
        int min = Integer.MAX_VALUE;
        if(i==a.length-1) return 0;
        else if(a[i]==0) return min;
        for(int jumps=i+1;jumps<=i+a[i] && jumps<a.length;jumps++) {
            int t = minJumpsRec(a,jumps);
            if(t!=Integer.MAX_VALUE) t = t +1;
            min = Math.min(min, t);
        }
        return min;
    }
    
  
  // dynamic programming dp[i] will store number of jumps required to get to destination.
    static int dp[];
    public static int minJumpsDp(int a[], int i) {
        int min = Integer.MAX_VALUE;
        if(i==a.length-1) return 0;
        else if(a[i]==0) return min;
        else if(dp[i]!=-1) return dp[i];
        for(int jumps=i+1;jumps<=i+a[i] && jumps<a.length;jumps++) {
            int t = minJumpsDp(a,jumps);
            if(t!=Integer.MAX_VALUE) t = t +1;
            min = Math.min(min, t);
        }
        dp[i] = min; // minimum number of steps required to get to destination from this index.
        return min;
    }
    
  
    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return minJumpsDp(nums,0);
        
    }
}
