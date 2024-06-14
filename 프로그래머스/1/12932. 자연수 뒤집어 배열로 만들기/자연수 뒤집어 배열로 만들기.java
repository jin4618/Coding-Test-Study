import java.util.Arrays;
class Solution {
    public int[] solution(long n) {
        String is = String.valueOf(n);
        int[] answer = new int[is.length()];
        
        for(int i = 0; i < is.length(); i++) {
            answer[i] = Integer.parseInt(is.substring(is.length()-1-i, is.length()-i));
        }
        
        return answer;
    }
}