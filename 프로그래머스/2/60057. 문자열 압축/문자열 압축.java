class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int len = 1; len <= s.length() / 2; len++) {
            answer = Math.min(answer, compressStr(s, len));
        }
        return answer;
    }
    
    private int compressStr(String s, int len) {
        StringBuilder sb = new StringBuilder();
        String prevPattern = s.substring(0, len);
        int count = 1;
        
        for(int i = len; i < s.length(); i += len) {
            String nextPattern = i + len <= s.length() ? 
                s.substring(i, i + len) : s.substring(i);
                
            if(prevPattern.equals(nextPattern)) {
                count++;
            } else {
                if(count > 1) sb.append(count);
                sb.append(prevPattern);
                prevPattern = nextPattern;
                count = 1;
            }
        }
        
        if(count > 1) sb.append(count);
        sb.append(prevPattern);
        
        return sb.length();
    }
}