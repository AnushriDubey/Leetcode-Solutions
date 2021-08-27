/*
https://leetcode.com/problems/unique-paths-ii/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

 

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.


Description:

Add one more check if we are landing to any cell where we have obstacle number of paths possible from it is 0.

We can try out direct approach as well -
start from (0,0)
make a method call for right and down then if we are at cell(m-1, n-1) then say one path possible else keeping digging in till we reaches 
there because of obstacles in this case. we can not directly return from last row and column because of obstacles in this problem.

*/


class Solution {
    
  // recursive solution
    public static int recPaths(int r, int c, int[][] obstacleGrid) {
        if(r==0 && c==0) return 1;
        if((r<0 || r>= obstacleGrid.length) || (c<0 || c>=obstacleGrid[0].length)) return 0;
        if(obstacleGrid[r][c]==1) return 0;
        else return recPaths(r-1,c,obstacleGrid) + recPaths(r,c-1,obstacleGrid); 
    }
    
  
  // dp approach
    static int dp[][];
    public static int dpPaths(int r, int c, int[][] obstacleGrid) {
        if(r==0 && c==0 && obstacleGrid[r][c] == 0) return 1;
        //else if((r<0 || r>= obstacleGrid.length) || (c<0 || c>=obstacleGrid[0].length)) return 0;
        else if((r<0 || r>= obstacleGrid.length) || (c<0 || c>=obstacleGrid[0].length) || obstacleGrid[r][c]==1) return 0;
        else if(dp[r][c] != -1) return dp[r][c];
        else return dp[r][c] = dpPaths(r-1,c,obstacleGrid) + dpPaths(r,c-1,obstacleGrid); 
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        dp = new int[row][col];
        for(int a[]: dp) Arrays.fill(a,-1);
        return dpPaths(row-1, col-1, obstacleGrid);
    }
}
