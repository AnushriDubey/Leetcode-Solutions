/*
https://leetcode.com/problems/sudoku-solver/

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:


 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.

Code description will add later.

Key points learned: 
In sudoku along with rows and column check blocks as well.
To stop back tracking after first answer added line (1) [as this non null value of matrix will go to all previous activation frames]

*/


class SudokuSolver {
    boolean [][] row;
    boolean [][] col;
    boolean [][] block;
    
    public char[][] backtracking(char [][]bd, int i, int j) {    
        if(j==9) {
            i++;
            j=0;
         }
        if(i==9) {
            //for(char a[]: bd) System.out.println(Arrays.toString(a));
            return bd;
        }
        char[][] sudoku = null; 
        if(bd[i][j] != '.') return backtracking(bd, i, j+1);
        else {
                for(int v=1;v<=9;v++) {
                    if(!row[i][v] && !col[j][v] && !block[i/3 * 3 + j/3][v]) {
                        
                        row[i][v]=true;
                        col[j][v]=true;
                        block[i/3 * 3 + j/3][v]=true;
                        bd[i][j] = (char)(v + '0');
                        
                        sudoku = backtracking(bd,i,j+1);
                        if(sudoku != null) return sudoku; // ---------> 1 (to stop excution without back tracking.)                    
            
                        // look for other possibilities
                        bd[i][j] = '.';
                        row[i][v]=false;
                        col[j][v]=false;
                        block[i/3 * 3 + j/3][v]=false;
                    }
                }
            return sudoku;
        }
        
    }
    
    public void solveSudoku(char[][] bd) {
        row = new boolean [9][10];
        col = new boolean [9][10];
        block = new boolean [9][10];
        
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                int val = bd[i][j] - '0';
                if(val > 0) {
                    row[i][val]=true;
                    col[j][val]=true;
                    block[i/3 * 3 + j/3][val]=true;
                }
            }   
        }
               
        backtracking(bd,0,0);
    }
}
