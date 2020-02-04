/*
 * @lc app=leetcode id=507 lang=java
 *
 * [507] Perfect Number
 *
 * https://leetcode.com/problems/perfect-number/description/
 *
 * algorithms
 * Easy (33.39%)
 * Total Accepted:    34.8K
 * Total Submissions: 104.3K
 * Testcase Example:  '28'
 *
 * We define the Perfect Number is a positive integer that is equal to the sum
 * of all its positive divisors except itself. 
 * 
 * Now, given an integer n, write a function that returns true when it is a
 * perfect number and false when it is not.
 * 
 * 
 * Example:
 * 
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * 
 * 
 * 
 * Note:
 * The input number n will not exceed 100,000,000. (1e8)
 * 
 */
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num<=0)
            return false;
        List<Integer> f = new ArrayList<>();
        int sum = 0;
        for(int i=1;i<num;i++) {
            if(num % i == 0)
                f.add(i);
        }
        for(int i : f) {
            sum += i;
        }
        return sum == num;
    }
}
