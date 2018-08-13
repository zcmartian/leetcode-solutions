public class Solution {
    public int removeDuplicates(int[] nums) {
        int newLength = 0;
        int length = nums.length;
        if (length==0)
            return 0;
            
        int key = nums[0];
        for (int i = 0; i<length;++i) {
            if (nums[i] != key) {
                nums[newLength++] = key;
            }
            key = nums[i];
        }
        nums[newLength++] = key;
        return newLength;
    }
}
