/*
https://leetcode.com/problems/word-break/

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.



*/


class Solution {
    static class TrieNode{
        char val;
        TrieNode tn[];
        boolean isEnd;
        TrieNode(char val) {
            this.val = val;
            this.tn = new TrieNode[26];
            this.isEnd = false;
        }
        // public String toString() {
        //     return "[" + Arrays.toString(this.tn) + ", " + this.isEnd + "]";
        // }
    }
  
    public static void insert(TrieNode root, String s) {
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int idx = c-'a';
            if(root.tn[idx]==null) {
                root.tn[idx] = new TrieNode(c);
            }
            root = root.tn[idx];
        }
        root.isEnd = true;
    }
    
    public static boolean isWordBreaks(String s, TrieNode root, int i, TrieNode tmp) {
        String str = i + "_" + tmp;
        while(i<s.length()) {
            char c = s.charAt(i);
            int idx = c-'a';
            if(tmp.tn[idx]==null) {
                //System.out.println(i + " " + c);
                return false;
            }
            else if(tmp.tn[idx]!=null) {
                tmp=tmp.tn[idx];
                if(tmp.isEnd) {
                    if(i+1 == s.length()) return true;
                    return isWordBreaks(s,root,i+1, root) || isWordBreaks(s,root,i+1, tmp);
                }
                else return isWordBreaks(s,root,i+1, tmp);
            }
        }
        //System.out.println(i);
        return tmp.isEnd;
    }
    
  
    
    static TrieNode root;
    HashSet<String> hs;
    HashMap<String,Boolean> hm;
    boolean isWordBreak(String s) {
        if(s==null || s.length()==0) return true;
        else if(hm.containsKey(s)) return hm.get(s);
        for(int i=1;i<=s.length();i++) {
            String left = s.substring(0,i);
            String right = s.substring(i);
            if(hs.contains(left) && isWordBreak(right)) {
                hm.put(s,true);
                return true;
            }
        }
        hm.put(s,false);
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        //root = new TrieNode('0');
        int n = wordDict.size();
        // for(int i=0;i<n;i++) insert(root, wordDict.get(i));
        // return isWordBreaks(s,root,0, root);
        hs = new HashSet<>(wordDict);
        hm = new HashMap<>();
        return isWordBreak(s);
    }
}
