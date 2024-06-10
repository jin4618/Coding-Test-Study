import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String ns = String.valueOf(n);
        
        for(int i = 0; i < ns.length(); i++) {
            answer += Character.getNumericValue(ns.charAt(i));
        }
        
        return answer;
    }
}