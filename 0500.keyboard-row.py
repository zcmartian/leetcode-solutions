#
# @lc app=leetcode id=500 lang=python
#
# [500] Keyboard Row
#
# https://leetcode.com/problems/keyboard-row/description/
#
# algorithms
# Easy (61.42%)
# Total Accepted:    80.4K
# Total Submissions: 130.9K
# Testcase Example:  '["Hello","Alaska","Dad","Peace"]'
#
# Given a List of words, return the words that can be typed using letters of
# alphabet on only one row's of American keyboard like the image below.
# 
# 
# 
# 
# 
# 
# Example:
# 
# 
# Input: ["Hello", "Alaska", "Dad", "Peace"]
# Output: ["Alaska", "Dad"]
# 
# 
# 
# 
# Note:
# 
# 
# You may use one character in the keyboard more than once.
# You may assume the input string will only contain letters of alphabet.
# 
# 
#
class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        return filter(re.compile('(?i)([qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*)$').match, words) 
