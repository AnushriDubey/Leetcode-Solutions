/*
https://leetcode.com/problems/minimum-path-sum/

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100


Description:

grid[i][j] + Math.min(minPathRec(grid, i+1,j), minPathRec(grid, i,j+1));
This is because we have to take 1st cell sum after very first cell go for max of right and down.

*/


class Solution {
  public static int minPathRec(int grid[][], int i, int j) {
    if(i==grid.length-1 && j==grid[0].length-1) return grid[i][j]; // if we are at destination cell return value directly
    else if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return 1000000; // check for invalid index
    else return grid[i][j] + Math.min(minPathRec(grid, i+1,j), minPathRec(grid, i,j+1));
    }
    
    
    static int dp[][];
  public static int minPathDp(int grid[][], int i, int j) {
    if(i==grid.length-1 && j==grid[0].length-1) return grid[i][j]; // if we are at destination cell return value directly
    else if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return 1000000; // check for invalid index
    else if(dp[i][j]!=-1) return dp[i][j];
    else return dp[i][j] = grid[i][j] + Math.min(minPathDp(grid, i+1,j), minPathDp(grid, i,j+1));
    }    
    
    
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];
        for(int a[]: dp) Arrays.fill(a,-1);
        return minPathDp(grid, 0,0);
    }
}
