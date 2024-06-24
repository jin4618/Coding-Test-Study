import java.util.*;
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int total = 0;
        
        String xs = String.valueOf(x);
        
        for(int i = 0; i < xs.length(); i++) {
            total += Character.getNumericValue(xs.charAt(i));
        }
        
        if(x % total == 0) {
            answer = true;
        }
        else {
            answer = false;
        }
        
        return answer;
    }
}