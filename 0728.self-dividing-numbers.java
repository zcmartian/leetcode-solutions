/*
 * @lc app=leetcode id=728 lang=java
 *
 * [728] Self Dividing Numbers
 *
 * https://leetcode.com/problems/self-dividing-numbers/description/
 *
 * algorithms
 * Easy (68.82%)
 * Total Accepted:    66.4K
 * Total Submissions: 96.5K
 * Testcase Example:  '1\n22'
 *
 * 
 * A self-dividing number is a number that is divisible by every digit it
 * contains.
 * 
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 ==
 * 0, and 128 % 8 == 0.
 * 
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * 
 * Given a lower and upper number bound, output a list of every possible self
 * dividing number, including the bounds if possible.
 * 
 * Example 1:
 * 
 * Input: 
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 
 * 
 * 
 * Note:
 * The boundaries of each input argument are 1 .
 * 
 */
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        for(int i =left;i<=right;i++) {
            if(check(i))
                ret.add(i);
        }
        return ret;
    }
    private boolean check(int i) {
        if(i==0)
            return false;
        int m = i;
        while(m!=0) {
            int t = m % 10;
            if(t==0)
                return false;
            if(i % t !=0)
                return false;
            m /= 10;
        }
        return true;
    }
}
