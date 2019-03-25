/*
 * @lc app=leetcode id=1020 lang=java
 *
 * [1020] Partition Array Into Three Parts With Equal Sum
 *
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/
 *
 * algorithms
 * Easy (50.10%)
 * Total Accepted:    3.8K
 * Total Submissions: 7.7K
 * Testcase Example:  '[0,2,1,-6,6,-7,9,1,2,0,1]'
 *
 * Given an array A of integers, return true if and only if we can partition
 * the array into three non-empty parts with equal sums.
 * 
 * Formally, we can partition the array if we can find indexes i+1 < j with
 * (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1]
 * + ... + A[A.length - 1])
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,2,1,-6,6,7,9,-1,2,0,1]
 * Output: false
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [3,3,6,5,-2,2,5,1,-9,4]
 * Output: true
 * Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 3 <= A.length <= 50000
 * -10000 <= A[i] <= 10000
 * 
 * 
 */
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int a : A) 
            sum += a;
        int res = sum % 3;
        if(res != 0) return false;
        sum = sum / 3;
        int sum_1 = 0;
        int i = 0;
        boolean found_1 = false;
        boolean found_2 = false;
        for(;i<A.length;i++) {
            sum_1 += A[i];
            if(sum_1 == sum) {
                found_1 = true;
                break;
            }
        }
        if(i==A.length-1) return false;
        i++;
        sum_1 = 0;
        for(;i<A.length;i++) {
            sum_1 += A[i];
            if(sum_1 == sum) {
                found_2 = true;
                break;
            }
        }
        sum_1 = 0;
        i++;
        for(;i<A.length;i++) {
            sum_1 += A[i];
        }
        return found_1 && found_2 && sum_1 == sum;
    }
}
