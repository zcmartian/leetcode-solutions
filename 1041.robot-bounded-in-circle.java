/*
 * @lc app=leetcode id=1041 lang=java
 *
 * [1041] Robot Bounded In Circle
 *
 * https://leetcode.com/problems/robot-bounded-in-circle/description/
 *
 * algorithms
 * Easy (37.94%)
 * Total Accepted:    2.9K
 * Total Submissions: 7.6K
 * Testcase Example:  '"GGLLGG"'
 *
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.
 * The robot can receive one of three instructions:
 * 
 * 
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degress to the right.
 * 
 * 
 * The robot performs the instructions given in order, and repeats them
 * forever.
 * 
 * Return true if and only if there exists a circle in the plane such that the
 * robot never leaves the circle.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "GGLLGG"
 * Output: true
 * Explanation: 
 * The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to
 * (0,0).
 * When repeating these instructions, the robot remains in the circle of radius
 * 2 centered at the origin.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "GG"
 * Output: false
 * Explanation: 
 * The robot moves north indefinetely.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "GL"
 * Output: true
 * Explanation: 
 * The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) ->
 * ...
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= instructions.length <= 100
 * instructions[i] is in {'G', 'L', 'R'}
 * 
 * 
 */
class Solution {
    private static int[][] directions = {{0,1}, {-1, 0}, {0, -1}, {1, 0}};
    public boolean isRobotBounded(String instructions) {
        char[] chars = instructions.toCharArray();
        int[] start = {0, 0};
        int index = 0;
        int times = 4;
        while(times > 0) {
            for(char c : chars) {
                if(c == 'L')
                    index = (index + 1) % 4;
                else if(c == 'R') {
                    index = index - 1;
                    if(index < 0)
                        index += 4;
                }
                else {
                    start[0] += directions[index][0];
                    start[1] += directions[index][1];
                }
            }
            if(start[0] == 0 && start[1] == 0)
                return true;
            times--;
        }
        return false;
    }
}
