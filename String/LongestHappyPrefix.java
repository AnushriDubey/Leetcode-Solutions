/*

https://leetcode.com/problems/longest-happy-prefix/

A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.

 

Example 1:

Input: s = "level"
Output: "l"
Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".
Example 2:

Input: s = "ababab"
Output: "abab"
Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.
Example 3:

Input: s = "leetcodeleet"
Output: "leet"
Example 4:

Input: s = "a"
Output: ""
 

Constraints:

1 <= s.length <= 105
s contains only lowercase English letters.


*/


class Solution {
    public String longestPrefix(String s) {
        int len = 0, i = 1, n = s.length();
        
        int lps[] = new int[n];
        
        while(i<n) {
            if(s.charAt(len)==s.charAt(i)) {
                len++;
                lps[i]=len;
                i++;
            }
            else {
                if(len!=0) len = lps[len-1];
                else {
                    // no matching with zero index char as well.
                    lps[i]=0;
                    i++;
                }
            }
        }
        return s.substring(0,lps[n-1]);
    }
}
