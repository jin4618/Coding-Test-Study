class Solution {
    public String solution(int n) {
        String answer = "";
        String wm = "수박";
        
        for(int i = 0; i < n/2; i++) {
            answer += wm;
        }
        
        if(n % 2 != 0) {
            answer += "수";
        }
            
        return answer;
    }
}