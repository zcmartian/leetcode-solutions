/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (42.96%)
 * Total Accepted:    83.2K
 * Total Submissions: 193.5K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String addStrings(String num1, String num2) {
        char[] a = num1.toCharArray();        
        char[] b = num2.toCharArray();        
        for(int i=0,j=a.length-1;i<j;) {
            char t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
        for(int i=0,j=b.length-1;i<j;) {
            char t = b[i];
            b[i] = b[j];
            b[j] = t;
            i++;
            j--;
        }
        int carray = 0;
        Stack<String> list = new Stack<>();
        int n = Math.min(num1.length(), num2.length());
        for(int i=0;i<n;i++) {
            int sum = carray + (a[i]-'0') + (b[i]-'0');
            list.push(String.valueOf(sum % 10));
            carray = sum / 10;
        }
        if(a.length>b.length)
            for(int i=b.length;i<a.length;i++) {
                int sum = carray + (a[i]-'0');
                list.push(String.valueOf(sum % 10));
                carray = sum / 10;
            }
        else if(a.length<b.length)
            for(int i=a.length;i<b.length;i++) {
                int sum = carray + (b[i]-'0');
                list.push(String.valueOf(sum % 10));
                carray = sum / 10;
            }
        if(carray>0)
            list.push(String.valueOf(carray));
        StringBuilder sb = new StringBuilder();
        while(!list.empty()) {
            sb.append(list.pop());
        }
        return sb.toString();
    }
}
