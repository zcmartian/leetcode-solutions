/*
 * @lc app=leetcode id=397 lang=java
 *
 * [397] Integer Replacement
 *
 * https://leetcode.com/problems/integer-replacement/description/
 *
 * algorithms
 * Medium (31.19%)
 * Total Accepted:    38.6K
 * Total Submissions: 123.8K
 * Testcase Example:  '8'
 *
 * 
 * Given a positive integer n and you can do operations as follow:
 * 
 * 
 * 
 * 
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * 
 * 
 * 
 * 
 * What is the minimum number of replacements needed for n to become 1?
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 8
 * 
 * Output:
 * 3
 * 
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * 7
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 * 
 * 
 */
class Solution {
    Map<Long,Integer> dp;
    public int integerReplacement(int n) {
        dp = new HashMap();
        return helper(n,0);
    }

    private int helper(long n, int steps) {
        if(dp.containsKey(n)){
            return steps+dp.get(n);
        }
        if(n==1){
            return steps;
        }
        if(n<=0){
            return Integer.MAX_VALUE;
        }
        int minS;
        if(n%2 ==0){
            minS =  helper(n/2, steps+1);
        } else {
            minS= Math.min(helper(n+1, steps+1), helper(n-1,steps+1));
        }
        dp.put(n , minS-steps);
        return minS;
    }
}
