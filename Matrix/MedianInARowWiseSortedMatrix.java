/*
https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1#

Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.

Example 1:

Input:
R = 3, C = 3
M = [[1, 3, 5], 
     [2, 6, 9], 
     [3, 6, 9]]

Output: 5

Explanation:
Sorting matrix elements gives us 
{1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
 

Example 2:

Input:
R = 3, C = 1
M = [[1], [2], [3]]
Output: 2

Your Task:  
You don't need to read input or print anything. Your task is to complete the function median() which takes the integers R and C along with the 2D matrix as input parameters and returns the median of the matrix.

Expected Time Complexity: O(32 * R * log(C))
Expected Auxiliary Space: O(1)


Constraints:
1<= R,C <=150
1<= matrix[i][j] <=2000



*/


class Solution {
    int median(int matrix[][], int r, int c) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            int row = matrix.length, col = matrix[0].length;
            int required = ((r*c) + 1)/2; // CAREFULL ABOUT THIS
            for(int i=0;i<row;i++) min = Math.min(min, matrix[i][0]);
            for(int i=0;i<row;i++) max = Math.max(max, matrix[i][col-1]);
            
            while(min<max) {
                int mid = min + (max-min)/2;
                int left = 0;
                for(int i=0;i<row;i++) {
                    int cnt = Arrays.binarySearch(matrix[i], mid);
                    if(cnt<0) cnt = Math.abs(cnt+1);
                    else while(cnt < col && matrix[i][cnt] == mid) cnt += 1; // go till next bigger number to get the count.
                    left += cnt;
                }
                if(left < required) min = mid+1;
                else max = mid;
            }
            return min;
    }
}
