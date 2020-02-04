/*
 * @lc app=leetcode id=905 lang=java
 *
 * [905] Sort Array By Parity
 *
 * https://leetcode.com/problems/sort-array-by-parity/description/
 *
 * algorithms
 * Easy (71.64%)
 * Total Accepted:    51.2K
 * Total Submissions: 71.4K
 * Testcase Example:  '[3,1,2,4]'
 *
 * Given an array A of non-negative integers, return an array consisting of all
 * the even elements of A, followed by all the odd elements of A.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * 
 * 
 * 
 */
class Solution {
    public int[] sortArrayByParity(int[] A) {
	int[] ret = new int[A.length];
	int k = 0;
	int j = A.length - 1;
	for (int i = 0; k<=j; i++) {
	    if (A[i] % 2 == 0) {
	        ret[k++] = A[i];
	    } else {
		ret[j--] = A[i]; 
	    }
	}	
	return ret;
    }
}
