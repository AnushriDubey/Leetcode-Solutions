451. Sort Characters By Frequency

https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
    static class Pair{
        char c;
        int freq;
        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
    public String frequencySort(String s) {
        Map<Character, Pair> mp = new HashMap<>();
        Comparator<Pair> com = new Comparator<>(){
          public int compare(Pair p1, Pair p2) {
              if(p1.freq > p2.freq) return -1;
              else if(p1.freq < p2.freq) return 1;
              return 1;
          }  
        };
        PriorityQueue<Pair> pq = new PriorityQueue<>(com);
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            Pair p = mp.getOrDefault(c, new Pair(c, 0));
            p.freq += 1;
            mp.put(c, p);
        }
        
        for(Map.Entry<Character, Pair> en: mp.entrySet()) {
            pq.add(en.getValue());
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            for(int i=0;i<p.freq;i++) sb.append(p.c);
        }
        return sb.toString();
    }   
}
