/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (25.56%)
 * Total Accepted:    387.2K
 * Total Submissions: 1.5M
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
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int halfLen = (m + n + 1) / 2;
        int imin = 0;
        int imax = m;

        while(imin < imax){
            int i = imin + (imax - imin) / 2;
            int j = halfLen - i;
            if (nums1[i] < nums2[j - 1]) {
                imin = i + 1;
            } else {
                imax = i;
            }
        }
        int i = imin;
        int j = halfLen - imin;
        int c1 = Math.max(i <= 0 ? Integer.MIN_VALUE : nums1[i - 1],
                         j <= 0? Integer.MIN_VALUE: nums2[j - 1]);
        if ((m + n) % 2 ==1) return c1;
        int c2 = Math.min(i >= m ? Integer.MAX_VALUE : nums1[i],
                         j >= n ? Integer.MAX_VALUE: nums2[j]);
        return (c1 + c2) / 2.0;
    }
}
