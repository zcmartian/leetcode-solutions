/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (40.61%)
 * Total Accepted:    138.9K
 * Total Submissions: 342.1K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1:
 * 
 * 
 * Input: "hello"
 * Output: "holle"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "leetcode"
 * Output: "leotcede"
 * 
 * 
 * Note:
 * The vowels does not include the letter "y".
 * 
 * 
 * 
 */
class Solution {
    public String reverseVowels(String s) {
        if(s== null || s.length()==1)        
            return s;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int i=0;
        int j=s.length()-1;
        char[] ca = s.toCharArray();
        while(i<j){
            if(vowels.contains(ca[i]) && vowels.contains(ca[j])) {
                char c = ca[i];
                ca[i] = ca[j];
                ca[j] = c;
                i++;
                j--;
            }
            if(!vowels.contains(ca[i]))
                i++;
            if(!vowels.contains(ca[j]))
                j--;
        }
        return new String(ca);
    }
}
