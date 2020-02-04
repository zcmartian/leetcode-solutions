#
# @lc app=leetcode id=606 lang=python
#
# [606] Construct String from Binary Tree
#
# https://leetcode.com/problems/construct-string-from-binary-tree/description/
#
# algorithms
# Easy (50.85%)
# Total Accepted:    51.3K
# Total Submissions: 100.9K
# Testcase Example:  '[1,2,3,4]'
#
# You need to construct a string consists of parenthesis and integers from a
# binary tree with the preorder traversing way.
# 
# The null node needs to be represented by empty parenthesis pair "()". And you
# need to omit all the empty parenthesis pairs that don't affect the one-to-one
# mapping relationship between the string and the original binary tree.
# 
# Example 1:
# 
# Input: Binary tree: [1,2,3,4]
# ⁠      1
# ⁠    /   \
# ⁠   2     3
# ⁠  /    
# ⁠ 4     
# 
# Output: "1(2(4))(3)"
# Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to
# omit all the unnecessary empty parenthesis pairs. And it will be
# "1(2(4))(3)".
# 
# 
# 
# Example 2:
# 
# Input: Binary tree: [1,2,3,null,4]
# ⁠      1
# ⁠    /   \
# ⁠   2     3
# ⁠    \  
# ⁠     4 
# 
# Output: "1(2()(4))(3)"
# Explanation: Almost the same as the first example, except we can't omit the
# first parenthesis pair to break the one-to-one mapping relationship between
# the input and the output.
# 
# 
#
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def tree2str(self, t):
        """
        :type t: TreeNode
        :rtype: str
        """
        if not t: return ''
        left = '({})'.format(self.tree2str(t.left)) if (t.left or t.right) else ''
        right = '({})'.format(self.tree2str(t.right)) if t.right else ''
        return '{}{}{}'.format(t.val, left, right)
