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
    
    public void merge(int a[], int l, int mid, int h) {
        int left[] = new int[mid-l+1];
        int right[] = new int[h-mid];
        int k=0;
        for(int i=l;i<=mid;i++) left[k++] = a[i];
        k=0;
        for(int i=mid+1;i<=h;i++) right[k++] = a[i];
        int i=0,j=0;
        k=l;
        while(i<left.length && j<right.length) {
            if(left[i]<=right[j]) a[k++]=left[i++];
            else a[k++]=right[j++];
        }
        while(i<left.length) a[k++]=left[i++];
        while(j<right.length) a[k++]=right[j++];
    }
    
    public void mergeSort(int a[], int l, int h) {
        if(l<h) {
            int mid = l + (h-l)/2;
            mergeSort(a, l, mid);
            mergeSort(a, mid+1, h);
            merge(a, l, mid, h);
        }
    }
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}
