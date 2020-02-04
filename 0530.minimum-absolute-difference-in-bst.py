#
# @lc app=leetcode id=530 lang=python
#
# [530] Minimum Absolute Difference in BST
#
# https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
#
# algorithms
# Easy (49.44%)
# Total Accepted:    51.5K
# Total Submissions: 104.1K
# Testcase Example:  '[1,null,3,2]'
#
# Given a binary search tree with non-negative values, find the minimum
# absolute difference between values of any two nodes.
# 
# Example:
# 
# 
# Input:
# 
# ⁠  1
# ⁠   \
# ⁠    3
# ⁠   /
# ⁠  2
# 
# Output:
# 1
# 
# Explanation:
# The minimum absolute difference is 1, which is the difference between 2 and 1
# (or between 2 and 3).
# 
# 
# 
# 
# Note: There are at least two nodes in this BST.
# 
#
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def getMinimumDifference(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        L = []
        def dfs(node):
            if node.left:
                dfs(node.left)
            L.append(node.val)
            if node.right:
                dfs(node.right)
        dfs(root)
        return min(abs(a-b) for a, b in zip(L, L[1:]))
        
