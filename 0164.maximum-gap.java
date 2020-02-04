/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 *
 * https://leetcode.com/problems/maximum-gap/description/
 *
 * algorithms
 * Hard (31.84%)
 * Total Accepted:    66.2K
 * Total Submissions: 208K
 * Testcase Example:  '[3,6,9,1]'
 *
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 * (3,6) or (6,9) has the maximum difference 3.
 * 
 * Example 2:
 * 
 * 
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * 
 * Note:
 * 
 * 
 * You may assume all elements in the array are non-negative integers and fit
 * in the 32-bit signed integer range.
 * Try to solve it in linear time/space.
 * 
 * 如果数组中的元素个数小于2，直接返回0即可。
 * 对于n（n >= 2）个元素，假设其中的最大值是max，最小值是min。
 * 如果max和min相等，显然我们应该返回0。
 * 否则，为其准备n + 1个桶，每个桶中的数字区间尽量平均分配，即第一个桶中存放[min, min + capacity)区间内的数字，最后一个桶中存放[max - capacity, max]区间内的数字。显然，max和min已经保证了第一个桶和最后一个桶不是空桶。
 * 显然，将n个元素放进n + 1个桶里，至少会有一个空桶。同一个桶内的差值必然小于capacity，而间隔一个空桶的差值必然会大于capacity。因此，最大差值只可能在空桶的两边产生，即空桶的后一个非空桶的最小值减去空桶的前一个非空桶的最大值。
 * 由此计算方式，我们也可以发现，我们无需保存桶中的所有元素，只需保存桶中的最大值和最小值即可，即数组maxBuckets和minBuckets，其初始化均为-1，表示为空桶。
 * 如何一次遍历maxBuckets和minBuckets数组来求出最大差值呢？
 * 我们需要用一个pre指针保存前一个非空桶的最大值，由于min一定在第一个桶，所以第一个桶一定非空，这为我们的计算带来了方便。一旦遇到非空桶，我们就更新结果result和pre指针的值即可。
 * 时间复杂度和空间复杂度均是O(n)，其中n为数组中的元素个数。
 */
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        if(min == max){
            return 0;
        }
        int[] maxBuckets = new int[nums.length + 1];
        Arrays.fill(maxBuckets, -1);
        int[] minBuckets = new int[nums.length + 1];
        Arrays.fill(minBuckets, -1);
        int capacity = (int) Math.ceil((double) (max - min) / (nums.length + 1));
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - min) / capacity;
            if (nums[i] == max) {   //最大值放进最后一个桶里
                index = nums.length;
            }
            if (maxBuckets[index] == -1) {
                maxBuckets[index] = nums[i];
            } else if (nums[i] > maxBuckets[index]) {
                maxBuckets[index] = nums[i];
            }
            if (minBuckets[index] == -1) {
                minBuckets[index] = nums[i];
            } else if (nums[i] < minBuckets[index]) {
                minBuckets[index] = nums[i];
            }
        }
        int result = 0;
        int pre = maxBuckets[0];    //第一个桶有min，一定不是空桶
        for (int i = 1; i < maxBuckets.length; i++) {
            if (maxBuckets[i] != -1) {
                result = Math.max(result, minBuckets[i] - pre);
                pre = maxBuckets[i];
            }
        }
        return result;
    }
}
