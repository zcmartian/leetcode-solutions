/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (27.89%)
 * Total Accepted:    103.6K
 * Total Submissions: 371.6K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * Example:
 * 
 * 
 * Input: 
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0;i<board.length;i++) {
            for( int j=0;j<board[0].length;j++  ) {
                dfs(board, i, j, root, ret);
            }
        }
        return ret;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> ret) {
        char c = board[i][j];
        if(c == '#' || p.next[c - 'a'] == null)
            return;
        p = p.next[c - 'a'];
        if(p.word != null) {
            ret.add(p.word);
            p.word = null;
        }

        board[i][j] = '#';
        if(i > 0) dfs(board, i-1, j, p, ret);
        if(j > 0) dfs(board, i, j-1, p, ret);
        if(i < board.length-1) dfs(board, i+1, j, p, ret);
        if(j < board[0].length-1) dfs(board, i, j+1, p, ret);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String w : words) {
            TrieNode p = root;
            for(char c : w.toCharArray()) {
                int i = c - 'a';
                if(p.next[i] == null) 
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
