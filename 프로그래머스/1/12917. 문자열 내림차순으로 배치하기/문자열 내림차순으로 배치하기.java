import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] chArr = s.toCharArray();
        
        for(int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - 1; j++) {
                if((int) chArr[j] < (int) chArr[j + 1]) {
                    char temp = chArr[j];
                    chArr[j] = chArr[j + 1];
                    chArr[j + 1] = temp;
                }
            }
        }
        
        answer = new String(chArr);
        
        
        return answer;
    }
}