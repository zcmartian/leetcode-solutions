/*
 * @lc app=leetcode id=386 lang=java
 *
 * [386] Lexicographical Numbers
 *
 * https://leetcode.com/problems/lexicographical-numbers/description/
 *
 * algorithms
 * Medium (45.24%)
 * Total Accepted:    38.2K
 * Total Submissions: 84.4K
 * Testcase Example:  '13'
 *
 * Given an integer n, return 1 - n in lexicographical order.
 * 
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * 
 * Please optimize your algorithm to use less time and space. The input size
 * may be as large as 5,000,000.
 * 
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;++i)
            dfs(i, n, res);
        return res;
    }

    public void dfs(int cur, int n, List<Integer> res){
        if(cur>n)
            return;
        else {
            res.add(cur);
            for(int i=0;i<10;++i)
                dfs(10*cur+i, n, res);
        }
    }
}
