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
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) return findMedianSortedArrays(nums2, nums1);
        int k = (len1 + len2 + 1) / 2;
        int l = 0;
        int r = len1;
        //find the m1 so that nums1[m1] >= nums2[m2 - 1]
        while(l < r){
            int m1 = l + (r - l) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1]){
                l = m1 + 1;
            } else {
                r = m1;
            }
        }
        int m1 = l;
        int m2 = k - l;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                         m2 <= 0? Integer.MIN_VALUE: nums2[m2 - 1]);
        if ((len1 + len2) % 2 ==1) return c1;
        int c2 = Math.min(m1 >= len1 ? Integer.MAX_VALUE : nums1[m1],
                         m2 >= len2 ? Integer.MAX_VALUE: nums2[m2]);
        return (c1 + c2) / 2.0;
    }
}
