/*
https://leetcode.com/problems/jump-game/

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105

*/

class Solution {
    
    //recursion
    public static boolean minJumpsRec(int a[], int i) {
        boolean reached = false;
        if(i==a.length-1) return true;
        else if(a[i]==0) return false;
        for(int jumps=i+1;jumps<=i+a[i] && jumps<a.length;jumps++) {
            reached = reached || minJumpsRec(a,jumps);
        }
        return reached;
    }
    
    
    // Time limit exceeded.
    static Map<Integer, Boolean> mp;
    public static boolean minJumpsDp(int a[], int i) {
        boolean reached = false;
        if(i==a.length-1) return true;
        else if(a[i]==0) return false;
        else if(mp.containsKey(i)) return mp.get(i);
        for(int jumps=i+1;jumps<=i+a[i] && jumps<a.length;jumps++) {
            boolean tmp = mp.getOrDefault(jumps, minJumpsDp(a,jumps));
            reached = reached || tmp;
        }
        mp.put(i,reached);
        return reached;
    }
    
    
    // other dp approach 
    static boolean dp[];
    public boolean minJumpDp2(int a[]) {
        dp[0]=true;
        for(int i=0;i<a.length;i++) {
            for(int j=i-1;j>=0;j--) {
                if(a[j] != 0 && a[j]+j>=i && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[a.length-1];
    }
    
    
    public boolean canJump(int[] nums) {
        // mp = new HashMap<>();
        dp = new boolean[nums.length];
        if(nums.length==1) return true;
        if(nums[0]==0) return false;
        return minJumpDp2(nums);
        //return minJumpsDp(nums,0);
    }
}
