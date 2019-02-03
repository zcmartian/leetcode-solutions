#
# @lc app=leetcode id=720 lang=python
#
# [720] Longest Word in Dictionary
#
# https://leetcode.com/problems/longest-word-in-dictionary/description/
#
# algorithms
# Easy (43.52%)
# Total Accepted:    29.2K
# Total Submissions: 67.1K
# Testcase Example:  '["w","wo","wor","worl","world"]'
#
# Given a list of strings words representing an English Dictionary, find the
# longest word in words that can be built one character at a time by other
# words in words.  If there is more than one possible answer, return the
# longest word with the smallest lexicographical order.  If there is no answer,
# return the empty string.
# 
# Example 1:
# 
# Input: 
# words = ["w","wo","wor","worl", "world"]
# Output: "world"
# Explanation: 
# The word "world" can be built one character at a time by "w", "wo", "wor",
# and "worl".
# 
# 
# 
# Example 2:
# 
# Input: 
# words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
# Output: "apple"
# Explanation: 
# Both "apply" and "apple" can be built from other words in the dictionary.
# However, "apple" is lexicographically smaller than "apply".
# 
# 
# 
# Note:
# All the strings in the input will only contain lowercase letters.
# The length of words will be in the range [1, 1000].
# The length of words[i] will be in the range [1, 30].
# 
#
class TrieNode(object):
    def __init__(self):
        self.children=collections.defaultdict(TrieNode)
        self.isEnd=False
        self.word =''

class Trie(object):
    def __init__(self):
        self.root=TrieNode()

    def insert(self, word):
        node=self.root
        for c in word:
            node =node.children[c]
        node.isEnd=True
        node.word=word

    def bfs(self):
        q=collections.deque([self.root])
        res=''
        while q:
            cur=q.popleft()
            for n in cur.children.values():
                if n.isEnd:
                    q.append(n)
                    if len(n.word)>len(res) or n.word<res:
                        res=n.word
        return res

class Solution(object):
    def longestWord(self, words):
        trie = Trie()
        for w in words: trie.insert(w)
        return trie.bfs()
 
