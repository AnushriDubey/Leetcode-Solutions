/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].




*/


class Solution {
    
    static List<String> ls;
    static HashMap<Character, List<Character>> hm;
    public static void letterComb(String d, int i, StringBuilder sb) {
        if(i==d.length()) ls.add(new String(sb));
        else {
            for(Character c: hm.get(d.charAt(i))) {
                sb.append(c);
                letterComb(d,i+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    
    public List<String> letterCombinations(String digits) {
        ls = new ArrayList<>();
        hm = new HashMap<>();
        if(digits.length()==0) return ls;
        hm.put('2', new ArrayList<Character>(Arrays.asList('a','b','c')));
        hm.put('3', new ArrayList<Character>(Arrays.asList('d','e','f')));
        hm.put('4', new ArrayList<Character>(Arrays.asList('g','h','i')));
        hm.put('5', new ArrayList<Character>(Arrays.asList('j','k','l')));
        hm.put('6', new ArrayList<Character>(Arrays.asList('m','n','o')));
        hm.put('7', new ArrayList<Character>(Arrays.asList('p','q','r','s')));
        hm.put('8', new ArrayList<Character>(Arrays.asList('t','u','v')));
        hm.put('9', new ArrayList<Character>(Arrays.asList('w','x','y','z')));
        letterComb(digits,0,new StringBuilder());
        return ls;
    }
}
