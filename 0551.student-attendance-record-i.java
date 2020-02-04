/*
 * @lc app=leetcode id=551 lang=java
 *
 * [551] Student Attendance Record I
 *
 * https://leetcode.com/problems/student-attendance-record-i/description/
 *
 * algorithms
 * Easy (45.14%)
 * Total Accepted:    45.7K
 * Total Submissions: 101.3K
 * Testcase Example:  '"PPALLP"'
 *
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters:
 * 
 * 
 * 
 * 'A' : Absent. 
 * 'L' : Late.
 * ⁠'P' : Present. 
 * 
 * 
 * 
 * 
 * A student could be rewarded if his attendance record doesn't contain more
 * than one 'A' (absent) or more than two continuous 'L' (late).    
 * 
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 * 
 * Example 1:
 * 
 * Input: "PPALLP"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "PPALLL"
 * Output: False
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        char[] sc = s.toCharArray();
        int[] index = new int[s.length()];
        int k = 0;
        for(int i=0;i<s.length();i++){
            if(sc[i]=='A' && ++a > 1)
                return false;
            if(sc[i]=='L')
                index[k++] = i;
        }
        if(index.length<=2)
            return true;
        for(int i=0;i<index.length-2;i++){
            if(index[i+2]-index[i]==2)
                return false;
        }
        return true;
    }
}
