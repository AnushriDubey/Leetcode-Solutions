347. Top K Frequent Elements

https://leetcode.com/problems/top-k-frequent-elements/

Solved with brute force, Come up with better solution 



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, int[]> mp = new HashMap<>();
        Comparator<int[]> c = new Comparator<>() {
            public int compare(int[] a, int[] b) {
            if(a[1] > b[1]) return -1;
            if(a[1] < b[1]) return 1;
            else return 1;
        }};
        PriorityQueue<int[]> pq = new PriorityQueue<>(c);
        
        for(int i: nums) {
            int[] tmp = mp.getOrDefault(i, new int[]{i, 0});
            tmp[1] += 1;
            mp.put(i, tmp);
        }
        for(Map.Entry<Integer, int[]> e: mp.entrySet()) {
            pq.add(e.getValue());
        }
        int res[] = new int[k];
        for(int i=0;i<k;i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
