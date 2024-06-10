class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        
        String p = s.replace("p", "");
        String y = s.replace("y", "");
        
        int ps = s.length() - p.length();  
        int ys = s.length() - y.length();

        return ps == ys;
    }
}