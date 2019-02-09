class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        char[] cs = str.toCharArray();
        for(int i=0;i<cs.length;i++) {
            if(cs[i] >= 'A' && cs[i]<='Z') {
                char lc = (char) (cs[i] + 32); 
                sb.append(lc);
            } else {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }
}
