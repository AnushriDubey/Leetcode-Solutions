/*
https://leetcode.com/problems/sort-an-array/

Given an array of integers nums, sort the array in ascending order.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
 

Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104

*/

class Solution {
    
     public int partition(int a[], int l, int h) {
        int pivot = a[l];
        int i=l+1, j = h;
        while(i<j) {
            while(i<=h && a[i]<=pivot) i++;
            while(j>=0 && a[j]>pivot) j--;
            if(i<j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        if(pivot >= a[j]) {
            int t = a[l];
            a[l] = a[j];
            a[j] = t;
        }
        return j;
    }
    
    public void quikSort(int a[], int l, int h) {
        if(l<h) {
            int mid = partition(a,l,h);
            quikSort(a,l,mid-1);
            quikSort(a,mid+1,h);
        }
    }
    
    public int[] sortArray(int[] nums) {
        // mergeSort(nums, 0, nums.length-1);
        quikSort(nums, 0, nums.length-1);
        return nums;
    }
}
