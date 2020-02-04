#
# @lc app=leetcode id=485 lang=python
#
# [485] Max Consecutive Ones
#
# https://leetcode.com/problems/max-consecutive-ones/description/
#
# algorithms
# Easy (54.27%)
# Total Accepted:    118.2K
# Total Submissions: 217.8K
# Testcase Example:  '[1,0,1,1,0,1]'
#
# Given a binary array, find the maximum number of consecutive 1s in this
# array.
# 
# Example 1:
# 
# Input: [1,1,0,1,1,1]
# Output: 3
# Explanation: The first two digits or the last three digits are consecutive
# 1s.
# ⁠   The maximum number of consecutive 1s is 3.
# 
# 
# 
# Note:
# 
# The input array will only contain 0 and 1.
# The length of input array is a positive integer and will not exceed 10,000
# 
# 
#
class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = 0
        maxHere = 0
        for val in nums:
            maxHere = 0 if val == 0 else maxHere + 1
            ret = max(ret, maxHere)
        return ret

