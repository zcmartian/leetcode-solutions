/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 *
 * https://leetcode.com/problems/expression-add-operators/description/
 *
 * algorithms
 * Hard (32.48%)
 * Total Accepted:    65.4K
 * Total Submissions: 201.5K
 * Testcase Example:  '"123"\n6'
 *
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 * 
 * Example 1:
 * 
 * 
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"] 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * 
 * Example 3:
 * 
 * 
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * 
 * Example 4:
 * 
 * 
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: num = "3456237490", target = 9191
 * Output: []
 * 
 * 
 */
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<>();
        backTrack(res,num,0,(long)target,0,"");
        return res;
    }
    public void backTrack(List<String> res,String num,int start,long target,long pre,String path){
        if(start==num.length()&&target==0) res.add(path);
        for(int i=start;i<num.length();i++){
            if(i!=start&&num.charAt(start)=='0') break;
            String temp=num.substring(start,i+1);
            long cur=Long.parseLong(temp);
            if(start==0){
                backTrack(res,num,i+1,target-cur,cur,path+cur);
            }
            else{
                backTrack(res,num,i+1,target-cur,cur,path+"+"+cur);
                backTrack(res,num,i+1,target+cur,-cur,path+"-"+cur);
                backTrack(res,num,i+1,target+pre-pre*cur,pre*cur,path+"*"+cur);
            }
        }
    }
}
