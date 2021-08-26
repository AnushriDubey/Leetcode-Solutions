
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.



Description:





*/

class Solution {
    
    public static int recPaths(int r, int c) {
        if(r==0 || c==0) return 1;
        return recPaths(r-1,c) + recPaths(r,c-1);
    }
    
    static int dp[][];
    public static int dpPaths(int r, int c) {
        if(r==0 || c==0) return 1;
        if(dp[r][c]!=-1) return dp[r][c];
        return dp[r][c] = dpPaths(r-1,c) + dpPaths(r,c-1);
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int a[]: dp) Arrays.fill(a,-1);
        return dpPaths(m-1, n-1);
    }
}
