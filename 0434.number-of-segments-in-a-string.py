#
# @lc app=leetcode id=434 lang=python
#
# [434] Number of Segments in a String
#
# https://leetcode.com/problems/number-of-segments-in-a-string/description/
#
# algorithms
# Easy (36.54%)
# Total Accepted:    50K
# Total Submissions: 136.8K
# Testcase Example:  '"Hello, my name is John"'
#
# Count the number of segments in a string, where a segment is defined to be a
# contiguous sequence of non-space characters.
# 
# Please note that the string does not contain any non-printable characters.
# 
# Example:
# 
# Input: "Hello, my name is John"
# Output: 5
# 
# 
#
class Solution(object):
    def countSegments(self, s):
        """
        :type s: str
        :rtype: int
        """
        return len(s.split())        
