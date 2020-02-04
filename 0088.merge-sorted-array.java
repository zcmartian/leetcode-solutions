/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (34.39%)
 * Total Accepted:    312.3K
 * Total Submissions: 908.2K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to
 * m + n) to hold additional elements from nums2.
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<m && j<n) {
            if (nums1[i] <= nums2[j]) {
                tmp[k++] = nums1[i++];
            } else {
                tmp[k++] = nums2[j++];
            }
        }
        if (i < m) {
            for (int a = i; a < m; a++) {
                tmp[k++] = nums1[a];
            }
        } else if (j < n) {
            for (int b = j; b < n; b++) {
                tmp[k++] = nums2[b];
            }
        }
        for (int x = 0; x < m + n; x++) {
            nums1[x] = tmp[x];
        }
    }
}
