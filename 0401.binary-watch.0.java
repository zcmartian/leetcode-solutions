/*
 * @lc app=leetcode id=401 lang=java
 *
 * [401] Binary Watch
 *
 * https://leetcode.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (45.01%)
 * Total Accepted:    59.3K
 * Total Submissions: 131.8K
 * Testcase Example:  '0'
 *
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 * 
 * For example, the above binary watch reads "3:25".
 * 
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 * 
 * Example:
 * Input: n = 1Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04",
 * "0:08", "0:16", "0:32"]
 * 
 * 
 * Note:
 * 
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid,
 * it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for
 * example "10:2" is not valid, it should be "10:02".
 * 
 * 
 */
class Solution {
    private int[] watch = {1,2,4,8,1,2,4,8,16,32};
    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList<>();
        search(num, 0, 0, 0, ret);
        return ret;
    }
    private void search(int num, int hour, int minute, int start, List<String> list) {
        if(num<=0) {
            if(hour<12 && minute<60) {
                if(minute<10)
                    list.add(hour+":0"+minute);
                else
                    list.add(hour+":"+minute);
            }
        } else {
            for(int i=start;i<watch.length;i++) {
                if(i<4)
                    search(num-1, hour+watch[i], minute, i+1, list);
                else
                    search(num-1, hour, minute+watch[i], i+1, list);
            }
        }
    }
}
