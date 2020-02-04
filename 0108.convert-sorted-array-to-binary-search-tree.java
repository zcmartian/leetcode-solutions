/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (48.41%)
 * Total Accepted:    226.3K
 * Total Submissions: 467.4K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Example:
 * 
 * 
 * Given the sorted array: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following
 * height balanced BST:
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int mid = (nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] leftArray = build(nums, 0, mid -1);// [0, mid - 1]
        int[] rightArray = build(nums, mid + 1, nums.length - 1);// [mid + 1, length -1]
        root.left = sortedArrayToBST(leftArray);
        root.right = sortedArrayToBST(rightArray);
        return root;
    }

    private int[] build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int len = right - left + 1;
        int[] ret = new int[len];
        for (int i = 0; i < len; i++ ) {
            ret[i] = nums[left + i];
        }
        return ret;
    }
}
