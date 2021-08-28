/*
https://leetcode.com/problems/search-suggestions-system/

Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed. 

 

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
Example 4:

Input: products = ["havana"], searchWord = "tatiana"
Output: [[],[],[],[],[],[],[]]
 

Constraints:

1 <= products.length <= 1000
There are no repeated elements in products.
1 <= Σ products[i].length <= 2 * 10^4
All characters of products[i] are lower-case English letters.
1 <= searchWord.length <= 1000
All characters of searchWord are lower-case English letters.



*/



class Solution {
  
  /*
  We will use trie data structure here to get most common 3 strings
  
  */
  
  static class TrieNode{
    char c;
    boolean isEnd;
    TrieNode[] tn;
    TrieNode(char c) {
      this.c=c;
      this.isEnd=false;
      this.tn = new TrieNode[26];
    }
  }
  static TrieNode root;
  public static void insert(String s, TrieNode root) {
    if(s == null || s.length()==0) return;
    for(int i=0;i<s.length();i++) {
      char c = s.charAt(i);
      if(root.tn[c-'a'] != null) root=root.tn[c-'a'];
      else {
        root.tn[c-'a'] = new TrieNode(c);
        root=root.tn[c-'a'];
      }
    }
    root.isEnd=true;
  }
  
  public static List<String> search(TrieNode node, List<String> ls,String sb) {
    if(node == null || ls.size() == 3) return ls;
    for(int i=0;i<26;i++) {
      TrieNode n = node.tn[i];
      if(n != null) {
        if(n.isEnd) {
          if(ls.size()<3) ls.add(sb + n.c);
          else return ls;
          search(n, ls, sb + n.c);
        }
        else search(n, ls, sb + n.c);
      }
    }
    return ls;
  }
  public List<List<String>> suggestedProducts(String[] pr, String sw) {
    root = new TrieNode('0');      
    for(int i=0;i<pr.length;i++) insert(pr[i],root);
    
    List<List<String>> ls = new ArrayList<>();
    StringBuilder sb1 = new StringBuilder();
    for(int i=0;i<sw.length();i++) {
      sb1.append(sw.charAt(i));
      TrieNode tmp = root;
      for(int j=0;j<sb1.length() && tmp != null;j++) {
        char ch = sb1.charAt(j);
        if(tmp.tn[ch-'a'] != null) tmp = tmp.tn[ch - 'a'];
        else tmp = null;
      }
      //System.out.println(sb1);
      List<String> l1 = new ArrayList<>();
      if(tmp!= null && tmp.isEnd) l1.add(sb1.toString());
      ls.add(search(tmp,l1, sb1.toString()));
    }
    return ls;
  }
}
