/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 *
 * https://leetcode.com/problems/candy/description/
 *
 * algorithms
 * Hard (27.73%)
 * Total Accepted:    97K
 * Total Submissions: 349.6K
 * Testcase Example:  '[1,0,2]'
 *
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * 
 * 
 * What is the minimum candies you must give?
 * 
 * Example 1:
 * 
 * 
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2,
 * 1, 2 candies respectively.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1,
 * 2, 1 candies respectively.
 * ⁠            The third child gets 1 candy because it satisfies the above two
 * conditions.
 * 
 * 
 */
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0)
            return 0;
        int ret = 1;
        int up = 0, down = 0, peak = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                peak = ++up;
                down = 0;
                ret += 1 + up;
            } else if (ratings[i - 1] == ratings[i])  {
                peak = up = down = 0;
                ret += 1;
            } else {
                up = 0;
                down++;
                ret += 1 + down + (peak >= down ? -1 : 0);
            }
        }

        return ret;        
    }
}
