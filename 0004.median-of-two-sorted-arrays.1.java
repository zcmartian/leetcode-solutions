/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (28.24%)
 * Likes:    5852
 * Dislikes: 881
 * Total Accepted:    586.4K
 * Total Submissions: 2.1M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 *
 * Example 2:
 *
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 *
 */

// @lc code=start
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Get the middle element
        int mid = (nums2.length+nums1.length+1)/2;
        //Find that middle element
        double res = getkth(nums1, nums2, mid);
        //If the combined length is even then find mid+1 element as well
        if((nums2.length+nums1.length) % 2 == 0) {
            res += getkth(nums1, nums2, mid+1);
            //Find the average of two elements
            res = res/2;
        }
        return res;
    }
    public int getkth(int[] A, int[] B, int k) {
        //Make sure array A is the smaller array
        if(B.length < A.length ) return getkth(B, A, k);
        //If smaller array is empty, simply return the value from second array
        if(A.length == 0) return B[k-1];
        //If k is 1, then it must be the smaller of first element of the array
        if(k == 1) return Math.min(A[0], B[0]);

        //Get the index for array A to compare
        int i = Math.min((A.length), k/2);
        //Index for array B must be such that i + j = k
        int j = k - i;

        //Remove the smaller elemets from the array A if, ith index of A is smaller than jth index of B
        if(A[i- 1] <  B[j-1]) {
            int[] newA = new int[A.length - i];
            //Make a new array and copy the rest of the array elements
            System.arraycopy(A, i, newA, 0, (A.length - i));
            return getkth(newA, B, k - i);
        }
        else {
            int[] newB = new int[B.length - j];
            System.arraycopy(B, j, newB, 0, (B.length - j));
            return getkth(A, newB, k - j);
        }
    }
}
// @lc code=end
