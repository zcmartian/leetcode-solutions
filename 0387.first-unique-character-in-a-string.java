/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (48.67%)
 * Total Accepted:    214.7K
 * Total Submissions: 441.1K
 * Testcase Example:  '"leetcode"'
 *
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 */
class Solution {
    public int firstUniqChar(String s) {
        char[] ca = s.toCharArray();
        Map<Character, Integer> ms = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            if(ms.containsKey(ca[i])) {
                ms.put(ca[i], ms.get(ca[i]) + 1);
            }
            else {
                ms.put(ca[i], 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : ms.entrySet()){
            if(entry.getValue() == 1)
                return s.indexOf(entry.getKey());
        }
        return -1;
    }
}
