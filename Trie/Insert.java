/*

insert into trie.

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
   
  
      
    static TrieNode root;
    public void insertIntoTrie(String s, List<String> wordDict) {
        root = new TrieNode('0');
        for(int i=0;i<n;i++) insert(root, wordDict.get(i));
    }
}
