#
# @lc app=leetcode id=387 lang=python
#
# [387] First Unique Character in a String
#
# https://leetcode.com/problems/first-unique-character-in-a-string/description/
#
# algorithms
# Easy (48.67%)
# Total Accepted:    214.7K
# Total Submissions: 441.1K
# Testcase Example:  '"leetcode"'
#
# 
# Given a string, find the first non-repeating character in it and return it's
# index. If it doesn't exist, return -1.
# 
# Examples:
# 
# s = "leetcode"
# return 0.
# 
# s = "loveleetcode",
# return 2.
# 
# 
# 
# 
# Note: You may assume the string contain only lowercase letters.
# 
#
class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        letters = 'abcdefghijklmnopqrstuvwxyz'
        index = [s.index(l) for l in letters if s.count(l) == 1]
        return min(index) if len(index) > 0 else -1
