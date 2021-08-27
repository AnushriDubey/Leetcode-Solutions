/*

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45


Description:

dp[n] --> it is storing total number of ways possible to reach to nth step by using (n-1, n-2) stairs

*/


class Solution {
    
    public int climbStairsRec(int n) {
        if(n<0) return 0;
        else if(n==0) return 1;
        return climbStairsRec(n-1) + climbStairsRec(n-2);
    }
    
    static int dp[];
    public int climbStairsDp(int n) {
        if(n<0) return 0;
        else if(n==0) return 1;
        else if(dp[n]!=-1) return dp[n];
        return dp[n] = climbStairsDp(n-1) + climbStairsDp(n-2); 
    }
    
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairsDp(n);
    }
}

