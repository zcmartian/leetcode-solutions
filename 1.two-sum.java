/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (39.90%)
 * Total Accepted:    1.3M
 * Total Submissions: 3.4M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(nums[i], indices);
            }
        }
        int[] ret = new int[2];
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int a = entry.getKey();
            int b = target - a;
            if(b == a){
                if(map.containsKey(b)) {
                    ret[0] = entry.getValue().get(0);
                    ret[1] = entry.getValue().get(1);
                    return ret;
                }
            } else {
                if(map.containsKey(b)) {
                    ret[0] = entry.getValue().get(0);
                    ret[1] = map.get(b).get(0);
                    return ret;
                }
            }
        }
        return ret;
    }
}
