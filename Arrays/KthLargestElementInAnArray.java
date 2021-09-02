/*
https://leetcode.com/problems/kth-largest-element-in-an-array/

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104


// TODO : Work on Quick sort approach.

*/

class Solution {
    
    public static int left(int i) {return 2*i+1;}
    public static int right(int i) {return 2*i+2;}
    
    public static int extract(int a[], int n) {
        int t = a[n-1];
        a[n-1] = a[0];
        a[0] = t;
        n--;
        maxHeapify(a,0,n);
        return n;
    }
    
    public static void maxHeapify(int a[], int i, int n) {
        int largest = i;
        if(left(i)<n && a[largest]<a[left(i)]) largest = left(i);
        if(right(i)<n && a[largest]<a[right(i)]) largest = right(i);
        if(largest != i) {
            int t = a[largest];
            a[largest] = a[i];
            a[i] = t;
            maxHeapify(a, largest, n);
        }
    }
    
    public static void buildHeap(int a[], int n) {
        for(int i = n/2-1;i>=0;i--) {
            maxHeapify(a, i, a.length);
        }
    }

    
    public int findKthLargest(int[] nums, int k) {
        // Max Heap approach.
        /*
        1. Build max heap
        2. extract k-1 element from heap.
        top element is the one we have to return
        */
        buildHeap(nums, nums.length);
        int size = nums.length;
        for(int i=0;i<k-1;i++) {
            size = extract(nums,size);
        } 
        return nums[0];
        // Sorting Approach 
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        
    }
}
