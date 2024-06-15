import java.util.*;
class Solution {
    public Long solution(long n) {
        
        String[] is = String.valueOf(n).split("");
        
        Arrays.sort(is, Collections.reverseOrder());
        
        Long answer = Long.parseLong(String.join("", is));
        
        
        return answer;
    }
}