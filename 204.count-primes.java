/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (28.04%)
 * Total Accepted:    209K
 * Total Submissions: 745.4K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 */
class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int ans = 1;
        boolean[] isCompositeArr = new boolean[n];
        int upper = (int) Math.sqrt(n);
        for(int i = 3;i < n;i=i+2){//1.scan only odd number
            if(isCompositeArr[i]) continue;
            ans++;
            if(i > upper) continue;//2. avoid i^2 overflow.
            for(int j = i*i; j < n;j = j + 2*i){//3. initialize j to i^2
                                                //4. increase 2i to keep j as an odd number
                
                isCompositeArr[j] = true;
            }
        }
        return ans;        
    }
}
