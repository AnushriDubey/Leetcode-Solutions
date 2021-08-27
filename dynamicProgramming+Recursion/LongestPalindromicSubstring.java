/*
https://leetcode.com/problems/longest-palindromic-substring/

Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.


Description:
 
 if(even length)
 b a            a   b
   i           i+1
          |
          |
xxxxx         xxxxxx
len/2         len/2
(w/ i)        (w/o i)

diff will be 4 
for left we have to consider one less char left = i - (len-1/2)

 left = i - (len-1/2)
 if(even length) (len-1/2) it will give one less char 
 if(odd length) (len-1/2) value will not impact anything.
 odd length (n let say 5)
 (n-1)/2
 (5-1)/2; 
 

*/




class Solution {
    
    public static int expandAroundCentre(String str, int s, int e) {
        while(s>=0 && e<str.length() && str.charAt(s)==str.charAt(e)) {
            s--;
            e++;
        }
        return e-s-1;
    }
    
    
    public String longestPalindrome(String s) {
        int start = 0, end = -1;
        for(int i=0;i<s.length();i++) {
            int same = expandAroundCentre(s, i, i); // odd length strings
            int diff = expandAroundCentre(s, i, i+1); // even length strings
            int len = Math.max(same,diff);
            if(end-start+1 < len) {
                    start = i - (len-1)/2; //In case of even length from left side we have to consider one less char.
                    end = i+len/2;
                }
            }
        return s.substring(start, end+1);
        }
    }
