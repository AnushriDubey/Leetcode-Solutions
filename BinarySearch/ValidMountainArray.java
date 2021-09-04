/*
https://leetcode.com/problems/valid-mountain-array/

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104



*/


class Solution {
    /*
    1. get the peak element
    2. then check in left subarray all the elements are in increasing order or not.
    3. then check in right subarray all the elements are in decreasing order or not.
    Note: In this problem there should be both up and down parts of mountain so added line (1) condition
    */
    
    public int getPeakIndex(int a[]) {
        int l = 0, n=a.length ,h = n-1;
        
        while(l<=h) {
            int mid = l + (h-l)/2;
            if(mid==0) {
                if(mid+1 < n && a[mid]>a[mid+1]) return mid;
                else l = mid+1;
            }
            if(mid==n-1) {
                if(mid-1 >=0 && a[mid-1]<a[mid]) return mid;
                else h = mid-1;
            }
            else if(a[mid]>a[mid+1] && a[mid]>a[mid-1]) return mid;
            else if(a[mid]>a[mid+1]) h = mid-1;
            else l = mid+1;
        }
        return -1;
    }
    
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3) return false;
        int n = arr.length, peakIndex = getPeakIndex(arr);
        if(peakIndex == 0 || peakIndex == n-1 || peakIndex==-1) return false; // --(1) No mountain forming
        for(int i=1;i<peakIndex+1;i++) if(arr[i-1] >=arr[i]) return false;
        for(int i=peakIndex+1;i<n;i++) if(arr[i-1] <= arr[i]) return false;
        return true;
    }
}
