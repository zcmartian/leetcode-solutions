#
# @lc app=leetcode id=643 lang=python
#
# [643] Maximum Average Subarray I
#
# https://leetcode.com/problems/maximum-average-subarray-i/description/
#
# algorithms
# Easy (38.62%)
# Total Accepted:    43.8K
# Total Submissions: 113.3K
# Testcase Example:  '[1,12,-5,-6,50,3]\n4'
#
# 
# Given an array consisting of n integers, find the contiguous subarray of
# given length k that has the maximum average value. And you need to output the
# maximum average value.
# 
# 
# Example 1:
# 
# Input: [1,12,-5,-6,50,3], k = 4
# Output: 12.75
# Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
# 
# 
# 
# Note:
# 
# 1 k n 
# Elements of the given array will be in the range [-10,000, 10,000].
# 
# 
#
class Solution(object):
    def findMaxAverage(self, nums, K):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        ma = float('-inf')        
        su = 0
        for i, x in enumerate(nums):
            su += x
            if i >= K:
                su -= nums[i-K]
            if i >= K - 1:
                ma = max(ma, su)
        return ma / float(K)
