/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 *
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 *
 * algorithms
 * Easy (46.21%)
 * Total Accepted:    165.1K
 * Total Submissions: 357.3K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * 
 * 
 * Note:
 * 
 * 
 * Each element in the result should appear as many times as it shows in both
 * arrays.
 * The result can be in any order.
 * 
 * 
 * Follow up:
 * 
 * 
 * What if the given array is already sorted? How would you optimize your
 * algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is
 * better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 * 
 * 
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0 ; i < nums1.length; i++) {
            if (map1.containsKey(nums1[i])) {
                map1.put(nums1[i], map1.get(nums1[i])+1);
            } else {
                map1.put(nums1[i], 1);
            }
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0 ; i < nums2.length; i++) {
            if (map2.containsKey(nums2[i])) {
                map2.put(nums2[i], map2.get(nums2[i])+1);
            } else {
                map2.put(nums2[i], 1);
            }
        }
        Set<Integer> set1 = map1.keySet();
        Set<Integer> set2 = map2.keySet();
        set1.retainAll(set2);
        int index = 0;
        List<Integer> ret = new ArrayList<>();
        for (Integer key : set1) {
            int count = Math.min(map1.get(key), map2.get(key));
            for (int i = 0;i < count;i++) {
                ret.add(key);
            }
        }
        int[] retArray = new int[ret.size()];
        for (int i = 0;i<retArray.length;i++) {
            retArray[i] = ret.get(i);
        }
        return retArray;
    }
}
