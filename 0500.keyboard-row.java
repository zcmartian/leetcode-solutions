/*
 * @lc app=leetcode id=500 lang=java
 *
 * [500] Keyboard Row
 *
 * https://leetcode.com/problems/keyboard-row/description/
 *
 * algorithms
 * Easy (61.42%)
 * Total Accepted:    80.4K
 * Total Submissions: 130.9K
 * Testcase Example:  '["Hello","Alaska","Dad","Peace"]'
 *
 * Given a List of words, return the words that can be typed using letters of
 * alphabet on only one row's of American keyboard like the image
 * below.
 * 
 * 
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 * 
 * 
 */
class Solution {
    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<3;i++) {
            for(char c : strs[i].toCharArray()){
                map.put(c, i);
            }
        }
        List<String> ret = new ArrayList<>();
        for(String w : words) {
            if(w.equals(""))
                continue;
            int index = map.get(w.toUpperCase().charAt(0));
            for(char c : w.toUpperCase().toCharArray()){
                if(map.get(c) != index){
                    index = -1;
                    break;
                }
            }
            if(index!=-1)
                ret.add(w);
        }
        return ret.toArray(new String[0]);
    }
}
