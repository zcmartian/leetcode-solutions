#
# @lc app=leetcode id=852 lang=python
#
# [852] Peak Index in a Mountain Array
#
# https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
#
# algorithms
# Easy (68.54%)
# Total Accepted:    51.3K
# Total Submissions: 74.8K
# Testcase Example:  '[0,1,0]'
#
# Let's call an array A a mountain if the following properties hold:
# 
# 
# A.length >= 3
# There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] <
# A[i] > A[i+1] > ... > A[A.length - 1]
# 
# 
# Given an array that is definitely a mountain, return any i such that A[0] <
# A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
# 
# Example 1:
# 
# 
# Input: [0,1,0]
# Output: 1
# 
# 
# 
# Example 2:
# 
# 
# Input: [0,2,1,0]
# Output: 1
# 
# 
# Note:
# 
# 
# 3 <= A.length <= 10000
# 0 <= A[i] <= 10^6
# A is a mountain, as defined above.
# 
# 
#
class Solution(object):
    def peakIndexInMountainArray(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        val = A[0]
        for val_ in A:
            if val_ < val:
                return A.index(val)
            elif val_ > val:
                val = val_
        return 0
        
