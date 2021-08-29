/*
https://leetcode.com/problems/n-queens-ii/

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9



*/

class Solution {
    static boolean col[];
    static boolean nDig[];
    static boolean rDig[];
    static List<String> list;
    static int count = 0;
    public static void solve(int row, int n, StringBuilder sb2) {
        if(row == n) {
            count ++;
        }
        StringBuilder sb = new StringBuilder(sb2); 
        for(int i=0;i<n;i++) {
            if(!col[i] && !nDig[row+i] && !rDig[row-i + n -1]) {
                sb.setCharAt(i, 'Q');
                col[i] = true;
                nDig[row+i] = true;
                rDig[row-i + n -1] = true;
                solve(row+1, n, sb2);
                sb.setCharAt(i, '.');
                col[i] = false;
                nDig[row+i] = false;
                rDig[row-i + n -1] = false;
            }
        }
    }
    public int totalNQueens(int n) {
        StringBuilder sb2 = new  StringBuilder();
        for(int j=0;j<n;j++) {
             sb2.append(".");
        }
        count = 0;
        col = new boolean[n];
        nDig = new boolean[2*n - 1];
        rDig = new boolean[2*n - 1];
        solve(0,n, sb2);
        return count;
    }
}
