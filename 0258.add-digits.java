/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 *
 * https://leetcode.com/problems/add-digits/description/
 *
 * algorithms
 * Easy (53.43%)
 * Total Accepted:    226.1K
 * Total Submissions: 423.2K
 * Testcase Example:  '38'
 *
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * Example:
 * 
 * 
 * Input: 38
 * Output: 2 
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 * 
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
class Solution {
    public int addDigits(int num) {
        if(num<10)
            return num;
        List<Integer> t = new ArrayList<>();
        int m = num;
        while(m != 0) {
            int c = m % 10;
            t.add(c);
            m /= 10;
        }
        int sum = 0;
        for(int i : t) {
            sum += i;
        }
        return addDigits(sum);
    }
}
