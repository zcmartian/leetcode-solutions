#
# @lc app=leetcode id=905 lang=python
#
# [905] Sort Array By Parity
#
# https://leetcode.com/problems/sort-array-by-parity/description/
#
# algorithms
# Easy (71.64%)
# Total Accepted:    51.2K
# Total Submissions: 71.4K
# Testcase Example:  '[3,1,2,4]'
#
# Given an array A of non-negative integers, return an array consisting of all
# the even elements of A, followed by all the odd elements of A.
# 
# You may return any answer array that satisfies this condition.
# 
# 
# 
# 
# Example 1:
# 
# 
# Input: [3,1,2,4]
# Output: [2,4,3,1]
# The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
# 
# 
# 
# 
# Note:
# 
# 
# 1 <= A.length <= 5000
# 0 <= A[i] <= 5000
# 
# 
# 
#
class Solution(object):
    def sortArrayByParity(self, A):
        """
        :type A: List[int]
        :rtype: List[int]
        """
        size = len(A)
        res = [None] * size
        start = 0
        end = size - 1
        for val in A:
            if val % 2 ==1:
                res[end] = val
                end = end - 1
            else:
                res[start] = val
                start = start + 1
        return res
        
